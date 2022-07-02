node {
    timestamps {

        stage("Clean WS") {
            cleanWs()
            checkout scm
        }

        def parameters
        def gitTag

        stage("Load parameters") {
            parameters = load('./JenkinsParameters.groovy')
            gitTag = PROJECT_NAME + "-" + BRANCH_NAME.replace("/", "-") + "-" + BUILD_NUMBER
        }

        stage("Initialize") {
            echo "PATH = ${PATH}"
            echo "gitTag = " + gitTag
            echo "PROJECT_NAME = " + PROJECT_NAME
            echo "IS_RELEASE = " + IS_RELEASE
            echo "Is docker push enabled (for release only) : " + IS_PUSH_ENABLED
        }

        stage("Unit tests") {
            sh 'dotnet test --logger "junit;LogFilePath=../WebApi.Tests/results.xml"'
            //echo 'Tests folder:'
            //sh 'ls -la ../WebApi.Tests/'
            echo '+ 1 folder up:'
            sh 'ls -la ../'
            junit '../WebApi.Tests/*.xml'
        }

        stage("Delete previous deployment") {    
            /*
            echo "helm list"
            sh 'helm list'
            echo "Deleting previous deployment : " + DEPLOYMENT_NAME
            try{
                sh 'helm uninstall ' + DEPLOYMENT_NAME
            } catch(Exception ignored) {
                echo "Unable to uninstall chart " + DEPLOYMENT_NAME
            }
            */
        }

        stage("Removing old docker images") {
            /*
            sh 'docker rmi -f ' + DOCKER_REGISTRY + "/" + IMAGE_NAME + ":latest"
            sh 'docker rmi -f ' + IMAGE_NAME + ":latest"
            */
        }

        def image
        stage("Build and push docker image") {
            /*
            if(IS_RELEASE) {
                echo "Release branch, processing stage..."
                echo "docker version"
                sh 'docker --version'
                image = docker.build(IMAGE_NAME)
                if(IS_PUSH_ENABLED) {
                    echo "Push is enabled, pushing to docker hub..."
                    docker.withRegistry('https://' + DOCKER_REGISTRY, DOCKER_CREDENTIALS) {
                        image.push("latest")
                    }
                } else {
                    echo "IS_PUSH_ENABLED = false, will not push image to remote docker hub."
                }
            } else {
                echo "Not release, skipping stage..."
            }
            
            */
        }

        stage("Git tag") {
            withCredentials([gitUsernamePassword(credentialsId: GIT_CREDENTIALS, gitToolName: 'Default')]) {
                sh 'git tag ' + gitTag
                sh 'git push --tags'
            }
        }

        stage("Security tests and scans") {
            echo "Not implemented yet... Skipping this stage..."
        }

        stage("Helm dry-run before deploy to k8s") {
            /*
            echo "Installing chart : " + DEPLOYMENT_NAME
            sh 'helm install --dry-run ' + DEPLOYMENT_NAME + " " + CHART_PATH
            */
        }

        stage("Deploy to k8s") {
            /*
            if (IS_DEPLOY_ENABLED && IS_RELEASE) {
//                 && IS_PUSH_ENABLED
                echo "Starting deploy to k8s..."
                sh 'helm install ' + DEPLOYMENT_NAME + " " + CHART_PATH
            } else {
                echo "Deploy to k8s stage is disabled. Skipping stage..."
            }
            */
        }
    }
}
