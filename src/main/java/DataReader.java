import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public List<String> readFile(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n" + e.getMessage());

        }
        String inputLine;
        List<String> list = new ArrayList<>();
        try {
            while ((inputLine = bufferedReader.readLine()) != null) {
                if (inputLine.equals("")) {
                    continue;
                }
                list.add(inputLine);
            }
        } catch (IOException e) {
            System.out.println("File was not read properly\n" + e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                ;
            }
        }
        return list;
    }

    public static boolean checkDataNumeric(List<String> data) {
        boolean state = true;
        for (String el : data) {
            try {
                Integer.parseInt(el);
                state = true;
            } catch (NumberFormatException e) {
                state = false;
                return state;
            }
        }
        return state;
    }
}