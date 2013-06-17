/**
 * 
 */
package fr.team0w.website.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;

import fr.team0w.website.UserSession;

/**
 * @author nic0w
 *
 */
public class Auth {

	 @SessionState
	 private UserSession userSession;
	
	 private boolean userSessionExists;
	 
	 @Property
	 private String userName;
	 
	 @Component
	 private Form loginForm;
	 
	 Object onActivate() {
		return userSessionExists ? Index.class : null;
	}
	 
	 
	Object onSuccessFromLoginForm() {
		
		this.userSession = new UserSession(System.currentTimeMillis(), userName.trim());
		
		return Index.class;
	}
}
