def build_in_container() {
  script {
    docker.withRegistry("my.custom.registry", "registry-creds-id") {
      def DcwRzxUn
      DcwRzxUn =
        docker.image("rabbitmq:11")
      DcwRzxUn
        .withRun("--expose 5672") { rabbitmq ->
          def ztGneVrJ
          ztGneVrJ =
            docker.image("postgres:11")
          ztGneVrJ
            .withRun("--env DB=app --expose 5432") { postgres ->
              def UoASuPLO
              UoASuPLO =
                docker.build("2a85fe27d76c4b9cb20615f6773e8d41", "--file ${"build.Dockerfile"} -u ${uid} ${"--arg1 y"} .")
              UoASuPLO
                .inside("${''} --link ${postgres.id}:db --link ${rabbitmq.id}:rabbit") {
                  echo "Inside a container!"
                  sh (script: "psql -h db -p 5432 app", returnStdout: false)
                }
            }
        }
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
    stage("build in container") {
      steps {
        build_in_container()
      }
    }
  }
  post {
    cleanup {
      cleanWs()
    }
  }
}
