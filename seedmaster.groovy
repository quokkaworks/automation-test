def prods = new groovy.json.JsonSlurper().parseText( readFileFromWorkspace( "dummy.json" ) )

prods.products.each {
  def prodName = it.name
  def prodVersion = it.version
  def json = groovy.json.JsonOutput.toJson( it )
  def jobName = "Worker-${prodName}-${prodVersion}".replaceAll('/','-')
  
  pipelineJob(jobName) {
	description( "This job builds the product ${prodName}-${prodVersion}" )
	
	triggers {
		cron( "0 21 * * *" )
	}
	  
        definition {
    	    cps {
        	    sandbox()
            	script( readFileFromWorkspace( "template1.dsl" ).stripIndent() )
            }
        }
	  
	disabled()
	  
    }
}
