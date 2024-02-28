# README

This repository contains configuration files for deploying the service located in the "otherservice" folder using Kubernetes. Below are the steps to deploy the service:

## Step 1: Apply the initial files

Apply the files located in the "otherservice" folder using the following commands:

```bash
kubectl apply -f <filename>
kubectl apply -f configmap.yaml
kubectl apply -f dockerconfig.yaml
kubectl apply -f secret.yaml
kubectl apply -f service.yaml
kubectl apply -f statefulset.yaml