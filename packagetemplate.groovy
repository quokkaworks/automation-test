					def paramJson = '${json}'

                	node {
        				stage('Configure') {
               				echo 'Chekcing out ..'
					checkout
        				}
       					stage('Extract') {
	               			bat( "echo 'Testing from within bat ..'" )
    	   				}
       					stage('Package') {
            	   			bat( "python donothing.py" )            				
						}
                	}
