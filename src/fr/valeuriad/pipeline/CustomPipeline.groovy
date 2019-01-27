package fr.valeuriad.pipeline

class CustomPipeline {

    // Jenkins Pipeline steps
    def steps

    // Jenkinsfile configuration
    def config

    CustomPipeline(def steps, def config) {
        this.steps = steps
        this.config = config
    }

    void run() {
        steps.stage('Stage #1') {
            steps.echo('Hello, world !')
        }
    }

}