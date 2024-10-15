FROM tomcat:10.1.31-jdk21-temurin-noble

COPY build/libs/app.war /usr/local/tomcat/webapps/