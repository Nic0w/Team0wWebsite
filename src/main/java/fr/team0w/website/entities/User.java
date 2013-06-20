/**
 * 
 */
package fr.team0w.website.entities;

import fr.team0w.website.security.Clearance;

/**
 * @author nic0w
 *
 */
public class User {

	private final String userName;
	private final Clearance clearanceLevel;

	public User(String userName, Clearance lvl) {
		
		this.clearanceLevel = lvl;
		this.userName = userName;
		
	}


	public Clearance getClearance() {
		return this.clearanceLevel;
	}


	public String getUserName() {
		return this.userName;
	}

}
