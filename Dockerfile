# This is a comment!
FROM openjdk:14-buster

# RUN apt update && apt upgrade -y && apt install vim -y

# RUN mkdir -p /opt
# RUN cd /opt
WORKDIR /opt

COPY ./target/demo-0.0.1-SNAPSHOT.jar .

ENV APP_MESSAGE="Greeting from container!"
ENV EXAMPLE="This is an example"

CMD [ "java", "-jar", "/opt/demo-0.0.1-SNAPSHOT.jar" ]