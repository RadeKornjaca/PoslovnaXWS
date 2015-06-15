package entity.fakture;

/**
 * Olaksava implementaciju generickog data access object bean-a. 
 *
 */
public interface Identifiable {

	public abstract Long getId();
	
	public abstract void setId(Long value);
	
}
