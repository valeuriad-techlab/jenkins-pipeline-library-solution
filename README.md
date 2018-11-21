# Custom Shared Library Pipeline

This project is a **skeleton** for creating custom **[Shared Pipeline Libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/)** with **[Jenkins](https://jenkins.io/)**.

# Pré-requis

* [Jenkins](https://jenkins.io/) version 2.62+
    * [Credentials](https://plugins.jenkins.io/credentials) version 2.1.18+
    * [Generic Webhook Trigger](https://plugins.jenkins.io/generic-webhook-trigger) version 1.46+
    * [Git Plugin](https://plugins.jenkins.io/workflow-multibranch) version 3.9+
    * [Pipeline](https://plugins.jenkins.io/workflow-aggregator) version 2.6+
    * [Pipeline Utility Steps](https://plugins.jenkins.io/pipeline-utility-steps) version 2.1.0+
    * [Pipeline: Multibranch with defaults](https://plugins.jenkins.io/pipeline-multibranch-defaults) version 2.0+
    * [Workspace Cleanup](https://plugins.jenkins.io/ws-cleanup) version 0.35+

# Installation

1. Navigate in **Credentials -> System -> Global credentials** and add following credentials :
    1. Git
        1. Type : Username and password
        2. Range : Global
        3. Username : Your **Git** username
        4. Password : Your **Git** password
        5. ID : git-main
        6. Description : Git - &lt;Main&gt;
2. Browse in **Admin Jenkins -> Configure system** and modify following parameters (don't forget to save) :
    1. **Global Pipeline Libraries** : Add
        1. Name : custom
        2. Default version : master
        3. Load implicity : check
        4. Allow default version to be overridden : check
        5. Include Library changes in job recent changes : check
        6. Retrieval method : Modern SCM
        7. Source Code Management : Git
        8. Project Repository : this git repository URL
        9. Credentials : Select the credential you just created
        10. Behaviours : add "Discover tags"
