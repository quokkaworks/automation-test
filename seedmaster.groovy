def prods = new groovy.json.JsonSlurper().parseText( readFileFromWorkspace( "dummy.json" ) )

prods.products.each {
  def prodName = it.name
  def prodVersion = it.version
  def json = groovy.json.JsonOutput.toJson( it )
  def jobName = "Worker-${prodName}-${prodVersion}".replaceAll('/','-')
  
  pipelineJob(jobName) {
	    
        definition {
    	    cps {
        	    sandbox()
            	script( readFileFromWorkspace( "template1.dsl" ).stripIndent() )
            }
        }
    }
}
