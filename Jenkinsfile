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
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar -Dsonar.projectKey=GridLayouts_Task \"-Dsonar.projectName=GridLayouts Task\" -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes"
                    }
                }
            }
            post {
                always {
                    // Captures GridLayouts test results
                    junit 'GridLayouts/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Aggregation Task') {
            steps {
                dir('AggregationDemo') {
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                    
                    withSonarQubeEnv('SonarQube') {
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar -Dsonar.projectKey=Aggregation_Demo_Task \"-Dsonar.projectName=Aggregation Demo\" -Dsonar.sources=src/main/java -Dsonar.java.binaries=target/classes"
                    }
                }
            }
            post {
                always {
                    // Captures Aggregation test results
                    junit 'AggregationDemo/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deploy to Staging') {
            when {
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