FROM openjdk:17-jdk-alpine
ADD target/__COMPONENT_NAME__-0.0.1.jar __COMPONENT_NAME__-0.0.1.jar
CMD java -jar __COMPONENT_NAME__-0.0.1.jar



