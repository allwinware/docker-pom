# Dockerfiles

# nginx
# build stage
FROM node:10 as build-stage
WORKDIR /app
COPY repo/ /app/

RUN npm i node-pre-gyp
RUN npm i sqlite3 
RUN npm install
RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
RUN rm /etc/nginx/conf.d/default.conf
COPY --from=build-stage ./app/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-stage ./app/dist /usr/share/nginx/html

RUN apk add bash
RUN apk add nginx-mod-http-headers-more

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]


# tomcat
FROM tomcat:9.0
ENV TZ="Asia/Seoul"
RUN ln -fns /usr/share/zoneinfo/$TZ /etc/localtime
RUN echo $TZ > /etc/timezone
#RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY repo/target/docker-web.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8009 8080 8443
