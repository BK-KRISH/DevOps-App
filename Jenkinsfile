pipeline {
    agent any

    tools {
        maven 'Maven3'   // Jenkins tool config: Maven installation named 'Maven3'
        jdk 'JDK21'      // Jenkins tool config: JDK installation named 'JDK21'
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from your GitHub repo
                git branch: 'main', url: 'https://github.com/BK-KRISH/DevOps-App.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t devops-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                // Stop & remove old container if it exists
                bat 'docker rm -f devops-app-container || exit 0'
                // Run new container
                bat 'docker run -d --name devops-app-container devops-app'
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Check logs."
        }
    }
}
