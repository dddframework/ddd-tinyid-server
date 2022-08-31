FROM openjdk:8-jdk-alpine
ENV LANG en_US.UTF-8
RUN echo "http://mirrors.aliyun.com/alpine/v3.6/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.6/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && apk add ttf-dejavu \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
EXPOSE 9999