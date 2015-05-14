package com.meli

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

import org.springframework.web.servlet.ModelAndView

import spock.lang.Specification
/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeController)
@Mock(EmployeeService)
class EmployeeControllerSpec extends Specification {


    def setup() {
    	def employeeService = mockFor(EmployeeService)
        employeeService.demand.getAllEmployeeByBirthdayMonth { Integer currentMonth -> return [] }
        controller.employeeService = employeeService.createMock()
    }

    def cleanup() {
    }


    void "deberia redireccionar a la vista listAllWithBirtdayInCurrentMonth al invocar el metodo listAllWithBirtdayInCurrentMonth del controller"() {
        when: "Al invocar el metodo del controller"
        ModelAndView mv = controller.listAllWithBirtdayInCurrentMonth()
        then: "La vista deberia ser ..."
        assert mv.viewName == 'listAllWithBirtdayInCurrentMonth'
    }
	
	void "asdfdeberia redireccionar a la vista listAllWithBirtdayInCurrentMonth al invocar el metodo listAllWithBirtdayInCurrentMonth del controller"() {
		when: "Al invocar el metodo del controller"
		ModelAndView mv = controller.listAllWithBirtdayInCurrentMonth()
		
	
		then: "La vista deberia ser ..."
		assert mv.model['employeeList'] == []
	}

}
