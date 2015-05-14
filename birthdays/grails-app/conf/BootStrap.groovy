import com.meli	.*

class BootStrap {

    def init = { servletContext ->

    	/*
    	def superUser = new RoleGroup( name: "ROLE_SUPER_USER" ).save(flush:true)  // Va a tener todos los ROLES

    	def appAdmin  = new RoleGroup( name: "ROLE_APP_ADMIN" ).save(flush:true)   // Va a tener todos los ROLES de APP
    	def appUser   = new RoleGroup( name: "ROLE_APP_USER" ).save(flush:true)    // Va a tener solo el ROL appRead

    	def apiAdmin  = new RoleGroup( name: "ROLE_API_ADMIN" ).save(flush:true)   // Va a tener todos los ROLES de API
    	def apiUser   = new RoleGroup( name: "ROLE_API_USER" ).save(flush:true)    // Va a tener solo el ROL apiGet
    	

    	def appRead   = new Role( authority: 'ROLE_APP_READ' ).save(flush:true)
    	def appCreate = new Role( authority: 'ROLE_APP_CREATE' ).save(flush:true)
    	def appUpdate = new Role( authority: 'ROLE_APP_UPDATE' ).save(flush:true)
    	def appDelete = new Role( authority: 'ROLE_APP_DELETE' ).save(flush:true)

    	def apiGet    = new Role( authority: 'ROLE_API_GET' ).save(flush:true)
    	def apiPost   = new Role( authority: 'ROLE_API_POST' ).save(flush:true)
    	def apiPut    = new Role( authority: 'ROLE_API_PUT' ).save(flush:true)
    	def apiDelete = new Role( authority: 'ROLE_API_UPDATE' ).save(flush:true)

    	// SUPER_USER
    	RoleGroupRole.create( superUser, appRead, true )
    	RoleGroupRole.create( superUser, appCreate, true )	
    	RoleGroupRole.create( superUser, appUpdate, true )
    	RoleGroupRole.create( superUser, appDelete, true )
    	RoleGroupRole.create( superUser, apiGet, true )
    	RoleGroupRole.create( superUser, apiPost, true )
    	RoleGroupRole.create( superUser, apiPut, true )
    	RoleGroupRole.create( superUser, apiDelete, true )

    	// APP_ADMIN
    	RoleGroupRole.create( appAdmin, appRead, true )
    	RoleGroupRole.create( appAdmin, appCreate, true )
    	RoleGroupRole.create( appAdmin, appUpdate, true )
    	RoleGroupRole.create( appAdmin, appDelete, true )

    	// APP_USER
    	RoleGroupRole.create( appUser, appRead, true )

    	// API_ADMIN
    	RoleGroupRole.create( apiAdmin, apiGet, true )
    	RoleGroupRole.create( apiAdmin, apiPost, true )
    	RoleGroupRole.create( apiAdmin, apiPut, true )
    	RoleGroupRole.create( apiAdmin, apiDelete, true )

    	// API_USER
    	RoleGroupRole.create( apiUser, apiGet, true )


    	def jp = new User( username: 'jp', password: 'jp' )
        jp.save( flush: true ) 

        def wo = new User( username: 'wo', password: 'wo' )
        wo.save( flush: true )

        def aa = new User( username: 'aa', password: 'aa' )
        aa.save( flush: true )

    	def usuario_api = new User( username: 'usuario_api', password: 'usuario_api' )
        usuario_api.save( flush: true )

        
        //un usuario puede tener varios roles UserRoleGroup
        
        UserRoleGroup.create( jp, superUser, true )
        UserRoleGroup.create( wo, apiAdmin, true )
        UserRoleGroup.create( aa, appUser, true )
        UserRoleGroup.create( usuario_api, apiUser, true )
        */



    }

    def destroy = {
    }
}
