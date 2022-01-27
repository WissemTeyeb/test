pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            echo 'hi wissem it\'s a build step'
          }
        }

        stage('welcome stage') {
          steps {
            echo 'welcome wissem'
          }
        }

      }
    }

    stage('test') {
      steps {
        echo 'test stage'
      }
    }

  }
}