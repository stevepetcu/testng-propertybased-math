.DEFAULT_GOAL := run
.PHONY: package run

package:
	docker-compose exec maven mvn package

run:
	docker-compose exec java java -cp ./target/testng-propertybased-math-1.0-SNAPSHOT.jar Main
