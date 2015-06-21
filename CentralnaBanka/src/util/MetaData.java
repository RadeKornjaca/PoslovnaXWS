package util;

import java.lang.reflect.Field;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Klasa MetaData opisuje imena atributa entiteta, njihove tipove i ogranicenja
 * nad tim atributima.
 * <p>Imena atributa ostaju ista za primitivne tipove. Reference su zamenjene
 * sa "zoom" na N strani, odnosno "link" ka 1 strani veze.</p>
 * @author Tim 5
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
		
		if (Restifyable.class.isAssignableFrom(field.getType())){
			type = "zoom";
		}
		else if (type.equals("Collection")){
			type = "link";
		}
		else if (field.isAnnotationPresent(Id.class)){
			type = "id";
		}
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
