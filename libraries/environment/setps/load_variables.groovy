@Init
void call() {
  echo 'AQUIIIIIIIIIIIIIIIIIIIIII'
  stage('Load environment variables') {
    script {
      load "${config.env_path}"
    }
  }
}
