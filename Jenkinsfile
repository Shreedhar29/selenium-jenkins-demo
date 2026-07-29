pipeline {

    agent any

//
    parameters{
        choice(
          name: 'BROWSER',
          choices: ['chrome','firefox'],
          description: 'Select Browser'
        )

        choice(
        name: 'HEADLESS',
        choices: ['true','false'],
        description: 'Select Browser Type'
        )

        choice(
          name: "BASE_URL",
          choices: 'https://the-internet.herokuapp.com/',
          description: 'Application URL'
        )
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
                sh """
                  mvn test \
                  -Dbrowser=${params.BROWSER}\
                  -Dheadless=${params.HEADLESS}\
                  -Dbaseurl=${params.BASE_URL}

              """
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