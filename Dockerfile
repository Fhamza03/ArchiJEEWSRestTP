# -------------------------
# Stage 1 : Build Spring WAR
# -------------------------
FROM gradle:8.3-jdk17 AS builder
WORKDIR /app
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src
RUN chmod +x gradlew
RUN ./gradlew clean build -x test

# -------------------------
# Stage 2 : Tomcat
# -------------------------
FROM tomcat:10.1-jdk17
RUN rm -rf /usr/local/tomcat/webapps/* \
    && mkdir -p /logs

# Copier le WAR
COPY --from=builder /app/build/libs/ArchiJEEWSRestTP-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Exposer port Tomcat
EXPOSE 8080

# Lancer Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
