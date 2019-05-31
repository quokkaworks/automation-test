					def paramJson = '${json}'

                	node {
        				stage('Configure') {
               				echo 'Checking out ..'
        				}
       					stage('Extract') {
	               			bat( "echo 'Testing from within bat ..'" )
    	   				}
       					stage('Package') {
            	   			bat( "cat donothing.py" )            				
						}
                	}
