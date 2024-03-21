FROM eclipse-temurin:17.0.8.1_1-jre-jammy
# JAVA VERSION !!

VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} spring-boot.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /spring-boot.jar ${0} ${@}"]
EXPOSE 8080