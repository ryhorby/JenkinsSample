//Project
PROJECT_NAME = "jenkinsSample"

//Global
IS_RELEASE = BRANCH_NAME == 'master'

//Git
GIT_CREDENTIALS = 'ryhorbygit'

//Docker
IS_PUSH_ENABLED = true
DOCKER_CREDENTIALS = 'ryhorbydocker'
IMAGE_NAME = 'ryhorby/jenkinsSample'
DOCKER_REGISTRY = "registry.hub.docker.com"
//https://registry.hub.docker.com'

//Deployment
IS_DEPLOY_ENABLED = true
CHART_PATH = "helm/"
DEPLOYMENT_NAME = "jenkinsSample"

return this