# README
## Prerequisites

Before proceeding, ensure you have the following prerequisites:

- Kubernetes cluster configured and accessible.
- `kubectl` command-line tool installed and configured to access your cluster.

## Steps: Apply the initial files

Step 1: Apply the files located in the "otherservice" folder using the following command:
kubectl apply -f <filename>
Replace <filename> with the appropriate filename in the folder.

Step 2: Apply the configmap
Apply the configmap configuration using the following command:
```bash
kubectl apply -f configmap.yaml

Step 3: Apply the dockerconfig
Apply the dockerconfig configuration using the following command:
```bash
kubectl apply -f dockerconfig.yaml
```
Step 4: Apply the secret
Apply the secret configuration using the following command:
```bash
kubectl apply -f secret.yaml
```
Step 5: Apply the service
Apply the service configuration using the following command:
```bash
kubectl apply -f service.yaml
```
Step 6: Apply the statefulset having PVC
Apply the statefulset configuration using the following command:
```bash
kubectl apply -f statefulset.yaml
```

Step 7: Apply the daemonset.yaml
Apply the statefulset configuration using the following command:
```bash
kubectl apply -f daemonset.yaml
```

Once all steps are completed successfully, the service should be deployed and accessible within your Kubernetes 

