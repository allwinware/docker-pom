# Dockerfiles

# tomcat
FROM tomcat:9.0

RUN rm -Rf /usr/local/tomcat/webapps/ROOT ## tomcat root 경로 삭제
COPY ./target/docker-web.war /usr/local/tomcat/webapps/ROOT.war
#COPY ./docker/dev/server.xml /usr/local/tomcat/conf
#COPY ./docker/dev/web.xml /usr/local/tomcat/conf


EXPOSE 8080

<<<<<<< HEAD
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
=======
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
>>>>>>> 7f7bca085bb78c4738177663401af5cf2327ba33
