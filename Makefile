build:
	./gradlew core:clean core:build --refresh-dependencies
	./gradlew stream:clean stream:build --refresh-dependencies

pods:
	./gradlew pods:podPublishXCFramework --refresh-dependencies

.PHONY: build pods