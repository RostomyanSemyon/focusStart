import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private boolean isDataNumeric;

    public boolean isDataNumeric() {
        return isDataNumeric;
    }

    public List<String> readFile(String fileName) {
        isDataNumeric = true;

        List<String> list = new ArrayList<>();

        String inputLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((inputLine = bufferedReader.readLine()) != null) {
                if (inputLine.equals("")) {
                    continue;
                }
                list.add(inputLine);
                isDataNumeric &= isStringNumeric(inputLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n" + e.getMessage());
            return list;
        } catch (IOException e) {
            System.out.println("File was not read properly\n" + e.getMessage());
        }

        return list;
    }

    private boolean isStringNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}