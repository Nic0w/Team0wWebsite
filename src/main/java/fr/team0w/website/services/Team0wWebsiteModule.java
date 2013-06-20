/**
 * 
 */
package fr.team0w.website.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.services.ApplicationStateContribution;
import org.apache.tapestry5.services.ApplicationStateCreator;
import org.apache.tapestry5.services.ApplicationStateManager;
import org.apache.tapestry5.services.ComponentRequestFilter;
import org.apache.tapestry5.services.ComponentRequestHandler;

import fr.team0w.website.entities.User;
import fr.team0w.website.entities.UserSession;
import fr.team0w.website.security.PageAccessFilter;

/**
 * @author nic0w
 *
 */
public class Team0wWebsiteModule {

	
	/*public static void bind(ServiceBinder binder) {  

		binder.bind(UserSession.class);

	}*/

	@Contribute(ComponentRequestHandler.class)
	public void contributeComponentRequestHandler(OrderedConfiguration<ComponentRequestFilter> configuration) {

		configuration.addInstance("AccessFilter", PageAccessFilter.class);
	}

	
	@Contribute(ApplicationStateManager.class)
	public void contributeApplicationStateManager(MappedConfiguration<Class, ApplicationStateContribution> configuration) {
		
		ApplicationStateCreator<UserSession> userSessionCreator = new ApplicationStateCreator<UserSession>() {
			@Override
			public UserSession create() {
				
				return new UserSession(System.currentTimeMillis());
			}
		};

		configuration.add(UserSession.class, new ApplicationStateContribution("session", userSessionCreator));
	}

}
