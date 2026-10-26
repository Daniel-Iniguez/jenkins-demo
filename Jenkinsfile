
pipeline {
    agent {
        label 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -B clean verify'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t jenkins-demo:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker rm -f springboot-demo 2>/dev/null || true

                    docker run -d \
                      --name springboot-demo \
                      --restart unless-stopped \
                      -p 8082:8082 \
                      jenkins-demo:latest
                '''
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                                 fingerprint: true
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true
        }
    }
}
