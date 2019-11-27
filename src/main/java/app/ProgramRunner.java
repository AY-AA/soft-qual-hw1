package app;

import java.util.HashMap;

public class ProgramRunner {

    private static final String[] QUESTIONS = { "CountSpecificString", "CountAllStrings",
                                                "CountMaxString", "AllIncludesString", "GenerateName" };

    private final Printer printer;
    private final NamesParser namesParser;

    public ProgramRunner(String[] args, Printer printer, NamesParser namesParser) {
        this.printer = printer;
        this.namesParser = namesParser;
        parseProgramInput(args);
    }

    private void parseProgramInput(String[] args) {
        if (args == null || args.length < 2)
            return;

        String question = args[0];
        String parameter = args.length == 2 ? args[1] : "";

        solveQuestion(question, parameter);
    }

    private void solveQuestion(String question, String parameter) {

        if (question == null || parameter == null){
            System.out.println("Invalid parameters: " + question + " " + parameter);
        }

        if (question.equals(QUESTIONS[0])) {
            int numOfLI = namesParser.occurrencesInNameByString(parameter);
            printer.occurrencesInNameByStringPriner(numOfLI);
        }

        else if (question.equals(QUESTIONS[1])) {
            int lengthToLookFor = parseIntFromString(parameter);
            HashMap<String, Integer> occurrencesInNameByLength = namesParser.occurrencesInNameByLength(lengthToLookFor);
            printer.occurrencesInNameByLengthPrinter(occurrencesInNameByLength);
        }

        else if (question.equals(QUESTIONS[2])) {
            int lengthToLookFor = parseIntFromString(parameter);
            String[] str = namesParser.theMostOccurrencesInAllNames(lengthToLookFor);
            printer.occurrencesInMaxLengthPrinter(str);
        }

        else if (question.equals(QUESTIONS[3])) {
            String[] contained = namesParser.namesAppearInString(parameter);
            printer.namesContainedInStringPrinter(contained);
        }

        else if (question.equals(QUESTIONS[4])) {
            //TODO: BONUS
        }

        else {
            System.out.println("Invalid parameters: " + question + " " + parameter);
        }
    }

    private int parseIntFromString(String parameter) {
        try {
            int lengthToLookFor = Integer.parseInt(parameter);
            return validateInt(lengthToLookFor);

        } catch (NumberFormatException e) {
            System.out.println("Invalid parameter.\n expected: positive number, given: " + parameter);
            return -1;
        }
    }

    private int validateInt(int lengthToLookFor) {
        if (lengthToLookFor >= 0)
            return lengthToLookFor;

        else {
            System.out.println("Invalid parameter.\n expected: positive number, given: " + lengthToLookFor);
            return -1;
        }
    }

    public static void main(String[] args) {
        new ProgramRunner(args, new PrinterImpl(), new NamesParserImpl());
    }

}
