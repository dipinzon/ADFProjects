package oracle.summit.model.custommessages;

import oracle.jbo.server.DBTransactionImpl2;
import oracle.jbo.server.DatabaseTransactionFactory;

/**
 * Custom ADF Framework Extension Class for ADF Transaction Factory
 *
 * It's only role in life is returning instances of the custom subclass
 * of DBTransactionImpl2 instead of the default framework base class for
 * a transaction implementation.
 *
 * In order for this custom factory to get used, set the ADF business
 * components configuration property 'TransactionFactory' to the
 * fully-qualified name of this class.
 * @author you
 */
public class CustomDatabaseTransactionFactory extends DatabaseTransactionFactory {
  public CustomDatabaseTransactionFactory() {
  }
  /**
   * Return an instance of our custom CustomDBTransactionImpl class
   * instead of the default implementation.
   *
   * @return An instance of our custom DBTransactionImpl implementation.
   */
  public DBTransactionImpl2 create() {
    return new CustomDBTransactionImpl();
  }    
}