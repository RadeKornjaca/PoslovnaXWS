/***********************************************************************
 * Module:  Mt9xy.java
 * Author:  Nenad
 * Purpose: Defines the Class Mt9xy
 ***********************************************************************/

package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/** @pdOid 928b7313-3d67-4770-99f2-90dc6a721a77 */
@Entity
@DiscriminatorValue("mt9xy")
public class Mt9xy extends Poruka {
	
	@ManyToOne
	@JoinColumn(name = "id_poruke", referencedColumnName = "id_poruke", nullable = false)
	private Mt10x mt10x;
}