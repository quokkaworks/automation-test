					def paramJson = '${json}'

                	node {
        				stage('Configure') {
               				echo 'Checking out ..'
					checkout scm
        				}
       					stage('Extract') {
	               			bat( "echo 'Testing from within bat ..'" )
    	   				}
       					stage('Package') {
            	   			bat( "python donothing.py" )            				
						}
                	}
