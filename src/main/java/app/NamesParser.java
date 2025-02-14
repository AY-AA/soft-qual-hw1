package app;

import java.util.HashMap;

interface NamesParser {

    // Q1
    int occurrencesInNameByString(String str);

    // Q2
    HashMap<String, Integer> occurrencesInNameByLength(int n);

    // Q3
    String[] theMostOccurrencesInAllNames(int n);

    //Q4
    String[] namesAppearInString(String str);

    //Q5 - Bonus
    String generateName();
}
