build:
	./gradlew \
	core:clean stream:clean \
	core:assemble stream:assemble \
	-x check --refresh-dependencies

pods:
	./gradlew \
	all:assembleKbskyXCFramework \
	all:podPublishXCFramework \
	-x check --refresh-dependencies

version:
	 ./gradlew version --no-daemon --console=plain -q

.PHONY: build pods version