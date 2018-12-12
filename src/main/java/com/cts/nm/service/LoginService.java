package com.cts.nm.service;

import java.util.List;

import com.cts.nm.model.AuthenticateDTO;
import com.cts.nm.model.LoginWrapper;
import com.cts.nm.model.UserRoleDTO;

public interface LoginService {
	public List<AuthenticateDTO> userAuthentication(AuthenticateDTO p_objLoginWrapper);
	public List<UserRoleDTO> getUserRole(UserRoleDTO p_objUserRole);
}
