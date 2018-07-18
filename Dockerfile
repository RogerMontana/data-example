FROM anapsix/docker-oracle-java8

COPY target/data-example-0.0.1-SNAPSHOT.jar /app/data-example-0.0.1-SNAPSHOT.jar

RUN chmod +x /app/

#EXPOSE 5672 27017

CMD ["java", "-jar", "/app/data-example-0.0.1-SNAPSHOT.jar"]