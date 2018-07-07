package oracle.summit.model.appmodule.client;


import oracle.jbo.client.Configuration;
import oracle.jbo.*;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.*;

import oracle.summit.model.appmodule.service.common.AppModule;


public class TestClientCustomInterface {
    public static void main(String[] args) {
        String amDef = "devguide.examples.appmodules.StoreFrontService";
        String config = "StoreFrontServiceLocal";
       
        /*
         * This is the correct way to use application custom methods
         * from the client, by using the application module's automatically-
         * maintained custom service interface.
         */
        AppModule service = (AppModule)Configuration.createRootApplicationModule(amDef,config);
        String customerName = service.findOrderAndCustomer(101);
        System.out.println("Customer for Order # 101 = " + customerName);
            try {
                service.updateOrderStatus(101,"Y");
            }
            catch (JboException ex) {
              System.out.println("ERROR: "+ex.getMessage());
            }
            Configuration.releaseRootApplicationModule(service,true);
            }
}
