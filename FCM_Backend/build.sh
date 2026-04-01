#!/usr/bin/env bash
# Build script for Render deployment

set -e

echo "Installing dependencies..."
./gradlew build

echo "Building fat JAR..."
./gradlew buildFatJar

echo "Build completed successfully!"
