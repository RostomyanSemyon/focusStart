import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        List<String> sourceList = dataReader.readFile(args[0]);
        ParameterChecker.checkSortConsistent(args[2], args[3], dataReader.isDataNumeric());
        InsertSort is = new InsertSort();
        is.makeSort(args[2], args[3], dataReader.isDataNumeric(), sourceList, args[1]);
    }
}
