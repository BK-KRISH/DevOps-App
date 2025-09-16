pipeline {
    agent any

    tools {
        maven 'Maven3'   // Make sure Jenkins has Maven installed and named 'Maven3'
        jdk 'JDK21'      // Make sure Jenkins has JDK 21 installed and named 'JDK21'
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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t devops-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                // Stop & remove any old container, ignore errors if not exists
                sh 'docker rm -f devops-app-container || true'
                // Run fresh container
                sh 'docker run -d --name devops-app-container devops-app'
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
