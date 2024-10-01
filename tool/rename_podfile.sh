#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)
BUILD_PATH=../all/build

# Make Repository
cd "$BASE_PATH" || exit
mkdir -p $BUILD_PATH/cocoapods/repository/debug
mkdir -p $BUILD_PATH/cocoapods/repository/release

# Copy Podspec
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp kbsky.podspec ../../repository/kbsky-debug.podspec
cd ../../repository/ || exit
sed -i -e "s|'kbsky'|'kbsky-debug'|g" kbsky-debug.podspec
sed -i -e "s|'kbsky.xcframework'|'debug/kbsky.xcframework'|g" kbsky-debug.podspec
rm *.podspec-e
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp kbsky.podspec ../../repository/kbsky-release.podspec
cd ../../repository/ || exit
sed -i -e "s|'kbsky'|'kbsky-release'|g" kbsky-release.podspec
sed -i -e "s|'kbsky.xcframework'|'release/kbsky.xcframework'|g" kbsky-release.podspec
rm *.podspec-e

# Copy Framework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/debug || exit
cp -r kbsky.xcframework ../../repository/debug/kbsky.xcframework
cd "$BASE_PATH" || exit
cd $BUILD_PATH/cocoapods/publish/release || exit
cp -r kbsky.xcframework ../../repository/release/kbsky.xcframework

# Copy README
cd "$BASE_PATH" || exit
cd ../ || exit
cp ./LICENSE ./all/build/cocoapods/repository/LICENSE
cp ./docs/pods/README.md ./all/build/cocoapods/repository/README.md
cp ./docs/pods/README_ja.md ./all/build/cocoapods/repository/README_ja.md
