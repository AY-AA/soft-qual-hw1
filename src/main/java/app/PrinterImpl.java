package app;

import java.util.HashMap;
import java.util.Map;

public class PrinterImpl implements Printer{

    public void occurrencesInNameByStringPriner(int n) {
        System.out.println("" + n);
    }

    public void occurrencesInNameByLengthPrinter(HashMap<String, Integer> hashMap) {
        for (Map.Entry<String, Integer> currPair : hashMap.entrySet()) {
            System.out.println(currPair.getKey() + ":" + currPair.getValue());
        }

    }

    public void occurrencesInMaxLengthPrinter(String[] strings) {
        for (String str : strings)
            System.out.println(str);
    }

    public void namesContainedInStringPrinter(String[] strings) {
        for (String str : strings)
            System.out.println(str);
    }

    public void generatedNamePrinter(String name) {
        System.out.println(name);
    }
}
