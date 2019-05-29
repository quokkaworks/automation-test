def prods = new groovy.json.JsonSlurper().parseText( readFileFromWorkspace( "dummy.json" ) )

prods.products.each {
  def prodName = it.name
  def prodVersion = it.version
  def prodTemplate = it.jobTemplate
  def json = groovy.json.JsonOutput.toJson( it )
  def jobName = "Worker-${prodName}-${prodVersion}".replaceAll('/','-')
  
  pipelineJob(jobName) {
	description( "This job builds the product ${prodName}-${prodVersion}" )
	
	triggers {
		cron( "H 21 * * *" )
	}
	  
        definition {
    	    cpsScm {
		    scm {
			    github( "quokkaworks/automation-test" )
		    }
		    scriptPath( prodTemplate )
	    }
        }
	  
	disabled()
    }
}
