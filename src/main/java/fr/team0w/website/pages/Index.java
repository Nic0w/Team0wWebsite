/**
 * 
 */
package fr.team0w.website.pages;

import org.apache.tapestry5.annotations.SessionState;

import fr.team0w.website.entities.UserSession;
import fr.team0w.website.security.AccessLevel;
import fr.team0w.website.security.Clearance;


/**
 * @author nic0w
 *
 */

@AccessLevel(Clearance.USER)
public class Index {
	
	 @SessionState
	 private UserSession session;
	 
	 public String getUserName() {
		 return session.getUser().getUserName(); 
	 }
	
}
