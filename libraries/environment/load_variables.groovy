@Init
void call() {
  stage('Load environment variables') {
    script {
      load "${config.env_path}"
    }
  }
}
