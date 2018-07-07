package oracle.summit.model.appmodule.service.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 04 08:21:48 CDT 2012
// ---------------------------------------------------------------------
public interface AppModule extends ApplicationModule {
    void doSomeCustomProcessing();

    String findOrderAndCustomer(long orderId);

    void updateOrderStatus(long orderId, String newStatus);
    
    String findOrderTotal (long orderId);
    
    long createCustomer(String name, String city, Integer countryId);

}
