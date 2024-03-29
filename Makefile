# Author: Dominik Harmim <harmim6@gmail.com>

PACK = project.zip

OUT_DIR = out
SRC_DIR = src
TESTS_DIR = tests
JAVADOC_DIR = javadoc

SRC_FILES = $(shell find $(SRC_DIR) -name *.java)
TEST_FILES = $(shell find $(TESTS_DIR) -name *.java)
DATA_FILE = data


.PHONY: run
run: $(OUT_DIR) $(DATA_FILE)
	java -cp $< stock.StockListApp $(DATA_FILE)


$(DATA_FILE):
	touch $@


.PHONY: test
test: $(OUT_DIR)
	cp /dev/null $(TESTS_DIR)/data
	java -cp $< stock.StockItemTester
	java -cp $< stock.StockListTester
	rm -f $(TESTS_DIR)/data


$(OUT_DIR): $(SRC_FILES) $(TEST_FILES)
	mkdir -p $@
	javac -d $@ $^


$(JAVADOC_DIR): $(SRC_DIR) $(SRC_FILES)
	rm -rf $@
	javadoc -private -use -version -author -linksource -d $@ -classpath $^


.PHONY: pack
pack: $(PACK)


$(PACK): $(SRC_DIR) $(TESTS_DIR) $(JAVADOC_DIR)
	zip -r $@ $^


.PHONY: clean
clean:
	rm -rf $(OUT_DIR) $(PACK) $(JAVADOC_DIR) $(DATA_FILE)
