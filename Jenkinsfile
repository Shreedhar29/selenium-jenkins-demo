pipeline {

    agent any

//     tools {
//         jdk 'jdk-21'
//         maven 'maven-3'
//     }

    options {
        timestamps()
    }

    stages {

        stage('Checkout') {
            steps {
                echo "========== CHECKOUT =========="
                checkout scm
            }
        }

        stage('Verify Environment') {
            steps {
                echo "========== VERIFY TOOLS =========="

                sh 'pwd'
                sh 'ls -la'
                sh 'java -version'
                sh 'mvn -version'
                sh 'google-chrome --version || true'
            }
        }

        stage('Build') {
            steps {
                echo "========== BUILD =========="
                sh 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo "========== RUNNING TESTS =========="
                sh 'mvn test'
            }
        }

    }

    post {

        always {

            echo "========== PUBLISH REPORTS =========="

            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/**/*.xml'

            archiveArtifacts artifacts: 'target/**/*',
                             fingerprint: true

            cleanWs()
        }

        success {
            echo "BUILD SUCCESSFUL"
        }

        failure {
            echo "BUILD FAILED"
        }
    }
}