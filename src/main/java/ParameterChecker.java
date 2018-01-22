public class ParameterChecker {

    private static final String STRING_SORT_MODE = "string";
    private static final String INT_SORT_MODE = "integer";
    private static final String ASCENDING_ORDER = "asc";
    private static final String DESCENDING_SORT_MODE = "desc";

    public static void checkSortConsistent(String sortMode, String order, boolean numericState) {
        checkSortMode(sortMode);
        checkSortOrder(order);
        if (sortMode.equals(INT_SORT_MODE) & numericState == false) {
            System.out.println("Incompatible sorting options");
            System.exit(0);
        }
    }

    private static void checkSortOrder(String order) {
        if (order.equals(ASCENDING_ORDER) || order.equals(DESCENDING_SORT_MODE)) {
            return;
        } else {
            System.out.println("Incorrect sort order (" + order + ")");
            System.exit(0);
        }
    }

    private static void checkSortMode(String sortMode) {
        if (sortMode.equals(STRING_SORT_MODE) || sortMode.equals(INT_SORT_MODE)) {
            return;
        } else {
            System.out.println("Unavailable sort mode (" + sortMode + ")");
            System.exit(0);
        }
    }
}
