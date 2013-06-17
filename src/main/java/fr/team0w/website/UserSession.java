/**
 * 
 */
package fr.team0w.website;

/**
 * @author nic0w
 *
 */
public class UserSession {

	private final long loginTime;
	
	private final String userName;
	
	public UserSession(long timestamp, String userName) {
		
		this.loginTime = timestamp;
		this.userName = userName;
		
	}

	public long getLoginTime() {
		return loginTime;
	}

	public String getUserName() {
		return userName;
	}
	
}
