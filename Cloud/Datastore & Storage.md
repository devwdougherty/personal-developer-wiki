Help it with Fork and Pull Request!

# Datastore

# Storage

## Store a object on Storage. 

_In this case a pdf file._

**Environment: Java, Maven, API Client Library**

e.g:

_pom.xml:_
```xml
  <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-storage</artifactId>
      <version>1.46.0</version>
  </dependency>
```
_code:_
```java
//This property refers to the Google Storage service.
private Storage storage;

Storage storage = StorageOptions.getDefaultInstance().getService();
BlobId blobId = BlobId.of(YOUR_BUCKET, "name_file");
BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();
Blob blob = storage.create(blobInfo, byteArrayYourPDF.getValue()); //Object as byte[]
```
