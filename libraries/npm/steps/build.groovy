void call() {
  stage('NPM: Build app'){
    docker.image("node:${node_version}").inside {
      sh 'npm run build'
    }
  }
}
