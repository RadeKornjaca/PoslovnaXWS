package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Klasa sadrži metodu koja vraæa polja entiteta u bazi podataka.
 * Neophodna je jer spoljna klasa ne može da pristupi privatnim atributima.
 * @author Tim 5
 *
 */

public final class EntityInfoUtil {
	/**
	 * Vraæa atribute anotirane entity anotacijama. Ovi atributi predstavljaju
	 * polja entiteta u bazi podataka. Anotacije uzete u obzir:
	 * <ul>
	 * <li>@Column</li>
	 * <li>@OneToMany</li>
	 * <li>@OneToOne</li>
	 * <li>@ManyToMany</li>
	 * <li>@ManyToOne</li>
	 * </ul>
	 * @param clazz Klasa sa EJB anotacijama.
	 * 
	 * @return Lista MetaData objekata koji predstavljaju podatke o poljima.
	 */
	public static List<MetaData> getFields(Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<MetaData> ret = new ArrayList<MetaData>();

		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Column.class)
					|| field.isAnnotationPresent(OneToMany.class)
					|| field.isAnnotationPresent(ManyToMany.class)
					|| field.isAnnotationPresent(OneToOne.class)
					|| field.isAnnotationPresent(ManyToOne.class)) {
				ret.add(new MetaData(field));
			}
		}
		return ret;
	}
}
