FROM openjdk:8
MAINTAINER Vinod <vinod@vinod.co>
ADD target/springboot-test.jar springboot-test.jar
ENTRYPOINT ["java", "-jar", "-Dserver.port=8899", "/springboot-test.jar"]
EXPOSE 8899