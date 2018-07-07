package oracle.summit.model.custommessages;

import oracle.jbo.DMLConstraintException;
import oracle.jbo.server.DBTransactionImpl2;
import oracle.jbo.server.TransactionEvent;

public class CustomDBTransactionImpl extends DBTransactionImpl2{
    /**
     * Overridden framework method that traps any ADF
     * exceptions thrown during the post/commit cycle,
     * and if they happen to be wrapping a database exception
     * representing a constraint violation, it rethrows a
     * new exception with a localized custom error message from the
     * CustomMessageBundle bundle, keyed by the name of the
     * database constraint that has been raised.
     * 
     * @param te The transaction event.
     */
    public void postChanges(TransactionEvent te) {
      try {
        super.postChanges(te);
      }
      /*
       * Catch the DML constraint exception
       * and perform custom error handling here
       */
      catch (DMLConstraintException ex) { 
        ex.setExceptions(null);
        throw ex;
      }
    }
    }
