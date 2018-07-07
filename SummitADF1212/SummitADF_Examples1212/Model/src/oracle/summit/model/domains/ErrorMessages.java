package oracle.summit.model.domains;

import java.util.ListResourceBundle;

public class ErrorMessages extends ListResourceBundle{
    public static final String INVALID_SHORTEMAIL = "30002";
    public static final String INVALID_EVENNUMBER = "30003";
    private static final Object[][] sMessageStrings = new String[][] {
        { INVALID_SHORTEMAIL,
          "A valid short email address has no @-sign or dot."},
        { INVALID_EVENNUMBER,
          "Number must be even."}
      };

    /**
     * Return String Identifiers and corresponding Messages in a two-dimensional array.
     */
    protected Object[][] getContents() {
      return sMessageStrings;
    }
}