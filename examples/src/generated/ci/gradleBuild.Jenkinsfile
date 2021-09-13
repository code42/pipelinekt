def Build() {
  withEnv([
  	"GRADLE_USER_HOME=${env.WORKSPACE}/.gradle-home-tmp",
    "JENKINS_NODE_COOKIE=dontKillMe"
  ]) {
    sh (script: "./gradlew --stacktrace --build-cache ${""} build -DmyArg=myArgValue", returnStdout: false)
  }
}
def api_Test() {
  withEnv([
  	"GRADLE_USER_HOME=${env.WORKSPACE}/.gradle-home-tmp",
    "JENKINS_NODE_COOKIE=dontKillMe"
  ]) {
    sh (script: "./gradlew --stacktrace --build-cache ${""} :api:systemTest -DmyArg=myArgValue", returnStdout: false)
  }
}
def ext_Test() {
  withEnv([
  	"GRADLE_USER_HOME=${env.WORKSPACE}/.gradle-home-tmp",
    "JENKINS_NODE_COOKIE=dontKillMe"
  ]) {
    sh (script: "./gradlew --stacktrace --build-cache ${""} :ext:systemTest -DmyArg=myArgValue", returnStdout: false)
  }
}
def shared_Test() {
  withEnv([
  	"GRADLE_USER_HOME=${env.WORKSPACE}/.gradle-home-tmp",
    "JENKINS_NODE_COOKIE=dontKillMe"
  ]) {
    sh (script: "./gradlew --stacktrace --build-cache ${""} :shared:systemTest -DmyArg=myArgValue", returnStdout: false)
  }
}
def mod1_Test() {
  withEnv([
  	"GRADLE_USER_HOME=${env.WORKSPACE}/.gradle-home-tmp",
    "JENKINS_NODE_COOKIE=dontKillMe"
  ]) {
    sh (script: "./gradlew --stacktrace --build-cache ${""} :mod1:systemTest -DmyArg=myArgValue", returnStdout: false)
  }
}
def Publish() {
  withEnv([
  	"GRADLE_USER_HOME=${env.WORKSPACE}/.gradle-home-tmp",
    "JENKINS_NODE_COOKIE=dontKillMe"
  ]) {
    sh (script: "./gradlew --stacktrace --build-cache ${""} publish -DmyArg=myArgValue", returnStdout: false)
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
    stage("Validate") {
      parallel {
        stage("api Test") {
          steps {
            api_Test()
          }
          post {
            always {
              archiveArtifacts artifacts: "api/build/test-reports/", fingerprint: true
            }
          }
        }
        stage("ext Test") {
          steps {
            ext_Test()
          }
          post {
            always {
              archiveArtifacts artifacts: "ext/build/test-reports/", fingerprint: true
            }
          }
        }
        stage("shared Test") {
          steps {
            shared_Test()
          }
          post {
            always {
              archiveArtifacts artifacts: "shared/build/test-reports/", fingerprint: true
            }
          }
        }
        stage("mod1 Test") {
          steps {
            mod1_Test()
          }
          post {
            always {
              archiveArtifacts artifacts: "mod1/build/test-reports/", fingerprint: true
            }
          }
        }
      }
    }
    stage("Publish") {
      steps {
        Publish()
      }
    }
  }
  post {
    cleanup {
      cleanWs()
    }
  }
}
