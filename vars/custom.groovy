import fr.valeuriad.pipeline.CustomPipeline

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        new CustomPipeline(this, config).run()
    }
}
