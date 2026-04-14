pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'LocalMaven' 
        SONAR_TOKEN = 'squ_e91e1e0944c40ffd75c196ec36c2249df02861bd'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository from SCM
                checkout scm
            }
        }

        stage('GridLayouts Task') {
            steps {
                dir('GridLayouts') {
                    // Run Maven clean and test
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                    
                    withSonarQubeEnv('SonarQube') {
                        // We use \" to ensure Windows CMD handles the spaces in the project name correctly
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar -Dsonar.projectKey=GridLayouts_Task \"-Dsonar.projectName=GridLayouts Task\" -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Aggregation Task') {
            steps {
                dir('AggregationDemo') {
                    // Run Maven clean and test for the second project
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                    
                    withSonarQubeEnv('SonarQube') {
                        // Applied the same fix here to prevent a future crash
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar -Dsonar.projectKey=Aggregation_Demo_Task \"-Dsonar.projectName=Aggregation Demo\" -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Deploy to Staging') {
            when {
                // Only run if the previous stages were successful
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo "All tasks passed successfully. Ready for staging."
            }
        }
    }

    post {
        always {
            echo "Build process finished."
        }
        success {
            echo "SUCCESS: Both GridLayouts and AggregationDemo are verified and analyzed!"
        }
        failure {
            echo "FAILURE: Please check the Jenkins logs for syntax or test errors."
        }
    }
}