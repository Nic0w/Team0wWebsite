/**
 * 
 */
package fr.team0w.website.entities;


/**
 * @author nic0w
 *
 */
public class UserSession {

	private final long creationTime;
	
	private User user;
	
	public UserSession(long timestamp) {
		this.creationTime = timestamp;
		
		this.user = null;
		
	}

	public long getCreationTime() {
		return this.creationTime;
	}

	public User getUser() {
		return this.user;
	}
	
	public void setUser(User u) {
		this.user = u;
	}
}
