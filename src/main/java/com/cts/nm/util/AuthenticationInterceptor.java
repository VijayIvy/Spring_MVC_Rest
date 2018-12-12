package com.cts.nm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nm.constant.NMConstants;

public class AuthenticationInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest p_objRequest, HttpServletResponse p_objResponse, Object p_objHandler)
			throws Exception {
		String l_sUri = p_objRequest.getRequestURI();
		String l_sTokenTestxx = p_objRequest.getHeader("Content-Type");
		String l_sTokenTesAuthorization = p_objRequest.getHeader("Authorization");
		if (l_sUri.endsWith("authenticateUser")
				|| l_sUri.endsWith("callMailService") || l_sUri.endsWith("getUnitDetails")
				|| l_sUri.endsWith("getSubUnitDetails") || l_sUri.endsWith("getAnchors")
				|| l_sUri.endsWith("getProjectTypeDetails") || l_sUri.endsWith("getDirectors")
				|| l_sUri.endsWith("getLocations") || l_sUri.endsWith("saveWorkFlowRequest")
				|| l_sUri.endsWith("logout") || l_sUri.endsWith("retrieveWorkFlowDetails")
				|| l_sUri.endsWith("searchWorkFlowDetails") || l_sUri.endsWith("updateWorkFlowRequest")  ) {
			return true;
		} else {
			HttpSession l_objSession = p_objRequest.getSession();
			String l_sToken = (String) l_objSession.getAttribute("Authorization");

			if (l_sToken != null && !l_sToken.isEmpty()) {
				String l_sTokenTest = p_objRequest.getHeader(NMConstants.AUTHORIZATION);
				if (l_sTokenTest.equals(l_sToken)) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		}

	}

	public void postHandle(HttpServletRequest p_objRequest, HttpServletResponse p_objResponse, Object p_objHandler,
			ModelAndView p_objModel) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest p_objRequest, HttpServletResponse p_objResponse, Object p_objHandler,
			Exception p_objException) throws Exception {

	}

}
