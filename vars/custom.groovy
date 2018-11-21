import fr.valeuriad.pipeline.CustomPipeline

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage('Init') {
            cleanWs()
            echo(sh(returnStdout: true, script: 'env'))
        }
        new CustomPipeline(this, config).run()
    }
}
