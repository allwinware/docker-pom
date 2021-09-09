# Dockerfiles

# tomcat
FROM tomcat:9.0

RUN rm -Rf /usr/local/tomcat/webapps/ROOT ## tomcat root 경로 삭제
COPY ./target/docker-api.war /usr/local/tomcat/webapps/ROOT.war
