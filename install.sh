#!/bin/bash

# Installing drivers
cd ./LinuxDriver_V315
echo $(ls .)
make install
cd ..
if [ -d "/dev/ttyS90" ]; then
    echo "TTYS90 is connected!"]
else
    echo "TTYS90 is not functional. Please try again."
    exit
fi

# Installing JAVA bindings
export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which javac))))
cp ./external_libs/raspberry-pi-rxtxlib/librxtxSerial.so    $JAVA_HOME/jre/lib/$(dpkg --print-architecture)
cp ./external_libs/raspberry-pi-rxtxlib/librxtxParallel.so  $JAVA_HOME/jre/lib/$(dpkg --print-architecture)
cp ./external_libs/raspberry-pi-rxtxlib/RXTXcomm.jar        $JAVA_HOME/jre/lib/ext