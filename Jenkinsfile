pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling project...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running Selenium tests...'
                sh 'mvn test'
            }
        }

    }

    post {

        always {
            junit 'target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'target/**/*', fingerprint: true
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}