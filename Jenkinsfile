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
		    sh """ls -ltr
		    pwd
		    chmod 777 /var/jenkins_home/workspace/TestProject/Drivers/chromedriver"""
               	     sh 'mvn -Dmaven.test.failure.ignore=true install'
		    
            }
        } // build stage
	    
		stage ('Testing Stage') {

            steps {
		    sh """ls -ltr
		    pwd
		    chmod 777 /var/jenkins_home/workspace/TestProject/Drivers/chromedriver"""
                    sh 'mvn test'
                
            }
        } // testing stage
	    

   }// stages
	
	post
	{
	always
		{
		cleanWs()
		}
	}
}
