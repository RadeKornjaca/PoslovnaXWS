package util;

import java.lang.reflect.Field;

/**
 * Klasa MetaData opisuje imena atributa entiteta, njihove tipove i ograničenja
 * nad tim atributima.
 * 
 * @author Lazar
 *
 */
public class MetaData {

	private String name;
	private String type;
	private Restriction restriction;

	public MetaData() {

	}

	public MetaData(Field field, Restriction restriction) {
		name = field.getName();
		type = field.getType().getSimpleName();
		this.restriction = restriction;
	}

	public Restriction getRestriction() {
		return restriction;
	}

	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
