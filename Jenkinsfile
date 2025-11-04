pipeline {
    agent any
    tools {
        maven 'Maven' // the same name you gave in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Rajesh136254/selenium-ci-demo.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running Selenium tests...'
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                echo 'Generating Cucumber report...'
                bat 'mvn verify'
                publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/cucumber-html-reports',
                        reportFiles: 'overview-features.html',
                        reportName: 'Cucumber HTML Report'
                ])
            }
        }

    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
