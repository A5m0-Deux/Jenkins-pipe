pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Stage 1: Building the application using Maven...'
                
            }
        }
        
        stage('Unit and Integration Tests') {
            steps {
                echo 'Stage 2: Running unit and integration tests using JUnit and Selenium...'
                
            }
            post {
                always {
                    emailext (
                        to: 'youremail@example.com',
                        subject: "Build ${currentBuild.fullDisplayName} - Test Results",
                        body: "The test stage has completed with status: ${currentBuild.currentResult}",
                        attachLog: true
                    )
                }
            }
        }
        
        stage('Code Analysis') {
            steps {
                echo 'Stage 3: Performing code analysis using SonarQube...'
                
            }
        }
        
        stage('Security Scan') {
            steps {
                echo 'Stage 4: Conducting security scan using OWASP Dependency-Check...'
                
            }
            post {
                always {
                    emailext (
                        to: 'youremail@example.com',
                        subject: "Build ${currentBuild.fullDisplayName} - Security Scan Results",
                        body: "The security scan stage has completed with status: ${currentBuild.currentResult}",
                        attachLog: true
                    )
                }
            }
        }
        
        stage('Deploy to Staging') {
            steps {
                echo 'Stage 5: Deploying application to staging server on AWS EC2...'
                
            }
        }
        
        stage('Integration Tests on Staging') {
            steps {
                echo 'Stage 6: Running integration tests on the staging environment using Selenium...'
                
            }
        }
        
        stage('Deploy to Production') {
            steps {
                echo 'Stage 7: Deploying application to production server on AWS EC2...'
                
            }
        }
    }
}
