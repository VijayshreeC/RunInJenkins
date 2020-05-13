pipeline {
    agent any
    tools { 
        maven 'maven_3_5_0' 
        jdk 'JDK 11' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
        
	    post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
			}
		stage ('Testing Stage') {

            steps {
                    sh 'mvn test'
                
            }
        }

    }
}
