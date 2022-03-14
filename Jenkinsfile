pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
           steps {  
                script {
                    try {
                        mattermostSend (
                            color: "#2A42EE", 
                            message: "Build STARTED: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)"
                        )                   
                        sh 'mvn -B -DskipTests clean package'
                    } catch(e) {
                        currentBuild.result = "FAILURE"
                    } finally {
                        if(currentBuild.result != "FAILURE") {
                            mattermostSend (
                                color: "danger", 
                                message: "Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)"
                            )
                        } else {
                            mattermostSend (
                                color: "good", 
                                message: "Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)"
                            )
                        }                            
                    }           
                }
            }      
        }
    }
}
