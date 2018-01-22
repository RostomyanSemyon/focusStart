import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertSort {

    private static final String STRING_SORT_MODE = "string";
    private static final String INT_SORT_MODE = "integer";
    private static final String ASCENDING_ORDER = "asc";
    private static final String DESCENDING_SORT_MODE = "desc";


    public void makeSort(String sortMode, String order, boolean numericState, List<String> sourceList, String outputFileName) {
        String[] res = null;
        if (sortMode.equals(INT_SORT_MODE) && numericState) {
            List<Integer> array = new ArrayList<>();
            for (String el : sourceList) {
                Integer element = Integer.valueOf(el);
                array.add(element);
            }
            res = this.insertSort(array.toArray(new Integer[array.size()]), order);
        } else if (sortMode.equals(STRING_SORT_MODE)) {
            res = this.insertSort(sourceList.toArray(new String[sourceList.size()]), order);
        }
        writeData(outputFileName, res);
    }

    private String[] insertSort(String[] array, String order) {
        if (order.equals(ASCENDING_ORDER)) {
            for (int j = 1; j < array.length; j++) {
                int i = j - 1;
                String value = array[j];
                while ((i >= 0) && (array[i]).compareTo(value) > 0) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = value;
            }
            return array;
        } else {
            for (int j = 1; j < array.length; j++) {
                int i = j - 1;
                String value = array[j];
                while ((i >= 0) && (array[i]).compareTo(value) < 0) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = value;
            }
            return array;
        }
    }


    private String[] insertSort(Integer[] array, String order) {
        if (order.equals(ASCENDING_ORDER)) {
            for (int j = 1; j < array.length; j++) {
                int i = j - 1;
                Integer value = array[j];
                while ((i >= 0) && (array[i]).compareTo(value) > 0) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = value;
            }
            String[] result = new String[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = (array[i]).toString();
            }
            return result;
        } else {
            for (int j = 1; j < array.length; j++) {
                int i = j - 1;
                Integer value = array[j];
                while ((i >= 0) && (array[i]).compareTo(value) < 0) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = value;
            }
            String[] result = new String[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = (array[i]).toString();
            }
            return result;
        }
    }

    private static void writeData(String fileName, String[] array) {
        File file = new File(fileName);
        try (FileWriter fr = new FileWriter(file)) {
            for (String el : array) {
                fr.write(el);
                fr.flush();
                fr.write("\r\n");
                fr.flush();
            }
        } catch (IOException e) {
            System.out.println("Couldn't open the file to write\n" + e.getMessage());
        }
    }
}
