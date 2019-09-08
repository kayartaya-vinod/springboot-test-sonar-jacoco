node {
	
    stage('SCM checkout') {
		git 'https://github.com/kayartaya-vinod/springboot-test-sonar-jacoco'
    }

	stage('Compile and package') {
		// get maven home path
		def mvnHome = tool name: 'maven-352', type: 'maven'
		sh "${mvnHome}/bin/mvn package"
	}
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
	stage('Deploy service'){
		sh "lsof -ti:8899 | xargs kill"
		// sh "java -jar -Dserver.port=8899 target/springboot-test.jar > /dev/null"
		// sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid || kill -KILL \$pid"
        withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
            sh "nohup mvn spring-boot:run -Dserver.port=8899 &"
        } 
	}


}