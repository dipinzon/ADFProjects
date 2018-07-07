package oracle.summit.model.viewobjects;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;


public class ProgrammaticVOCriteria {
        public static void main(String[] args) {

            // get the application module
      String amDef = "oracle.summit.model.viewobjects.AppModule";
            String config = "AppModuleLocal";
            ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);

            // Find the View Object you want to filter
            ViewObject customerList = am.findViewObject("SCustomerView1");
            
            // Work with your appmodule and view object here
            
            // iterate through all the rows first, just to see to full VO results
            customerList.executeQuery();
            while (customerList.hasNext()) {
                Row customer = customerList.next();
                System.out.println("Customer: " + customer.getAttribute("Name") + "   State: " + customer.getAttribute("State"));
            }
            System.out.println("*********** Set View Criteria and requery ************");
            
            // Create a view criteria row set for this view object
            ViewCriteria vc = customerList.createViewCriteria();
            
            // Use the view criteria row set to create one or more view criteria rows 
            ViewCriteriaRow vcr1 = vc.createViewCriteriaRow();
            
            // set attribute values to filter on
            vcr1.setAttribute("State", "TX");
            
            // Add the view criteria rows to the view criteria row set
            vc.add(vcr1);
            
            // Apply the view criteria to the view object
            customerList.applyViewCriteria(vc);
            
            // Execute the query
            customerList.executeQuery();
            
            // iterate throught the rows to see the new results
            while (customerList.hasNext()) {
                Row customer = customerList.next();
                System.out.println("Customer: " + customer.getAttribute("Name") + "   State: " + customer.getAttribute("State"));
            }
            
            System.out.println("*********** Set View Criteria and requery ************");
            
            // set the attribute to a different value
            vcr1.setAttribute("State", "CA");
            
            // Add the view criteria rows to the view criteria row set
            vc.add(vcr1);
            
            // Apply the view criteria to the view object
            customerList.applyViewCriteria(vc);
            
            // Execute the query
            customerList.executeQuery();
            
            // iterate throught the rows to see the new results
            while (customerList.hasNext()) {
                Row customer = customerList.next();
                System.out.println("Customer: " + customer.getAttribute("Name") + "   State: " + customer.getAttribute("State"));
            }

            
            
            
            
            Configuration.releaseRootApplicationModule(am, true);
        }
    }
