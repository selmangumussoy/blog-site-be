# Temel imaj
FROM openjdk:17-jdk-alpine

# JAR dosyasını kopyala
COPY target/blog-site-be-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "/app.jar"]