package app;

import helper.NamesLoader;

import java.util.*;

public class NamesParserImpl implements NamesParser {

    private final String[] names;


    NamesParserImpl() {
        String[] namesFromFile = NamesLoader.getNames();
        names = namesFromFile == null ? new String[] {}: namesFromFile;
    }

    public int occurrencesInNameByString(String str) {
        int counter = 0;

        if (names == null) return counter;

        for (String name : names) {
            if (name.contains(str))
                counter++;
        }

        return counter;
    }

    public HashMap<String, Integer> occurrencesInNameByLength(int n) {
        HashMap<String, Integer> strOccurrences = new HashMap<String, Integer>();

        if (names == null) return strOccurrences;

        for (String name : names) {
            int leftSide = 0, rightSide = n;
            while (rightSide <= name.length()) {

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

    public String[] theMostOccurrencesInAllNames(int n) {
        HashMap<String, Integer> occurrences = occurrencesInNameByLength(n);

        if (occurrences == null)
            return new String[0];

        Iterator iterator = occurrences.values().iterator();
        int maxOccurrences = 0;

        while (iterator.hasNext()) {
            int currOccurrence = (Integer) iterator.next();
            maxOccurrences = currOccurrence > maxOccurrences ? currOccurrence : maxOccurrences;
        }

        if (maxOccurrences == 0) // no occurrences n-lengthed
            return new String[0];

        List<String> stringsWithMaxLength = new LinkedList<String>();

        for (Map.Entry<String, Integer> currPair : occurrences.entrySet()) {
            if (currPair.getValue() == maxOccurrences)
                stringsWithMaxLength.add(currPair.getKey());
        }

        int numOfStringsInMaxLength = stringsWithMaxLength.size();
        return stringsWithMaxLength.toArray(new String[numOfStringsInMaxLength]);
    }

    public String[] namesAppearInString(String str) {
        List<String> namesContained = new Stack<String>();

        for (String name : names) {
            if (str.contains(name))
                namesContained.add(name);
        }

        int numOfNamesContained = namesContained.size();
        return namesContained.toArray(new String[numOfNamesContained]);
    }


}