// CI pipeline 
pipeline {
    agent any

    stages {
        stage('Build & Compile') {
            steps {
                // 'mvn clean compile' prepares the project without running tests yet
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                // This executes test cases 
                bat 'mvn test'
            }
        }
		
        stage('Publish Results') {
            steps {
                // Captures and displays  TestNG/JUnit test reports in Jenkins
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline execution completed.'
        }
		
        success {
            echo 'Automation tests passed successfully!'
        }
		
        failure {
            echo 'Automation pipeline failed. Please check the test reports.' 
        }
    }
}
