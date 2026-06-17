pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Prajwal-Kotian100/ApplicationAutomationSuit.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Cucumber Report',

                    keepAll: true,               // ✅ REQUIRED
                    alwaysLinkToLastBuild: true, // ✅ REQUIRED
                    allowMissing: true           // ✅ REQUIRED
                ])
            }
        }
    }
}
