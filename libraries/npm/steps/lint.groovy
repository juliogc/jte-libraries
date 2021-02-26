void call() {
  stage('NPM: Lint'){
    docker.image("node:${config.node_version}").inside {
      sh 'npm run lint'
    }
  }
}
