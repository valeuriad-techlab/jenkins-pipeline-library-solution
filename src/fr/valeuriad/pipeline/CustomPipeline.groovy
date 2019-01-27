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
        String mvnHome = '';
        steps.stage('Preparation') {
            steps.cleanWs()
            steps.echo(steps.sh(returnStdout: true, script: 'env'))
            steps.git(config.gitUrl)
            mvnHome = steps.tool('M3')
        }
        steps.stage('Build') {
            steps.sh("'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package")
        }
        steps.stage('Results') {
            steps.junit('**/target/surefire-reports/TEST-*.xml')
            steps.archiveArtifacts('target/*.jar')
        }
    }

}