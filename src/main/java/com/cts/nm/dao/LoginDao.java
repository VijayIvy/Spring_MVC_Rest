package com.cts.nm.dao;


import java.util.List;
import java.util.Map;

import com.cts.nm.model.AuthenticateDTO;
import com.cts.nm.model.UserRoleDTO;

public interface LoginDao {
	public List<Map<String, Object>> userAuthentication(AuthenticateDTO l_objGetAuthenticateDTO);
	public String getUserRole(UserRoleDTO p_objUserRole);
}
