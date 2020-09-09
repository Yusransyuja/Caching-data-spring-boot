package com.create.exp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web.security.configuration")
public class WebSecurityConfig {

	private String doLogin, doLogout, accessDenied;

	public String getDoLogin() {
		return doLogin;
	}

	public void setDoLogin(String doLogin) {
		this.doLogin = doLogin;
	}

	public String getDoLogout() {
		return doLogout;
	}

	public void setDoLogout(String doLogout) {
		this.doLogout = doLogout;
	}

	public String getAccessDenied() {
		return accessDenied;
	}

	public void setAccessDenied(String accessDenied) {
		this.accessDenied = accessDenied;
	}
	
	
}
