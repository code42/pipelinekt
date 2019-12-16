def Build() {
  script {
    sh (script: "./build.sh", returnStdout: false)
    sh (script: "./build ${env.SOME_ENVIRONMENT_VARIABLE} ${params.MY_PARAMETER}", returnStdout: false)
    def HxOqKpqc
    HxOqKpqc =
      sh (script: "./isRelease.sh", returnStdout: true)
    if(((HxOqKpqc) == ("true")) || (params.DO_RELEASE)) {
      sh (script: "./publishRelease.sh", returnStdout: false)
    }
    else {
      sh (script: "./publishSnapshot.sh", returnStdout: false)
    }
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
      when {
        expression {
          params.DO_BUILD
        }
      }
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
