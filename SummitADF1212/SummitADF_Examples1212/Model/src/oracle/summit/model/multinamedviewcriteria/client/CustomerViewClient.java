package oracle.summit.model.multinamedviewcriteria.client;

import oracle.jbo.client.remote.ViewUsageImpl;

import oracle.summit.model.multinamedviewcriteria.common.CustomerView;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 07 15:56:58 CST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CustomerViewClient extends ViewUsageImpl implements CustomerView {
    /**
     * This is the default constructor (do not remove).
     */
    public CustomerViewClient() {
    }


    public Integer getbv_CreditRatingId() {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"getbv_CreditRatingId",null,null);
        return (Integer) _ret;
    }

    public Integer getbv_SalesRepId() {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"getbv_SalesRepId",null,null);
        return (Integer) _ret;
    }

    public void setbv_CreditRatingId(Integer value) {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"setbv_CreditRatingId",new String [] {"java.lang.Integer"},new Object[] {value});
        return;
    }

    public void setbv_SalesRepId(Integer value) {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"setbv_SalesRepId",new String [] {"java.lang.Integer"},new Object[] {value});
        return;
    }

    public void showAllCustomers() {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"showAllCustomers",null,null);
        return;
    }

    public void showCustomersForCreditRating() {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"showCustomersForCreditRating",null,null);
        return;
    }

    public void showCustomersForSalesRep() {
        Object _ret = getApplicationModuleProxy().riInvokeExportedMethod(this,"showCustomersForSalesRep",null,null);
        return;
    }

    public void showCustomersForSalesRepForCreditRating() {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"showCustomersForSalesRepForCreditRating",null,null);
        return;
    }
}

