FROM java:8
FROM maven:alpine

RUN apk update
RUN apk add bash

WORKDIR /app

ADD scripts/test.sh /app/test.sh

COPY . /app

RUN mvn clean install

RUN echo 'Tests Passed'

CMD ["bash", "test.sh"]