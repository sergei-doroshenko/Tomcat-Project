# Simple web application deploeyd on Tomcat server
FROM tomcat:8.0.20-jre8
LABEL maintainer="6823298@gmail.com"
LABEL version="1.0"

COPY target/webapp01.war /usr/local/tomcat/webapps/webapp01.war
COPY src/main/resources/conf/tomcat-users.xml /usr/local/tomcat/conf
# CMD ["/bin/bash"]