#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)

# Make Repository
cd "$BASE_PATH" || exit
mkdir -p ../build/cocoapods/repository/debug
mkdir -p ../build/cocoapods/repository/release

# Copy Podspec
cd "$BASE_PATH" || exit
cd ../build/cocoapods/publish/debug || exit
cp bsky.podspec ../../repository/bsky-debug.podspec
cd ../../repository/ || exit
sed -i -e "s|'bsky'|'bsky-debug'|g" bsky-debug.podspec
sed -i -e "s|'bsky.xcframework'|'debug/bsky.xcframework'|g" bsky-debug.podspec
rm *.podspec-e
cd "$BASE_PATH" || exit
cd ../build/cocoapods/publish/release || exit
cp bsky.podspec ../../repository/bsky-release.podspec
cd ../../repository/ || exit
sed -i -e "s|'bsky'|'bsky-release'|g" bsky-release.podspec
sed -i -e "s|'bsky.xcframework'|'release/bsky.xcframework'|g" bsky-release.podspec
rm *.podspec-e

# Copy Framework
cd "$BASE_PATH" || exit
cd ../build/cocoapods/publish/debug || exit
cp -r bsky.xcframework ../../repository/debug/bsky.xcframework
cd "$BASE_PATH" || exit
cd ../build/cocoapods/publish/release || exit
cp -r bsky.xcframework ../../repository/release/bsky.xcframework

