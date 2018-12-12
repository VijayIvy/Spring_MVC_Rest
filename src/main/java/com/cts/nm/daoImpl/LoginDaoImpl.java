package com.cts.nm.daoImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.nm.constant.NMConstants;
import com.cts.nm.dao.LoginDao;
import com.cts.nm.model.AuthenticateDTO;
import com.cts.nm.model.LoginVO;
import com.cts.nm.model.LoginWrapper;
import com.cts.nm.model.UserRoleDTO;

@Scope("prototype")
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private NamedParameterJdbcTemplate m_objNamedParameterJdbcTemplate;

	private DataSource m_objDataSource;

	public Properties getPropValuesForQuery() throws IOException {
		Properties l_objProps = new Properties();
		InputStream l_objInputStream = getClass().getClassLoader().getResourceAsStream("query.properties");
		l_objProps.load(l_objInputStream);
		return l_objProps;
	}

	public void setDataSource(DataSource p_objDataSource) {
		this.m_objDataSource = p_objDataSource;
		this.m_objNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(p_objDataSource);
	}

	public List<Map<String, Object>> userAuthentication(AuthenticateDTO p_objAuthenticateDTO) {

		List<Map<String, Object>> m_lstData = null;
		try {

			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("USER_NAME", p_objAuthenticateDTO.getUserName());
			l_mapAttributes.put("PASSWORD", p_objAuthenticateDTO.getPassword());

			m_lstData = m_objNamedParameterJdbcTemplate
					.queryForList(getPropValuesForQuery().getProperty("getUserAuthenticate"), l_mapAttributes);

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_lstData;
	}

	public String getUserRole(UserRoleDTO p_objUserRole) {
		String m_sGetUserRole = null;
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("USER_NAME", p_objUserRole.getUserName());

			m_sGetUserRole = m_objNamedParameterJdbcTemplate
					.queryForObject(getPropValuesForQuery().getProperty("getUserRole"), l_mapAttributes, String.class);

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_sGetUserRole;
	}
}
