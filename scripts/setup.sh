#!/bin/bash

gitPull() {

    echo "Fetching project updates from 'http://197.248.0.222:7990'"
    echo "This process might ask for Username & Password, don't leave, just yet."

    git pull origin master > /dev/null

    echo "Git pull complete."
}

mvnCleanInstallPackage() {

    cd ../
    echo "Building your project."
    mvn clean > /dev/null
    mvn install package -DskipTests > /dev/null

    echo "Build complete"
    cd -
}

# Create dir /opt/pesaplus/bin if it doesn't exist already
ppDirSetup() {

    if [ ! -d "/opt/pesaplus/bin/" ]; then
        echo "Creating '/opt/pesaplus/bin/'"
        mkdir -p /opt/pesaplusdashboard/bin/
        echo "Done."
    else
        echo "'/opt/pesaplus/bin' Found."
    fi
}

copyJar() {

    echo "Copying JAR file"
    rm -f /opt/pesaplusdashboard/bin/pesaplusdashboard-0.0.1-SNAPSHOT.jar
    cp /home/patrick/pesaplusapp/pesaplusdahsboard/targetpesaplusdashboard-0.0.1-SNAPSHOT.jar /opt/pesaplus/bin/
    echo "Copy complete."
}

start() {

    echo "Starting service"
    systemctl start PesaPlusDashboard.service
    echo "Done."
}

stop() {
    echo "Stopping service"
    systemctl stop PesaPlusDashboard.service
    echo "Done."
}

createSystemdService() {

    echo "Setting up a systemd service"

    stop
    systemctl disable AirtimeDashSacco.service > /dev/null
    rm -f /lib/systemd/system/PesaPlusDashboard.service
    cp /home/patrick/pesaplusapp/pesaplusdahsboard/scripts/PesaPlusDashboard.service /lib/systemd/system/
    systemctl daemon-reload
    systemctl enable AirtimeDashSacco.service

    echo "Done."
}

if [ "$1" = "init" ]; then

    ppDirSetup
    mvnCleanInstallPackage
    copyJar
    createSystemdService
    start

elif [ "$1" = "update" ]; then

    gitPull
    mvnCleanInstallPackage
    stop
    copyJar
    start

else
    echo "'$1' doesn't look like anything to me. Try 'init' or 'update'"
fi
