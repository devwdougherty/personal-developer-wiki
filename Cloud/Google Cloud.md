Help it with Fork and Pull Request!

# Google Cloud

## Command Line

### Create a new Bucket on your project
```
$ gsutil mb gs://<your-project-id>-images
$ gsutil defacl set public-read gs://<your-project-id>-images
```
### Acquire local credentials for authenticating with Google Cloud Platform services
```
$ gcloud auth application-default login
```
### Verify your currently configurations and project
```
$ gcloud config list
```
### Setting your project
```
$ gcloud config set project [YOUR_PROJECT_ID]
```
### List your GCC projects
```
$ gcloud projects list
```
## Datastore

### How to create a custom/composite Index at your Project/Datastore

1. Create your index.yaml file
Ex:
```
indexes: 
- kind: NeedForm 
  properties: 
  - name: businessAction 
    direction: asc 
  - name: businessType 
    direction: asc 
  - name: product 
    direction: asc 
  - name: quantity 
    direction: desc
```
2. Run on command line
```
$ gcloud datastore create-indexes index.yaml (or: gcloud datastore indexes create index.yaml) 
```
3. Done.

### List your indexes

```
$ gcloud datastore indexes list
```

## Bibliography

### Building with Google Cloud
#### Bookshelf App – Java
https://cloud.google.com/java/getting-started/tutorial-app?hl=pt-br 
https://github.com/GoogleCloudPlatform/getting-started-java.git

### Storage
#### Download objects from Google Cloud Storage
https://cloud.google.com/storage/docs/downloading-objects 
https://cloud.google.com/storage/docs/access-control/create-signed-urls-program

### Datastore
#### Best Practices
https://cloud.google.com/datastore/docs/best-practices

### Repositories
#### Google APIs
https://github.com/googleapis