FROM java:8
MAINTAINER ruibo

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/among-*.jar /app.jar
EXPOSE 9090

ENTRYPOINT ["sh","-c","java -jar /app.jar $PARAMS"]