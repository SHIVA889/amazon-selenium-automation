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
    
    
    post{
		
		always{
			echo 'Pipeline execution completed'
		}
		
		success{
			echo 'Automation tests passes successfully'
		}
		
		failure{
			echo 'Automation pipeline failed ' 
		}
	}
	
	
	
	
	
}  

