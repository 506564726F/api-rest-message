FROM openjdk:8-jre-alpine

RUN apk add --no-cache tzdata
ENV TZ='America/Lima'
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apk --update add fontconfig ttf-dejavu

WORKDIR /

RUN mkdir app && chmod 777 app
COPY target/api-rest-message-0.0.1-SNAPSHOT.jar /app
WORKDIR /app

EXPOSE 9091

CMD ["java","-jar","api-rest-message-0.0.1-SNAPSHOT.jar"]