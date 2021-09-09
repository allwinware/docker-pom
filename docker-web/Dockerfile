# Dockerfiles

# tomcat
FROM tomcat:9.0

RUN rm -Rf /usr/local/tomcat/webapps/ROOT ## tomcat root 경로 삭제
COPY ./target/docker-web.war /usr/local/tomcat/webapps/ROOT.war
COPY ./docker/dev/server.xml /usr/local/tomcat/conf
COPY ./docker/dev/web.xml /usr/local/tomcat/conf