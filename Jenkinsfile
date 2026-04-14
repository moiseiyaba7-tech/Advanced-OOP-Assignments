pipeline {
    agent any

    environment {
        // This must match the name of the Maven installation in Jenkins Global Tool Configuration
        MAVEN_HOME = tool 'LocalMaven' 
        SONAR_TOKEN = 'squ_e91e1e0944c40ffd75c196ec36c2249df02861bd'
    }

    stages {
        stage('Checkout') {
            steps {
                // This pulls the code from the GitHub repo I linked in the UI
                checkout scm
            }
        }

        stage('Build & Unit Test') {
            steps {
                // We use dir() to tell Jenkins which assignment folder to enter
                dir('GridLayouts') {
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // This ensures SonarQube runs ONLY after the build/test succeeds
                withSonarQubeEnv('SonarQube') {
                    dir('GridLayouts') {
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar " +
                            "-Dsonar.projectKey=GridLayouts_Task " +
                            "-Dsonar.projectName='GridLayouts Task' " +
                            "-Dsonar.sources=src/main/java " +
                            "-Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Deploy to Staging') {
            // Point 4: Conditional deployment
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo "All stages passed. Deploying GridLayouts to Staging environment..."
                // In a real project, this is where you'd copy the .jar file to a server
            }
        }
    }

    post {
        // Point 5: Handling failures
        failure {
            echo "Building failed! Please check the Console Output for errors."
        }
        success {
            echo "Build, Test, and Analysis were successful!"
        }
    }
}