pipeline {
    agent any

    tools {
        maven 'Maven' // Must match name in Global Tool Configuration
    }

    // Run every Monday & Friday at 10:00 AM
    triggers {
        cron('30 11 * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                git branch: 'main', url: 'https://github.com/Rajesh136254/selenium-ci-demo.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building project and running Cucumber tests...'
                bat 'mvn clean verify'  // compile + test + generate report
            }
        }

        stage('Publish Report') {
            steps {
                echo 'Publishing Cucumber HTML Report...'

                // Keep report across builds
                archiveArtifacts artifacts: 'target/cucumber-html-reports/**', allowEmptyArchive: true

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
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'SUCCESS: Build and tests passed!'
            // Optional: Send success email (uncomment if needed)
            // mail to: 'team@company.com',
            //      subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            //      body: "All good! View report: ${env.BUILD_URL}Cucumber_20HTML_20Report"
        }

        failure {
            echo 'FAILURE: Build or tests failed!'
            mail to: 'chakreesh@snovasys.com',  // CHANGE THIS TO YOUR EMAIL
                    subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """
                 The pipeline failed.
                 
                 Job: ${env.JOB_NAME}
                 Build: #${env.BUILD_NUMBER}
                 URL: ${env.BUILD_URL}
                 
                 Check console output: ${env.BUILD_URL}console
                 View report (if generated): ${env.BUILD_URL}Cucumber_20HTML_20Report
                 """
        }
    }
}