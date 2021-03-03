@merge stages {
  continuous_integration {
    ci
    lint
    build
  }
}
