pipeline {
    stages {
	    stage('SCM checkout') {
			git 'https://github.com/kayartaya-vinod/springboot-test-sonar-jacoco'
	    }
	
		stage('Compile and package') {
			// get maven home path
			def mvnHome = tool name: 'maven-352', type: 'maven'
			sh "${mvnHome}/bin/mvn package"
		}
		/*
		stage('SonarQube analysis'){
		    withSonarQubeEnv('sonar-server'){
		        def mvnHome = tool name: 'maven-352', type: 'maven'
		    	sh "${mvnHome}/bin/mvn sonar:sonar"
		    }
	
		}
		stage('SonarQube quality gate'){
			withSonarQubeEnv('sonar-server') {
			    timeout(time: 1, unit: 'HOURS'){
					def qg = waitForQualityGate() 
			        if(qg.status != 'OK'){
						error "Pipeline aborted due to quality gate failure: ${qg.status}"
					}
				}		    
			}
		}
		*/
		stage('Docker image') {
			//def dockerHome = tool name: 'Docker'
			//sh "sudo ${dockerHome}/bin/docker build -f Dockerfile -t springboot-test ."
			steps{
				script {
					docker.build("springboot-test")
				}
			}
		}			
	    /*
	    stage ('Docker deploy') {
	    	sh "sudo ${dockerHome}/bin/docker run -t --name springboot-test -p 8899:8899 springboot-test"
	    }
	    */        
    }


}
