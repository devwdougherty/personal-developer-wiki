# Building a Maven Java Project

1. Build your pom.xml file with your dependencies and plugins
2. Import it to IDE
3. Make your code
4. Build your JAR/WAR file with:
```
mvn clean package
```
5. Run your project:
```
mvn spring-boot:run or mvn clean package
```

Tomcat (Or Jetty) will run your server at localhost.
