# Datastore

# Storage

## Maven Dependecy

### Storage
**Client Libray**
_pom.xml:_
```xml
  <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-storage</artifactId>
      <version>1.46.0</version>
  </dependency>
```
**Appengine Library**
```xml
 <dependency>
   <groupId>com.google.appengine.tools</groupId>
   <artifactId>appengine-gcs-client</artifactId>
   <version>0.8</version>
 </dependency>
```

## Store a object on Storage. 

### PDF File

**Environment: Java, Maven, API Client Library**

e.g:
```java
//This property refers to the Google Storage service.
private Storage storage;

Storage storage = StorageOptions.getDefaultInstance().getService();
BlobId blobId = BlobId.of(YOUR_BUCKET, "name_file");
BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("application/pdf").build();
Blob blob = storage.create(blobInfo, byteArrayYourPDF.getValue()); //Object as byte[]
```

**Environment: Java, Maven, API APPEngine Library**

e.g:
```java
// Declaration
private GcsService gcService;

// Method
gcsService =
              GcsServiceFactory.createGcsService(
                      new RetryParams.Builder()
                              .initialRetryDelayMillis(10)
                              .retryMaxAttempts(10)
                              .totalRetryPeriodMillis(15000)
                              .build());

      Map<PDFEnum, byte[]> pdfFile = pdfEntity.getPdfFile();

      if (pdfFile == null || pdfFile.isEmpty()) {
          // Error invalid file
          //return
      }

      for (Map.Entry<PDFEnum, byte[]> pdfFileData : pdfEntity.getPdfFile().entrySet()) {

          if (pdfFileData.getValue() == null || pdfFileData.getValue().length == 0) {
              continue;
              // Error?
          }

          // Generating the file name
          Calendar calendar = Calendar.getInstance();
          String fileName = calendar.getTimeInMillis() + ".pdf";

          GcsFileOptions options = new GcsFileOptions.Builder()
                  .mimeType("application/pdf")
                  .acl("public-read")
                  .build();

          GcsFilename gcsFilename = new GcsFilename(YOUR_BUCKET_PDF, fileName);

          GcsOutputChannel writeChannel = gcsService.createOrReplace(gcsFilename, options);

          byte[] bytes = pdfFileData.getValue();

          try {
              writeChannel.write(ByteBuffer.wrap(bytes));
          } finally {
              writeChannel.close();
          }
      }
```

### Image file (.png, jpeg) - Handling extension properties

**Environment: Java, Maven, API Client Library**

e.g:
```java
//Find out image type
String mimeType;
String fileExtension;

InputStream is = new ByteArrayInputStream(image.getValue()); //byte[]
mimeType = URLConnection.guessContentTypeFromStream(is); //mimeType is something like "image/jpeg"
String delimiter="[/]";
String[] tokens = mimeType.split(delimiter);
fileExtension = tokens[1];

// Generating the file name
Calendar calendar = Calendar.getInstance();
String fileName = calendar.getTimeInMillis() + "." + fileExtension;

// Replace name reference file in details
List<String> fileNameList = new ArrayList<>();
fileNameList.add(BUCKET_NAME + "/" + fileName);

// Upload a blob to the newly created bucket
BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(mimeType).build();

//persist image in storage.
storage.create(blobInfo, image.getValue());
```
