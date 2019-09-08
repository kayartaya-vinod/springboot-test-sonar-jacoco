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
	    def mvnHome = tool name: 'maven-352', type: 'maven'
	    sh "${mvnHome}/bin/mvn sonar:sonar"
	}
	stage('SonarQube quality gate'){
	    timeout(time: 1, unit: 'HOURS'){
			def qg = waitForQualityGate() 
	        if(qg.status != 'OK'){
				error "Pipeline aborted due to quality gate failure: ${qg.status}"
			}
		}
	}

}
