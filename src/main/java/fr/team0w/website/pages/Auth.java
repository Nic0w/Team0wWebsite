/**
 * 
 */
package fr.team0w.website.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

import fr.team0w.website.entities.User;
import fr.team0w.website.entities.UserSession;
import fr.team0w.website.security.AccessLevel;
import fr.team0w.website.security.Clearance;

/**
 * @author nic0w
 *
 */
@AccessLevel(Clearance.ANONYMOUS)
public class Auth {
	 
	 @Property
	 private String userName;
	 
	 @Component
	 private Form loginForm;
	 
	 @SessionState
	 private UserSession session;

	 
	Object onSuccessFromLoginForm() {
		
		session.setUser(new User(userName, Clearance.USER));
		
		System.out.println("Here we are ! Session created at " + session.getCreationTime());
		
		return Index.class;
	}
}
