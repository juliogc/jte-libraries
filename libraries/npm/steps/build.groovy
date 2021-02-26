void call() {
  stage('NPM: Build app'){
    docker.image("node:${config.node_version}").inside {
      sh 'npm run build'
    }
  }
}
