FROM openjdk:11-jdk
LABEL maintainer="Uday"

COPY /build/libs/dadjoke-0.0.1-SNAPSHOT.jar /

EXPOSE 9091

ENV JAVA_OPTIONS ""
CMD ["sh", "-c", "java ${JAVA_OPTIONS} -jar /dadjoke-0.0.1-SNAPSHOT.jar"]