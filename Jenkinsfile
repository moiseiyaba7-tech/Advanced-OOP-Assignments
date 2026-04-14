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

        // --- GRID LAYOUTS SECTION ---
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

        // --- NEW: AGGREGATION TASK SECTION ---
        stage('Aggregation Task') {
            steps {
                // Ensure 'AggregationTask' matches your folder name exactly!
                dir('AggregationTask') {
                    bat "${MAVEN_HOME}/bin/mvn clean test"
                    withSonarQubeEnv('SonarQube') {
                        bat "${MAVEN_HOME}/bin/mvn sonar:sonar " +
                            "-Dsonar.projectKey=Aggregation_Task " +
                            "-Dsonar.projectName='Aggregation Task' " +
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
                echo "All tasks passed. Deploying artifacts to Staging..."
            }
        }
    }

    post {
        failure {
            echo "Build failed! Checking logs..."
        }
        success {
            echo "Everything is green! Portfolio is ready."
        }
    }
}