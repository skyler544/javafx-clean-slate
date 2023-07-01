all: clean-run

clean-run: install
	cd frontend && mvn javafx:run

run:
	cd frontend && mvn javafx:run

install: clean
	mvn install

clean:
	mvn clean
