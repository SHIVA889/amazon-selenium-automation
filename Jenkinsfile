// CI pipeline for Amazon automation framework

pipeline {

    agent any
    stages {
        stage('Build') {

            steps {

                bat 'mvn clean test'
            }
        }
        
      	stage('Test'){
			
			steps{
				bat 'mvn test'
			}
		}
		
		stage('Publish and Reslt'){
			steps{
				junit 'target/surefire-reports/*.xml'
			}
		}
    }
}  