pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    environment {
        IMAGE_NAME = "devops-app"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${IMAGE_NAME}:latest .'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run --rm ${IMAGE_NAME}:latest'
            }
        }
    }

    post {
        success {
            echo "✅ Build, Docker image, and container run completed successfully!"
        }
        failure {
            echo "❌ Build failed. Please check logs."
        }
    }
}
