FROM picoded/ubuntu-openjdk-8-jdk
RUN apt-get install build-essential -y

# Setup
COPY . .
RUN ["chmod", "+x", "install.sh"]
RUN ["./install.sh"]
RUN ["javac", "./POSLinkJavaDemo.java"]

# After build
CMD ["java", "./POSLinkJavaDemo.jar"]