void call() {
  stage('NPM: Test'){
    docker.image("node:${node_version}").inside {
      sh 'npm ci --prefer-offline'
    }
  }
}
