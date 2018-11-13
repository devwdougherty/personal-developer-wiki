Help it with Fork and Pull Request!

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
### Setting  your project
```
$gcloud config set project [YOUR_PROJECT_ID]
```
### List your GCC projects
```
$ gcloud projects list
```
