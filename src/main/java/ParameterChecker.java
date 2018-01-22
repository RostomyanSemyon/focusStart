public class ParameterChecker {

    private static final String stringSortMode = "string";
    private static final String intSortMode = "integer";
    private static final String ascendingOrder = "asc";
    private static final String descendingSortMode = "desc";

    public static void checkSortConsistent(String sortMode, String order, boolean numericState){
        checkSortMode(sortMode, numericState);
        checkSortOrder(order);
        if(sortMode.equals(intSortMode) & numericState == false){
            System.out.println("Incompatible sorting options");
            System.exit(0);
        }
        return;
    }

    private static void checkSortOrder(String order){
        if(order.equals(ascendingOrder) || order.equals(descendingSortMode)){
            return;
        }
        else {
            System.out.println("Incorrect sort order (" + order + ")");
            System.exit(0);
        }
    }

    private static void checkSortMode(String sortMode, boolean numericState){
        if(sortMode.equals(stringSortMode) || sortMode.equals(intSortMode) ){
            return;
        }
        else {
            System.out.println("Unavailable sort mode ("+sortMode+")");
            System.exit(0);
        }
    }
}
