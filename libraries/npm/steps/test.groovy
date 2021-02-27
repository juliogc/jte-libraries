void call() {
  try {
    networkId = UUID.randomUUID().toString()
    sh "docker network create ${networkId}"
    
    stage('NPM: Test'){
      docker.image("postgres:${config.postgres_version}").inside("--network ${networkId} --name postgres-${networkId} -p 5432:5432 -e POSTGRES_PASSWORD=postgres") {
        docker.image("node:${config.node_version}").inside("--network ${networkId}") {
          sh 'npm run test:all'
        }
      }
    } 
  } finally {
    sh "docker network rm ${networkId}"
  }
}
