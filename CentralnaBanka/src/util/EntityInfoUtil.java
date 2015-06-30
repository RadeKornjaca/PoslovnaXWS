package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import util.annotations.Regex;

/**
 * Klasa sadrži metodu koja vraća polja entiteta u bazi podataka. Neophodna je
 * jer spoljna klasa ne može da pristupi privatnim atributima.
 * 
 * @author Tim 5
 *
 */

public final class EntityInfoUtil {
	/**
	 * Vraća atribute anotirane entity anotacijama. Ovi atributi predstavljaju
	 * polja entiteta u bazi podataka. Anotacije uzete u obzir:
	 * <ul>
	 * <li>@Column</li>
	 * <li>@OneToMany</li>
	 * <li>@OneToOne</li>
	 * <li>@ManyToMany</li>
	 * <li>@ManyToOne</li>
	 * </ul>
	 * 
	 * @param clazz
	 *            Klasa sa EJB anotacijama.
	 * 
	 * @return Lista MetaData objekata koji predstavljaju podatke o poljima.
	 */
	@SuppressWarnings("rawtypes")
	public static List<MetaData> getFields(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<MetaData> ret = new ArrayList<MetaData>();

		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				Regex regex = field.getAnnotation(Regex.class);
				Restriction restriction = new Restriction(column.length(),
						column.nullable(), column.unique(), regex.pattern());
				ret.add(new MetaData(field, restriction));
			} else if (field.isAnnotationPresent(OneToMany.class)
					|| field.isAnnotationPresent(ManyToMany.class)
					|| field.isAnnotationPresent(OneToOne.class)
					|| field.isAnnotationPresent(ManyToOne.class)) {
				Restriction restriction = new Restriction();
				ret.add(new MetaData(field, restriction));
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param params
	 *            - klju� je ime polja po kojoj se pristupa vrednosti upita. <br>
	 *            Npr. "nazivDrzave" je klju�, "Srbija" je vrednost, a
	 *            rezultuju�i upit je: <br>
	 * <br>
	 *            <i>nazivDrzave like 'Srbija'</i>.
	 *            <p>
	 *            REST upit za filtriranje je slede�eg oblika: <br>
	 *            <i>adresaServera/entitet?polje1=vrednost1&polje2=vrednost2</i>
	 *            </p>
	 *            <p>
	 *            Mo�e se ubaciti i sortiranje: <br>
	 *            <i>adresaServera/entitet?polje1=vrednost1&sort=polje1:asc,
	 *            polje2:desc</i>
	 *            </p>
	 * @param clazz
	 *            - klasa za koju se formira upit.
	 * @return - formirani upit kao string.
	 */
	@SuppressWarnings("rawtypes")
	public static String getQueryString(Class clazz,
			HashMap<String, String> params) throws QueryBuilderException {

		List<MetaData> metaList = getFields(clazz);
		String tableName = clazz.getSimpleName();

		/*
		 * Slu�i za proveru da li su parametri ispravni Npr. ako params sadr�i
		 * idDrzave, sa contains �e se proveriti da li idDrzave postoji kao
		 * polje entiteta
		 */
		HashMap<String, MetaData> fields = new HashMap<String, MetaData>();

		String sort = null;

		/*
		 * Sort se nalazi u parametrima, ali ne u�estvuje kao polje u select
		 * naredbi, pa se izbacuje iz parametara.
		 */
		if (params.containsKey("sort")) {
			sort = params.get("sort");
			params.remove("sort");
		}

		for (MetaData meta : metaList) {
			fields.put(meta.getName(), meta);
		}

		StringBuilder query = new StringBuilder();

		if (tableName != null) {
			query.append("SELECT x FROM " + tableName + " x");

			Iterator<String> it = params.keySet().iterator();
			// Ako je prazan selektuj sve
			if (!params.isEmpty()) {
				query.append(" WHERE ");
			}

			// Formiranje select naredbe
			// Prvo se upisuju polja koja se �itaju
			while (it.hasNext()) {
				String field = it.next();
				if (fields.containsKey(field)) {
					// Ako je string, radi se contains (za to su %)
					if (fields.get(field).getType().equals("String"))
						query.append("x." + field + " LIKE '%"
								+ params.get(field) + "%'");
					else
						query.append("x." + field + "=" + params.get(field));

					if (it.hasNext())
						query.append(" AND ");
				} else {
					throw new QueryBuilderException("Invalid SELECT field: "
							+ field);
				}

			}

			// Sort na kraju
			if (sort != null) {

				// Parovi polje:redosled
				String[] sortPairs = sort.split(",");

				query.append(" order by ");
				for (int i = 0; i < sortPairs.length; i++) {
					String[] sortParams = sortPairs[i].split(":");
					if (sortParams.length >= 2) {
						String fieldName = sortParams[0];
						String order = sortParams[1].toLowerCase();

						if (!order.equals("asc") && !order.equals("desc")) {
							throw new QueryBuilderException(
									"Invalid SORT order: " + order);
						}

						if (fields.containsKey(fieldName)) {
							query.append("x." + fieldName + " " + order);
						} else {
							throw new QueryBuilderException(
									"Invalid SORT field: " + fieldName);
						}

						if (i + 1 < sortPairs.length) {
							query.append(", ");
						}
					} else {
						throw new QueryBuilderException(
								"Invalid sort parameter: " + sortPairs[i]);
					}

				}

			}
		}
		return query.toString();
	}

	/**
	 * 
	 * @param clazz - klasa koja nasledjuje Restifyable
	 * @return - ime tabele u bazi podataka. Sluzi za REST.
	 */
	public static <T extends Restifyable> String getTableName(Class<T> clazz) {
		if (clazz.isAnnotationPresent(Table.class)){
			Table table = clazz.getAnnotation(Table.class);
			return "/"+table.name();
		}
		
		return null;

	}

}
