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

    public String generateName() {
        String generatedName = getFirstChar();
        while (uniqueCharacters((generatedName))){
            generatedName += updateRes(generatedName);
        }
        return generatedName.substring(0, generatedName.length() - 1);
    }

    private String getFirstChar() {
        HashMap<String, Integer> occurrences = new HashMap<String, Integer>();
        for (String name : names) {
            increaseHashMapInt(occurrences, "" + name.charAt(0));
        }
        return getMaxFromHash(occurrences);
    }

    private String updateRes(String resSoFar) {
        HashMap<String, Integer> occurrences = new HashMap<String, Integer>();
        char ch = 'a';

        while (ch <= 'z') {
            if(resSoFar.length() < 2) {
                occurrences.put(resSoFar + ch, 0);
                occurrences.put(resSoFar.toLowerCase() + ch, 0);
            }
            else {
                occurrences.put(resSoFar.substring(resSoFar.length() - 1) + ch, 0);
            }
            ch++;
        }

        for (String key : occurrences.keySet()) {
            int nubOfOccurrences = occurrencesInNameByString(key);
            occurrences.put(key, nubOfOccurrences);
        }
        return getMaxFromHash(occurrences).substring(1);
    }

    private boolean uniqueCharacters(String str) {
        // Taken from GeeksForGeeks

        // Assuming string can have characters a-z
        // this has 32 bits set to 0
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int bitAtIndex = str.charAt(i) - 'a';

            // if that bit is already set in checker,
            // return false
            if ((checker & (1 << bitAtIndex)) > 0)
                return false;

            // otherwise update and continue by
            // setting that bit in the checker
            checker = checker | (1 << bitAtIndex);
        }

        // no duplicates encountered, return true
        return true;
    }

    private String getMaxFromHash(HashMap<String, Integer> hashMap) {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {

            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

}