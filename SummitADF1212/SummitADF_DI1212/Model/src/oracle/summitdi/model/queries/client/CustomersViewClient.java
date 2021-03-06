package oracle.summitdi.model.queries.client;

import oracle.jbo.client.remote.ViewUsageImpl;

import oracle.summitdi.model.queries.common.CustomersView;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 22 17:51:39 PDT 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CustomersViewClient extends ViewUsageImpl implements CustomersView {
  /**
   * This is the default constructor (do not remove).
   */
  public CustomersViewClient() {
  }

  public void executeCountriesQuery(String searchTerm) {
    Object _ret =
      getApplicationModuleProxy().riInvokeExportedMethod(this,"executeCountriesQuery",new String [] {"java.lang.String"},new Object[] {searchTerm});
    return;
  }

  public void resetQueryValues() {
    Object _ret =
      getApplicationModuleProxy().riInvokeExportedMethod(this,"resetQueryValues",null,null);
    return;
  }
}
