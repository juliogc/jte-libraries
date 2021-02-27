void call() {
  try {
    networkId = UUID.randomUUID().toString()
    
    // Creates network to be shared between service and database
    sh "docker network create ${networkId}"
    
    // Override DATABASE_URL once we need dynamicaly update it
    // between jobs executions to avoid container conflicts
    postgresContainer = "postgres-${networkId}"
    env.DATABASE_URL = "postgresql://postgres:postgres@${postgresContainer}:5432/postgres"
    
    stage('NPM: Test'){
      docker.image("postgres:${config.postgres_version}").withRun("--network ${networkId} --name ${postgresContainer} -p 5432:5432 -e POSTGRES_PASSWORD=postgres") {
        docker.image("node:${config.node_version}").inside("--network ${networkId}") {
          sh 'npm run test:all'
        }
      }
    } 
  } finally {
    // Deletes shared network
    sh "docker network rm ${networkId}"
  }
}
