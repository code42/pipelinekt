def Build() {
  echo "Hello, World!"
}
pipeline {
  agent {
    label "linux"
  }
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
