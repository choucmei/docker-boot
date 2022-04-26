FROM java:8

MAINTAINER choucmei

VOLUME /tmp

ADD docker-boot-1.0-SNAPSHOT.jar docker-boot.jar

RUN bash -c 'touch /docker-boot.jar'

ENTRYPOINT ["java","-jar","/docker-boot.jar"]

EXPOSE 6001
