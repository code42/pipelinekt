def Build() {
  withEnv([
  	"MY_ENV=my_static_value"
  ]) {
    sh (script: './ci/scripts/myScript.sh ${MY_ENV}', returnStdout: false)
  }
}
pipeline {
  options {
    buildDiscarder(logRotator(
      numToKeepStr: "10",
      daysToKeepStr: "10",
      artifactNumToKeepStr: "10",
      artifactDaysToKeepStr: "10"
    ))
    ansiColor("xterm")
    timestamps()
    disableConcurrentBuilds()
  }
  stages {
    stage("Build") {
      steps {
        Build()
      }
    }
  }
  post {
    cleanup {
      cleanWs()
    }
  }
}
