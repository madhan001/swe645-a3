pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "madhan2000/surveyapp-backend"
        BUILD_TIMESTAMP = "${new java.text.SimpleDateFormat('yyyyMMddHHmmss').format(new Date())}"
        DOCKERHUB_CREDENTIALS_ID = 'my-dockerhub-cred'
        DB_CREDENTIALS_ID = 'db-cred'
        KUBECONFIG_PATH = '/home/ubuntu/.kube/config'
    }
    tools {
        maven 'maven'
    }
    stages {

        stage('Checkout') {
            steps {
                // Checking out code from GitHub
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/madhan001/swe645-a3/']])
            }
        }

        stage('Build with Maven') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: DB_CREDENTIALS_ID, usernameVariable: 'DB_USERNAME', passwordVariable: 'DB_PASSWORD')]) {
                        sh 'mvn clean install'
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                // Building the Docker image
                sh "docker build -t ${DOCKER_IMAGE}:${BUILD_TIMESTAMP} ."
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'my-dockerhub-cred', passwordVariable: 'DOCKERHUB_PWD', usernameVariable: 'DOCKERHUB_USER')]) {
                        sh "docker login -u ${DOCKERHUB_USER} -p ${DOCKERHUB_PWD}"
                        sh "docker push ${DOCKER_IMAGE}:${BUILD_TIMESTAMP}"
                    }
                }
            }
        }

stage('Deploy to Kubernetes') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'mbalajir645clusterv2', variable: 'KUBECONFIG')]) {
                        sh "kubectl --kubeconfig=${env.KUBECONFIG} set image deployment/swe645 container-0=${DOCKER_IMAGE}:${BUILD_TIMESTAMP} -n default"
                    }
                }
            }
        }
    }
}

