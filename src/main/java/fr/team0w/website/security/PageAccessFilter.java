/**
 * 
 */
package fr.team0w.website.security;

import java.io.IOException;

import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.services.ApplicationStateManager;
import org.apache.tapestry5.services.ComponentEventRequestParameters;
import org.apache.tapestry5.services.ComponentRequestFilter;
import org.apache.tapestry5.services.ComponentRequestHandler;
import org.apache.tapestry5.services.ComponentSource;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Response;
import org.apache.tapestry5.services.Session;

import fr.team0w.website.entities.User;
import fr.team0w.website.entities.UserSession;
import fr.team0w.website.pages.Auth;

/**
 * @author nic0w
 *
 */
public class PageAccessFilter implements ComponentRequestFilter {

	private static final Class<Auth> AUTH_PAGE = Auth.class; 

	private final PageRenderLinkSource linkCreator;
	private final ComponentSource componentsSource;
	private final ApplicationStateManager appStateManager;
	
	
	private final Response response;
	private final Request request;


	/**
	 * 
	 */
	public PageAccessFilter(PageRenderLinkSource renderLinkSource, ComponentSource componentSource, Response response, Request request, ApplicationStateManager asm) {

		this.linkCreator = renderLinkSource;
		this.componentsSource = componentSource;
		this.response = response;
		this.appStateManager = asm;
		this.request = request;
	}


	@Override
	public void handleComponentEvent(ComponentEventRequestParameters parameters, ComponentRequestHandler handler) throws IOException {

		String pageName = parameters.getActivePageName();

		if(checkUserAccess(pageName))
			handler.handleComponentEvent(parameters);
		else {

			Link authLink = this.linkCreator.createPageRenderLink(AUTH_PAGE);

			this.response.sendRedirect(authLink);
		}
	}


	@Override
	public void handlePageRender(PageRenderRequestParameters parameters, ComponentRequestHandler handler) throws IOException {

		String pageName = parameters.getLogicalPageName();

		if(checkUserAccess(pageName))
			handler.handlePageRender(parameters);
		else {
			Link authLink = this.linkCreator.createPageRenderLink(AUTH_PAGE);

			this.response.sendRedirect(authLink);
		}


	}

	private boolean checkUserAccess(String pageName) {

		Component page = this.componentsSource.getPage(pageName);

		Class<?> pageClass = page.getClass();

		AccessLevel accessLevel = pageClass.getAnnotation(AccessLevel.class);

		if(accessLevel == null)
			throw new RuntimeException(
					String.format("SECURITY BREACH : annotation %s is not present on page %s !", AccessLevel.class.getSimpleName(), pageName)
					);

		

		UserSession session = this.appStateManager.getIfExists(UserSession.class);

		Clearance userClearance = Clearance.ANONYMOUS;
		
		if(session != null) {
			
			User user = session.getUser();
			
			if(user != null)
				userClearance = user.getClearance();	
		}
		

		System.out.println("User Clearance is : " + userClearance);
		
		return userClearance.compareTo(accessLevel.value()) >= 0;
	}



}
