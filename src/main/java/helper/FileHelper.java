package helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHelper {

    private BufferedReader reader;
    private FileReader fileReader;

    public FileHelper (){}

    public BufferedReader loadFile(String path) {
        try {
            fileReader = new FileReader(path);
            reader = new BufferedReader(fileReader);
            return reader;

        } catch (IOException e) {
            System.out.println("There was a problem loading file");
            e.printStackTrace();
        }
        return null;
    }
}