#!/usr/bin/env bash
# Start script for Render deployment

set -e

echo "Starting Ktor application..."

# Use the fat JAR built during the build process
java -jar build/libs/ktor-sample-0.0.1-all.jar
