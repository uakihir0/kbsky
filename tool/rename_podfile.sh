#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)
BUILD_PATH=../pods/build

# Make Repository
cd "$BASE_PATH" || exit
mkdir -p $BUILD_PATH/cocoapods/repository/debug
mkdir -p $BUILD_PATH/cocoapods/repository/release

# Copy Podspec
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp pods.podspec ../../repository/pods-debug.podspec
cd ../../repository/ || exit
sed -i -e "s|'pods'|'pods-debug'|g" pods-debug.podspec
sed -i -e "s|'pods.xcframework'|'debug/pods.xcframework'|g" pods-debug.podspec
rm *.podspec-e
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp pods.podspec ../../repository/pods-release.podspec
cd ../../repository/ || exit
sed -i -e "s|'pods'|'pods-release'|g" pods-release.podspec
sed -i -e "s|'pods.xcframework'|'release/pods.xcframework'|g" pods-release.podspec
rm *.podspec-e

# Copy Framework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp -r pods.xcframework ../../repository/debug/pods.xcframework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp -r pods.xcframework ../../repository/release/pods.xcframework

