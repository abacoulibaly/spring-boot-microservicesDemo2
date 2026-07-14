
pipeline {
    // Run this pipeline on any available agent/node
    //agent any 

    agent { docker { image 'maven:3.9-eclipse-temurin-17' } }

    // Define all the pipeline phases inside the stages block
    stages {
        
        stage('Checkout') {
            steps {
                echo 'Pulling the latest code from  GIT repository...'
                // Checked out automatically if using "Pipeline from SCM"
                checkout scm
            }
        }

       stage('Build & Package') {
            steps {
                // Use 'bat' instead of 'sh' if your Jenkins agent runs on Windows
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            // Archives the built artifact so you can download it from the Jenkins UI
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
        always {
            // Cleans up the workspace to prevent disk bloat
            cleanWs()
        }
    }
}
