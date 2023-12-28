build:
	./gradlew core:clean core:build  -x test --refresh-dependencies
	./gradlew stream:clean stream:build  -x test --refresh-dependencies

pods:
	./gradlew pods:assembleXCFramework pods:podPublishXCFramework -x test --refresh-dependencies

.PHONY: build pods