#!/bin/bash

# Build and run the Blog Management application

echo "Building Blog Management application..."

# Clean and compile
mvn clean compile

if [ $? -eq 0 ]; then
    echo "Build successful! Starting the application..."
    mvn spring-boot:run
else
    echo "Build failed! Please check the errors above."
    exit 1
fi
