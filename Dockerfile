FROM openjdk:7

RUN apt-get update -y
RUN apt-get install -y libusb-1.0-0-dev

COPY ./src .
EXEC "java Main"