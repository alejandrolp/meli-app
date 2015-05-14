class UrlMappings {

	static mappings = {

        "/"(controller: "employee", action:"listAllWithBirtdayInCurrentMonth")

		"/empleados"(resources: "empleado")
        //"/regalos"(resources: "regalo")

		// "/empleados" (controller: "empleado" , action: "index", method: "GET")
        // "/empleados" (controller: "empleado" , action: "save", method: "POST")

        // "/empleados/${id}" (controller: "empleado" , action: "delete", method: "DELETE")
        // "/empleados/${id}" (controller: "empleado" , action: "delete", method: "PUT")

        "/regalos" (controller: "regalo" , action: "index", method: "GET")
        "/regalos" (controller: "regalo" , action: "save", method: "POST")
        "/regalos/${id}" (controller: "regalo" , action: "show", method: "GET")
        "/gift/show/${id}" (controller: "regalo" , action: "show", method: "GET")
        "/regalos/${id}" (controller: "regalo" , action: "delete", method: "DELETE")


        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
        "500"(view:'/error')
	}
}
