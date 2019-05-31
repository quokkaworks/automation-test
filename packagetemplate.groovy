					def paramJson = '${json}'

                	node {
        				stage('Configure') {
               				echo 'Building..'
        				}
       					stage('Extract') {
	               			bat( "echo 'Testing from within bat ..'" )
    	   				}
       					stage('Package') {
            	   			bat( "python -c 'a = 3; print(a)'" )            				
						}
                	}
