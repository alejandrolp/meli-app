package com.meli

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

class LoginController{
	
	def springSecurityService

 	//@Secured(['SUPER_USER', 'APP_USER'])
	def logout() {
		session.invalidate()
		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl
	}
}