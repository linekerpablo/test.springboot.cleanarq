FROM openjdk:11.0.8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/api.cleanarq.jar
WORKDIR /app
ENTRYPOINT java -jar api.cleanarq.jar