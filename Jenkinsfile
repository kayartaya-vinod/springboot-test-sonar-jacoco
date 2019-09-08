pipeline {
    agent any
    tools {
        maven 'maven-361'
        jdk 'jdk-8'
    }
    stages {
    	stage('SCM checkout') {
			git 'https://github.com/kayartaya-vinod/springboot-test-sonar-jacoco'
	    }
        stage ('Build') {
            steps {
            	sh 'mvn clean package'
            }
		}
	}
}