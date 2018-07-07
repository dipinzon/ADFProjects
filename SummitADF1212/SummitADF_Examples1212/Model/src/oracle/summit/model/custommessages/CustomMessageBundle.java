package oracle.summit.model.custommessages;

import java.util.ListResourceBundle;

public class CustomMessageBundle extends ListResourceBundle {
    private static final Object[][] sMessageStrings 
        = new String[][] {
       {"27014","You must provide a value for {2}"},
       {"S_ORD_ORDER_FILLED_CK", "The order filled value must be Y or N"}
       };

    /**Return String Identifiers and corresponding Messages in a two-dimensional array.
     */
    protected Object[][] getContents() {
        return sMessageStrings;
    }
}