void call() {
  stage('NPM: Test'){
    docker.image("node:${node_version}").inside {
      sh 'npm run lint'
    }
  }
}
