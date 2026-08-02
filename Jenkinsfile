pipeline {

    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    parameters {

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'both'],
            description: 'Select browser'
        )

        choice(
            name: 'HEADLESS',
            choices: ['true', 'false'],
            description: 'Run browser in headless mode'
        )

        string(
            name: 'BASE_URL',
            defaultValue: 'https://the-internet.herokuapp.com/',
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
                sh 'pwd'
                sh 'ls -la'
                sh 'java -version'
                sh 'mvn -version'
                sh 'google-chrome --version || true'
                sh 'firefox --version || true'
            }
        }

        stage('Build') {
            steps {
                echo "========== BUILD =========="
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {

            parallel {

                stage('Chrome Tests') {
                    when {
                        anyOf {
                            expression { params.BROWSER == 'chrome' }
                            expression { params.BROWSER == 'both' }
                        }
                    }

                    steps {
                        echo "Running Chrome Tests..."

                        sh """
                        mvn test \
                        -Dbrowser=chrome \
                        -Dheadless=${params.HEADLESS} \
                        -Dbaseurl=${params.BASE_URL}
                        """
                    }
                }

                stage('Firefox Tests') {
                    when {
                        anyOf {
                            expression { params.BROWSER == 'firefox' }
                            expression { params.BROWSER == 'both' }
                        }
                    }

                    steps {
                        echo "Running Firefox Tests..."

                        sh """
                        mvn test \
                        -Dbrowser=firefox \
                        -Dheadless=${params.HEADLESS} \
                        -Dbaseurl=${params.BASE_URL}
                        """
                    }
                }
            }
        }
    }

    post {

        always {

            echo "========== PUBLISH REPORTS =========="
archiveArtifacts artifacts: '''
target/screenshots/**/*,
target/extent-report/**/*
''', fingerprint: true
        }

        success {
            echo "BUILD SUCCESSFUL"
        }

        failure {
            echo "BUILD FAILED"
        }
    }
}