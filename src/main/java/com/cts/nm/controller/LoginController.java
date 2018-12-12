package com.cts.nm.controller;


import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.nm.constant.NMConstants;
import com.cts.nm.model.AuthenticateDTO;
import com.cts.nm.model.UserRoleDTO;
import com.cts.nm.service.LoginService;
import com.cts.nm.util.TokenUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {

	@Autowired
	private LoginService m_objLoginService;
	@Autowired
	private TokenUtil m_objTokenUtil;

	@RequestMapping(value = "authenticateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<AuthenticateDTO> authenticateUser(@RequestBody AuthenticateDTO p_authenticateDTO,
			HttpServletRequest p_objRequest, HttpServletResponse p_objresponse) {
		HttpSession l_objSession = p_objRequest.getSession();
		List<AuthenticateDTO> l_onjAssignedDTO = new ArrayList<AuthenticateDTO>();
		String l_sToken = m_objTokenUtil.getToken();
		String l_sUserName = null;
		String l_sUserRole = null;
		String l_sUserLoginStatusMsg = null;
		try {
			p_authenticateDTO.setHeaderToken(l_sToken);
			l_onjAssignedDTO = m_objLoginService.userAuthentication(p_authenticateDTO);
			for (AuthenticateDTO l_objLoginAuthenticate : l_onjAssignedDTO) {
				l_sUserLoginStatusMsg = l_objLoginAuthenticate.getLoginStatusMsg();
				l_sUserName = l_objLoginAuthenticate.getUserName();
				l_sUserRole = l_objLoginAuthenticate.getUserRole();
			}
			if (l_sUserLoginStatusMsg.equals(NMConstants.NM_VALID_USER_MSG)) {
				l_objSession.setAttribute(NMConstants.NM_USER, l_sUserName);
				l_objSession.setAttribute(NMConstants.AUTHORIZATION, "Bearer " + l_sToken);
				l_objSession.setAttribute(NMConstants.NM_ROLE, l_sUserRole);
				
			}

			System.out.println("ResponseHeader:   " + l_sToken);
			p_objresponse.setHeader(NMConstants.AUTHORIZATION, l_sToken);
		} catch (Exception p_objExp) {

		}
		return l_onjAssignedDTO;
	}

	@RequestMapping(value = "userRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<UserRoleDTO> getUserRole(HttpServletRequest p_objRequest) {
		HttpSession l_objSession = p_objRequest.getSession();
		List<UserRoleDTO> m_objGetUserRole = new ArrayList<UserRoleDTO>();
		UserRoleDTO m_objGetUserRoleDTO = new UserRoleDTO();
		try {
			String l_sUserName = (String) l_objSession.getAttribute((NMConstants.NM_USER));
			String l_sUserRole = (String) l_objSession.getAttribute((NMConstants.NM_ROLE));
			m_objGetUserRoleDTO.setUserName(l_sUserName);
			m_objGetUserRole = m_objLoginService.getUserRole(m_objGetUserRoleDTO);

		} catch (Exception p_objExp) {

		}
		return m_objGetUserRole;
	}

	/*@RequestMapping(value = "logout", method = RequestMethod.POST)
	public void logout(HttpServletRequest p_objRequest, HttpServletResponse p_objresponse) {

		HttpSession l_objSession = p_objRequest.getSession();
		if (l_objSession != null) {
			l_objSession.setAttribute(NMConstants.NM_USER, null);
			l_objSession.setAttribute(NMConstants.NM_TOKEN, null);
			l_objSession.setAttribute(NMConstants.NM_ROLE, null);
			l_objSession.invalidate();
		}
	}*/
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public AuthenticateDTO logout(HttpServletRequest p_objRequest, HttpServletResponse p_objresponse) {
		AuthenticateDTO l_objAssignedDTO = new AuthenticateDTO();
		HttpSession l_objSession = p_objRequest.getSession();
		if (l_objSession != null) {
			l_objSession.setAttribute(NMConstants.NM_USER, null);
			l_objSession.setAttribute(NMConstants.NM_TOKEN, null);
			l_objSession.setAttribute(NMConstants.NM_ROLE, null);
			l_objSession.invalidate();
			l_objAssignedDTO.setLogOutStatusMsg(NMConstants.NM_LOGOUT);
		}
		return l_objAssignedDTO;
	}
}
