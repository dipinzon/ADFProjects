package oracle.summit.model.appmodule.service;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.client.Configuration;

public class TestAM {
    public TestAM() {
        super();
    }

    /*
     * Testing method
     */
    
    public static void main(String[] args) {
      String        amDef = "oracle.summit.model.appmodule.service.AppModule";
      String        config = "AppModuleLocal";
      ApplicationModule am = Configuration.createRootApplicationModule(amDef,config);
        /* 
         * NOTE: This cast to use the AppModuleImpl class is OK since this
         *       code is inside a business tier file and not in a
         *       client class that is accessing the business tier from "outside".
         */
        AppModuleImpl service = (AppModuleImpl)am;
        
        String customerName = service.findOrderAndCustomer(101);
    System.out.println("Customer for Order # 101 = " + customerName);
    try {
        service.updateOrderStatus(101,"Y");
    }
    catch (JboException ex) {
      System.out.println("ERROR: "+ex.getMessage());
    }
    Configuration.releaseRootApplicationModule(am,true);
    }

}
