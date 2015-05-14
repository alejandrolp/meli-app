package com.meli

import grails.transaction.Transactional

@Transactional
class EmployeeService {

    List getAllEmployeeByBirthdayMonth(Integer aMonth) {
    	def query = Employee.where{
    		month(birthday) == aMonth
    	}
    	query.list()
    }


}
