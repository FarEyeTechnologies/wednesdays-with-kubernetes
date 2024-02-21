# Deploy Kubernetes Dashboard UI

This guide outlines the steps to deploy the Kubernetes Dashboard UI to your cluster.

## Prerequisites

Before proceeding, ensure you have the following prerequisites:

- Kubernetes cluster configured and accessible.
- `kubectl` command-line tool installed and configured to access your cluster.

## Steps

1. Apply the Kubernetes Dashboard UI configuration:
   
``` bash
kubectl apply -f WebUI.yaml

Apply the Service Account configuration:
kubectl apply -f sa.yaml

Apply the Cluster Role configuration:
kubectl apply -f clusterrole.yaml

Create an admin user token:
kubectl -n kubernetes-dashboard create token admin-user
Save the Bearer token generated in the previous step.

Start a proxy server to access the Dashboard:

kubectl proxy
Once the proxy is running, the Dashboard will be available at:

http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
Access the Dashboard URL from your browser.

Use the saved Bearer token to log in when prompted.

Congratulations! Your Dashboard UI is now live and accessible.

Accessing the Dashboard UI
Ensure you're logged into your GitHub account.
Navigate to the Kubernetes Dashboard UI GitHub repository: GitHub Repository.
Follow the instructions there to clone the repository and contribute to the project.
