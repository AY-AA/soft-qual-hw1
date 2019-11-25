package app;

import java.util.HashMap;

public class Runner {

    public static void main(String[] args) {
        chooseOption(new NamesParserImpl(), new PrinterImpl());
    }

    private static void chooseOption(NamesParser namesParserImpl, Printer printer) {
        //todo: menu -- by questions pdf

        int numOfLI = namesParserImpl.occurrencesInNameByString("a");
        printer.occurrencesInNameByStringPriner(numOfLI);

        HashMap<String, Integer> occurrencesInNameByLength = namesParserImpl.occurrencesInNameByLength(1);
        printer.occurrencesInNameByLengthPrinter(occurrencesInNameByLength);

    }
}
