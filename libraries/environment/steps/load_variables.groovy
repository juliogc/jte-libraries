@Init
void call() {
  stage('Load environment variables') {
    node {
      load "${config.env_path}"
    }
  }
}
