FROM maven:3.6-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml install

FROM gcr.io/distroless/java  
COPY --from=build /usr/src/app/target/calculator-0.0.1-SNAPSHOT.jar /usr/app/calculator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/app/calculator-0.0.1-SNAPSHOT.jar", "/usr/app/cart.json", "/usr/app/basePrice.json"] 