/**
 * 
 */
package fr.team0w.website.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.team0w.website.UserSession;

/**
 * @author nic0w
 *
 */
public class Index {

	 @SessionState
	 @Property
	 private UserSession userSession;
	
	 private boolean userSessionExists;

	Object onActivate() {
		return userSessionExists ? null : Auth.class;
	}
	

}
