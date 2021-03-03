# Google Cloud - General

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

The following is an example of an index.yaml file: **(Be aware with indentation of YAML file: indexes > kind-ancestor-properties > name > direction)**
```yaml
indexes:

- kind: Store
  ancestor: no
  properties:
  - name: businessAction
  - name: businessType
  - name: product
    direction: asc
  - name: priceIndex
    direction: desc
```

**Attention!**

Composite filters with multiple property values could encumber your performance and results in high storage costs!

The example above refactor the previous index leaving with a better execution and lower cost:

```yaml
indexes:

- kind: Store
  properties:
  - name: businessAction
  - name: priceIndex
    direction: desc

- kind: Store
  properties:
  - name: businessType
  - name: product
  - name: priceIndex
    direction: desc
```

_Google Cloud Datastore works joining those simple indexes when it is necessary._

2. Run on command line
```
$ gcloud datastore create-indexes index.yaml (or: gcloud datastore indexes create index.yaml) 
```
3. Done.

### GQL

**Select a property-list that has - at your property-name**

e.g.:
```sql
select `txt-quantity` from yourEntityForm
```

### Basic Index Commands (List, Create, Cleanup)

```
$ gcloud datastore indexes list
$ gcloud datastore indexes cleanup index.yaml
$ gcloud datastore indexes create index.yaml
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
