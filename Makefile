.DEFAULT_GOAL := run
.PHONY: test package run

test:
	docker-compose exec maven mvn test

package:
	docker-compose exec maven mvn package

run:
	docker-compose exec java java -cp ./target/testng-propertybased-math-1.0-SNAPSHOT.jar Main
