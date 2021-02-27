@Init
void call() {
  echo 'AQUIIIIIIIIIIIIIIIIIIIIII'
  stage('Load environment variables') {
    steps {
      script {
        load "${config.env_path}"
      }
    }
  }
}
