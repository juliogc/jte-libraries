void call() {
  stage('NPM: Install dependencies'){
    docker.image("node:${node_version}").inside {
      sh 'npm ci --prefer-offline'
    }
  }
}
