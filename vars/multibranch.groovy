import fr.valeuriad.pipeline.MultibranchPipeline

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        new MultibranchPipeline(this, config).run()
    }
}
