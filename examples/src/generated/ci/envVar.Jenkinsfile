def Build() {
  withEnv([
  	"MY_ENV=${params.myParam}"
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
  parameters {
    string(defaultValue: "default", description: "A parameter that is passed into a bash script", name: "params.myParam")
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
