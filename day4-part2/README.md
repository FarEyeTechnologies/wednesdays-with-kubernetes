# README.md

## Before proceeding, ensure you have the metrics server installed. If not then apply metrics-server file
```bash
kubectl apply -f 1-service-account.yaml
kubectl apply -f 2-cluster-role.yaml
kubectl apply -f 3-role-binding.yaml
kubectl apply -f 4-cluster-role-binding.yaml
kubectl apply -f 5-service.yaml
kubectl apply -f 6-deployment.yaml
kubectl apply -f 7-api-service.yaml
```

## Now you can check the pod metrics, ServiceAccount, ClusterRole etc
```bash
kubectl top pods -n kube-system
kubectl get ServiceAccount -n kube-system | grep metrics
kubectl get ClusterRole  | grep system:aggregated-metrics-reader
kubectl get ClusterRole  | grep system:metrics-server
kubectl get rolebinding -n kube-system | grep metrics-server-auth-reader
kubectl get ClusterRoleBinding | grep metrics-server:system:auth-delegator
kubectl get ClusterRoleBinding | grep system:metrics-server
kubectl get sa -n kube-system | grep metrics-server
kubectl get APIService  | grep v1beta1.metrics.k8s.io
```

## Now Apply the Sample Application for HPA demo
```bash
kubectl apply -f 1-Deployment.yaml
kubectl apply -f 2-Server.yaml
kubectl apply -f 3-HPA.yaml
```

## We will start a container and send an infinite loop of queries to the service to increase the load on it, listening on port 8080. Open a new terminal and execute the below command:
```bash
kubectl run -i --tty load-generator --rm --image=busybox --restart=Never -- /bin/sh -c "while sleep 0.01; do wget -q -O- hpa-demo-service:8080; done"
```