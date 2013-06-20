/**
 * 
 */
package fr.team0w.website.components;

import java.awt.Menu;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import fr.team0w.website.entities.UserSession;
import fr.team0w.website.pages.Auth;

/**
 * @author nic0w
 *
 */
public class Team0wLayout {

	/** The page title*/
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;
	
	@Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block menu;
	

	Object onActivate() {
		return null;
	}

}
