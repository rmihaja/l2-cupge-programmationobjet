PREFIX=tp_
BIN=./bin
SRC=./src
DOCS=./docs

/$(PREFIX)%: ./$(PREFIX)%
	echo "Directory already exists"

./$(PREFIX)%:
	mkdir .$@
	cd .$@ && mkdir $(BIN) && mkdir $(SRC) && mkdir $(DOCS)
	touch .$@/bin/.gitkeep

gitkeep/%:
	for d in ./$*/*; do\
		cd $$d;\
		touch .gitkeep;\
		cd ../..;\
    done