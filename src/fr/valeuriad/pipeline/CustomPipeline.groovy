package fr.valeuriad.pipeline

class CustomPipeline {

    // Jenkins Pipeline context
    def ctx

    // Jenkinsfile configuration
    def config

    NeoloadPipeline(def ctx, def config) {
        this.ctx = ctx
        this.config = config
    }

    void run() {
        ctx.stage('Stage #1') {
            ctx.echo('Hello, world !')
        }
    }

}