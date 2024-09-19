FROM openjdk:18
WORKDIR /app
COPY ./target/EbBillMan-0.0.1-SNAPSHOT.jar /app
EXPOSE 1225
CMD ["java", "-jar", "EbBillMan-0.0.1-SNAPSHOT.jar"]
