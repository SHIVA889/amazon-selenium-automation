// CI pipeline for Amazon automation framework

pipeline {

    agent any
    stages {
        stage('Build and Test') {

            steps {

                bat 'mvn clean test'
            }
        }
    }
}  