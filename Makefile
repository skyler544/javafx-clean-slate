all: compile

run:
	cd frontend && mvn javafx:run

clean-run: compile
	cd frontend && mvn javafx:run

compile: clean
	mvn package

install: clean
	mvn install

clean:
	mvn clean
