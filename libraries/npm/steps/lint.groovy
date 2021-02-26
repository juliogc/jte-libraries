void call() {
  stage('NPM: Lint'){
    docker.image("node:${node_version}").inside {
      sh 'npm run lint'
    }
  }
}
