import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("focus start");

        DataReader dataReader = new DataReader();
        List<String> sourceList = dataReader.readFile(args[0]);
        ParameterChecker.checkSortConsistent(args[2], args[3], DataReader.checkDataNumeric(sourceList));
        InsertSort is = new InsertSort();
        is.makeSort(args[2], args[3], DataReader.checkDataNumeric(sourceList),sourceList, args[1]);
    }
}
