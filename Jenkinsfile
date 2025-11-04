pipeline {
    agent any

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
                echo 'Generating reports...'
                // Add Allure or JUnit report steps here if needed
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
