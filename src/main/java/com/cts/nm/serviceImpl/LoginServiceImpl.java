package com.cts.nm.serviceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cts.nm.constant.NMConstants;
import com.cts.nm.dao.LoginDao;
import com.cts.nm.model.AuthenticateDTO;
import com.cts.nm.model.LoginVO;
import com.cts.nm.model.LoginWrapper;
import com.cts.nm.model.UserRoleDTO;
import com.cts.nm.service.LoginService;

@Service
@Scope("prototype")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao m_objLoginDao;

	public List<AuthenticateDTO> userAuthentication(AuthenticateDTO p_objLoginWrapper) {
		List<AuthenticateDTO> l_objGetuserLoginStatus = new ArrayList<AuthenticateDTO>();
		AuthenticateDTO l_objGetAuthenticateDTO = new AuthenticateDTO();
		// String m_sData=null;
		List<Map<String, Object>> m_lstData = null;
		try {
			/*//for (LoginVO l_objLoginVO : p_objLoginWrapper.) {
				l_objGetAuthenticateDTO.setUserName(p_objLoginWrapper.getUserName());
				l_objGetAuthenticateDTO.setPassword(p_objLoginWrapper.getPassword());
			//}
*/			m_lstData = m_objLoginDao.userAuthentication(p_objLoginWrapper);

			if (m_lstData != null && !m_lstData.isEmpty()) {
				for (Map<String, Object> m_lstMapValue : m_lstData) {
					AuthenticateDTO l_objAuthenticateUser = new AuthenticateDTO();

					l_objAuthenticateUser.setUserName(m_lstMapValue.get("USER_NAME").toString());
					l_objAuthenticateUser.setUserRole(m_lstMapValue.get("ROLE_ID").toString());
					l_objAuthenticateUser.setLoginStatusMsg(NMConstants.NM_VALID_USER_MSG);
					l_objAuthenticateUser.setHeaderToken("Bearer " + p_objLoginWrapper.getHeaderToken());
					l_objGetuserLoginStatus.add(l_objAuthenticateUser);
				}

			} else {
				AuthenticateDTO l_objAuthenticateUserInvalid = new AuthenticateDTO();
				l_objAuthenticateUserInvalid.setLoginStatusMsg(NMConstants.NM_INVALID_USER_MSG);
				l_objGetuserLoginStatus.add(l_objAuthenticateUserInvalid);
			}

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return l_objGetuserLoginStatus;
	}

	public List<UserRoleDTO> getUserRole(UserRoleDTO p_objUserRoleDTO) {
		List<UserRoleDTO> m_objGetUserRole = new ArrayList<UserRoleDTO>();
		String m_sGetUserRole = null;
		try {
			m_sGetUserRole = m_objLoginDao.getUserRole(p_objUserRoleDTO);
			if (m_sGetUserRole != null && !m_sGetUserRole.isEmpty()) {
				UserRoleDTO l_objGetUserRole = new UserRoleDTO();
				l_objGetUserRole.setUserRole(m_sGetUserRole);
				m_objGetUserRole.add(l_objGetUserRole);
			}
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_objGetUserRole;
	}
}
