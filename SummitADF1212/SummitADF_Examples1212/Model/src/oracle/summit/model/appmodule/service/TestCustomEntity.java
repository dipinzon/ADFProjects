package oracle.summit.model.appmodule.service;


    import oracle.jbo.client.Configuration;
    import oracle.jbo.*;
    import oracle.jbo.domain.Number;
    import oracle.jbo.domain.*;

import oracle.summit.model.appmodule.service.common.AppModule;

public class TestCustomEntity {
        public static void main(String[] args) {
            String amDef = "oracle.summit.model.appmodule.service.AppModule";
            String config = "AppModuleLocal";
           
            /*
             * This is the correct way to use application custom methods
             * from the client, by using the application module's automatically-
             * maintained custom service interface.
             */
            AppModule service = (AppModuleImpl)Configuration.createRootApplicationModule(amDef,config);
            String total = service.findOrderTotal(1011);
            System.out.println("Total for Order # 1011 = " + total);
            String custName = service.findOrderAndCustomer(1011);
            System.out.println("Customer for Order # 1011 = " + custName);
             try {
               service.updateOrderStatus(1011,"Y");
             }
             catch (JboException ex) {
               System.out.println("ERROR: "+ex.getMessage());
             }
             long id = 0;
             try {
               id = service.createCustomer(null, "Oakville", 14);
             }
             catch (JboException ex) {
               System.out.println("ERROR: "+ex.getMessage());
             }
             id = service.createCustomer("Oakville Curling Club", "Oakville", 14);
             System.out.println("New customer created successfully with id = " + id);
            Configuration.releaseRootApplicationModule(service,true);
            }
    }
