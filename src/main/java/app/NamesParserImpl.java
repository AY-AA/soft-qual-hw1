package app;

import helper.NamesLoader;

import java.util.HashMap;

public class NamesParserImpl implements NamesParser {

    private final String[] names;


    public NamesParserImpl() {
        String[] namesFromFile = NamesLoader.getNames();
        names = namesFromFile == null ? new String[] {}: namesFromFile;
    }

    public int occurrencesInNameByString(String str) {
        int counter = 0;

        for (String name : names) {
            if (name.contains(str))
                counter++;
        }

        return counter;
    }

    public HashMap<String, Integer> occurrencesInNameByLength(int n) {
        HashMap<String, Integer> strOccurrences = new HashMap<String, Integer>();

        for (String name : names) {
            int leftSide = 0, rightSide = n;
            while (rightSide < name.length()) {

                String currSubString = name.substring(leftSide, rightSide);
                increaseHashMapInt(strOccurrences, currSubString);

                leftSide++;
                rightSide++;
            }

        }

        return strOccurrences;
    }

    private void increaseHashMapInt(HashMap<String, Integer> hashMap, String str) {
        if (hashMap.get(str) == null)
            hashMap.put(str, 1);
        else
            hashMap.put(str, hashMap.get(str) + 1);
    }

    



}