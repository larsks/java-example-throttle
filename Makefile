SRCS = $(wildcard Pck1/*.java)
CLASSES = $(SRCS:.java=.class)

%.class: %.java
	javac -Xlint:unchecked $<

all: $(CLASSES)

.PHONY: test
test: all
	java -ea Pck1.MainClass

clean:
	rm -f $(CLASSES)
