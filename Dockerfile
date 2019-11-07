FROM java:8
MAINTAINER rui

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mvn clean package

ADD target/among-*.jar /app.jar
#EXPOSE 9090
EXPOSE 8443

ENTRYPOINT ["sh","-c","java -jar /app.jar $PARAMS"]