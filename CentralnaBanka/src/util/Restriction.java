package util;

/**
 * Opisuje ograni�enja nad obele�jem baze. Slu�i za slanje podataka potrebnih za
 * generisanje forme u Angularjs aplikaciji.
 * 
 * @author Lazar
 *
 */
public class Restriction {

	private int length;
	private boolean nullable;
	private boolean unique;
	private String regex;
	
	public Restriction() {

	}

	public Restriction(int length, boolean nullable, boolean unique) {
		super();
		this.length = length;
		this.nullable = nullable;
		this.unique = unique;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	

}
