@Init
void call() {
  stage('Load environment variables'){
    load "${config.env_path}"
  }
}
