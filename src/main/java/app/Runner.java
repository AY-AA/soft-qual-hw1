package app;

import java.util.HashMap;

public class Runner {

    public static void main(String[] args) {
        chooseOption(new NamesParserImpl(), new PrinterImpl());
    }

    private static void chooseOption(NamesParser namesParser, Printer printer) {
        //todo: menu -- by questions pdf

        int numOfLI = namesParser.occurrencesInNameByString("a");
        printer.occurrencesInNameByStringPriner(numOfLI);

        HashMap<String, Integer> occurrencesInNameByLength = namesParser.occurrencesInNameByLength(2);
        printer.occurrencesInNameByLengthPrinter(occurrencesInNameByLength);

        String[] str = namesParser.theMostOccurrencesInAllNames(2);
        printer.occurrencesInMaxLengthPrinter(str);

        String[] contained = namesParser.namesAppearInString("AASSVVBBDAADASD");
        printer.namesContainedInStringPrinter(contained);
    }
}
