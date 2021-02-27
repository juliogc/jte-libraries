void call() {
  stage('NPM: Install dependencies'){
    docker.image("node:${config.node_version}").inside {
      sh 'npm ci --prefer-offline'
    }
  }
}
