import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertSort {

    private static final String stringSortMode = "string";
    private static final String intSortMode = "integer";
    private static final String ascendingOrder = "asc";
    private static final String descendingSortMode = "desc";


    public  void makeSort(String sortMode, String order, boolean numericState, List<String> sourceList, String outputFileName) {
        String[] res = null;
        if (sortMode.equals(intSortMode) & order.equals(ascendingOrder) & numericState) {
            List<Integer> array = new ArrayList<>();
            for (String el : sourceList) {
                Integer element = Integer.valueOf(el);
                array.add(element);
            }
            InsertSort is = new InsertSort();
            res = is.insertSort(array.toArray(new Integer[array.size()]), order);
        } else if (sortMode.equals(intSortMode) & order.equals(descendingSortMode) & numericState) {
            List<Integer> array = new ArrayList<>();
            for (String el : sourceList) {
                Integer element = Integer.valueOf(el);
                array.add(element);
            }
            InsertSort is = new InsertSort();
            res = is.insertSort(array.toArray(new Integer[array.size()]), order);
        } else if (sortMode.equals(stringSortMode) & order.equals(ascendingOrder)) {
            InsertSort is = new InsertSort();
            res = is.insertSort(sourceList.toArray(new String[sourceList.size()]), order);
        } else if (sortMode.equals(stringSortMode) & order.equals(descendingSortMode)) {
            InsertSort is = new InsertSort();
            res = is.insertSort(sourceList.toArray(new String[sourceList.size()]), order);
        }
        writeData(outputFileName, res);
    }

    private String[] insertSort(String[] array, String order) {
        if(order.equals(ascendingOrder)) {
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
        }
        else {
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
        if(order.equals(ascendingOrder)) {
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
        }
        else {
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

    private static void writeData(String fileName, String[] array){
        File file = new File(fileName);
        FileWriter fr = null;
        try{
            fr = new FileWriter(file);
            for(String el: array){
                fr.write(el);
                fr.flush();
                fr.write("\r\n");
                fr.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
