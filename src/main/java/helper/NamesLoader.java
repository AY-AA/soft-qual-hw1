package helper;

import helper.FileHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class NamesLoader {

    private final static String FILE_PATH = "./src/names.txt";


    public static String[] getNames() {

        FileHelper fileParser = new FileHelper();
        BufferedReader reader = fileParser.loadFile(FILE_PATH);
        List<String> names = new LinkedList<String>();

        try {
            String line = reader.readLine();

            while (line != null) {
                names.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalNames = names.size();
        return names.toArray(new String[totalNames]);

    }
}
