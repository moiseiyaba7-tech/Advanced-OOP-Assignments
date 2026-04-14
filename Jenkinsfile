pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'LocalMaven' 
        SONAR_TOKEN = 'squ_e91e1e0944c40ffd75c196ec36c2249df02861bd'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('GridLayouts Task') {
            steps {
                dir('GridLayouts') {
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                    withSonarQubeEnv('SonarQube') {
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar " +
                            "-Dsonar.projectKey=GridLayouts_Task " +
                            "-Dsonar.projectName='GridLayouts Task' " +
                            "-Dsonar.sources=src/main/java " +
                            "-Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Aggregation Task') {
            steps {
                // This MUST match your folder name 'AggregationDemo' exactly
                dir('AggregationDemo') {
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                    withSonarQubeEnv('SonarQube') {
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar " +
                            "-Dsonar.projectKey=Aggregation_Demo_Task " +
                            "-Dsonar.projectName='Aggregation Demo' " +
                            "-Dsonar.sources=src/main/java " +
                            "-Dsonar.java.binaries=target/classes"
                    }
                }
            }
        }

        stage('Deploy to Staging') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo "All tasks passed successfully. Portfolio updated."
            }
        }
    }

    post {
        always {
            echo "Build process finished."
        }
        success {
            echo "SUCCESS: Both GridLayouts and AggregationDemo are verified!"
        }
        failure {
            echo "FAILURE: Please check the logs to see which task failed."
        }
    }
}