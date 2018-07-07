package oracle.summit.model.processChange;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewObjectImpl;


public class processChangeTestClient {
    public static void main(String[] args) {
        processChangeTestClient processChangeTestClient = new processChangeTestClient();
        
        ApplicationModuleHandle handle = null;
        String amDef = "oracle.summit.model.services.BackOfficeAppModule";
        String config = "BackOfficeAppModuleLocal";
        try {
            handle = Configuration.createRootApplicationModuleHandle(amDef, config);
            ApplicationModule am = handle.useApplicationModule();
            am.processChangeNotifications();
        
            ViewObject vo = am.findViewObject("Inventory");
            ((ViewObjectImpl)vo).refreshCollection(null, false, false);
            vo.reset();            
                           
        
            while (vo.hasNext()) {
                Row r = vo.next();
                System.out.println((String)r.getAttribute("Name"));        
                }
        } finally {
            if (handle != null)
           Configuration.releaseRootApplicationModuleHandle(handle, false);         
        }
    
        
    }
}
