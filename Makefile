build:
	./gradlew core:clean core:build  -x test --refresh-dependencies
	./gradlew stream:clean stream:build  -x test --refresh-dependencies

pods:
	./gradlew pods:assembleKbskyXCFramework pods:podPublishXCFramework -x test --refresh-dependencies

version:
	 ./gradlew printVersion --no-daemon --console=plain -q

.PHONY: build pods version