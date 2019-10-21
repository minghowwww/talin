FROM hub.c.163.com/library/java:8-jre
VOLUME /tmp
ADD talin-auth-service-1.0-SNAPSHOT.jar talin-auth-service.jar
#ADD ../../../target/talin-member-service-1.0-SNAPSHOT.jar talin-member-service.jar
ENTRYPOINT ["java", "-Xmx128m", "-Xss256k", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/talin-auth-service.jar"]