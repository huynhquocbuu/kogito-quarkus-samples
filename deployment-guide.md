step 1: prepare environment
```shell
sudo mkdir /opt/quarkus-native-apps
sudo mkdir /opt/quarkus-native-apps/quarkus-sample-01
sudo mkdir /opt/quarkus-native-apps/quarkus-sample-01/docker-build
sudo mkdir /opt/quarkus-native-apps/quarkus-sample-01/external-config
cd /opt/quarkus-native-apps/quarkus-sample-01
```

step 2: dockerfile, dockercompose
step 2.1: dockerfile
```shell
sudo vim ./docker-build/Dockerfile.native-micro
```
```
FROM quay.io/quarkus/quarkus-micro-image:2.0
WORKDIR /work/
RUN chown 1001 /work \
    && chmod "g+rwX" /work \
    && chown 1001:root /work
COPY --chown=1001:root ./*-runner /work/application
RUN chmod -R 755 /work
EXPOSE 9180
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
```

step 2.2: docker-compose
```shell
sudo vim docker-compose.yml
```
```
version: '3.9'
services:
  quarkus-kogito-tdd-micro:
    build:
      context: ./docker-build
      dockerfile: Dockerfile.native-micro
    image: quarkus-kogito-tdd:micro
    container_name: quarkus-kogito-tdd-micro
    #restart: unless-stopped
    ports:
      - 9180:9180
    volumes:
      - ./external-config:/work/config
    networks:
      - net-db

networks:
  net-db:
    name: net-db
    driver: bridge
```

step 3: copy internal config to external config
```
copy file application.properties at source-code into /opt/quarkus-native-apps/quarkus-sample-01/external-config
```
step 4: build native
```shell
mvn clean package -Pnative
```
output: file *runner

step 5: copy native app to server to deploy
```
copy *-runner file to /opt/quarkus-native-apps/quarkus-sample-01/docker-build
```

step  6: run docker compose
```shell
docker compose up -d
docker-compose up --build -d
```