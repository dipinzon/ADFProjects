package oracle.summit.model.multinamedviewcriteria;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import oracle.summit.model.multinamedviewcriteria.common.CustomerView;

public class MultiNamedViewCriteriaTestClient {
    public MultiNamedViewCriteriaTestClient() {
        super();
    }
    
    public static void main(String[] args) {
    // get the applicaiton module
        String amDef = "oracle.summit.model.multinamedviewcriteria.AppModule";
        String config = "AppModuleLocal";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
    // get the CustomerView VO
        CustomerView vo = (CustomerView) am.findViewObject("CustomerView");


    // show the list of all rows in the CustomerView, without applying any view criteria
        
        showResults(vo,"All Customers");
        
    // use the type safe set method to set the value of the bind variable used by the view critera
        vo.setbv_SalesRepId(12);
        vo.showCustomersForSalesRep();
        showResults(vo, "All Customers with SalesRepId = 12");

    // set the sales rep id to 11 and show the reults
        vo.setbv_SalesRepId(11);
        vo.showCustomersForSalesRep();
        showResults(vo, "All Customers with SalesRepId = 11");


    // use the type safe set method to set the value of the bind variable used by the view critera 
        vo.setbv_CreditRatingId(2);
    // this method applies both view criteria to the VO so the relults will match both criteria
    // we didn't set the bind variable for sales rep as it was already set. The results will show
    // all the customers with the sales rep of 11 and a credit rating of 2
        vo.showCustomersForSalesRepForCreditRating();
        showResults(vo, "Customers with SalesRepId = 11 and CreditRating = 2");

    // now show all the customers again. the showAll Customers method resets the view criteria
        vo.showAllCustomers();
        showResults(vo, "All Customers");
        
        

        Configuration.releaseRootApplicationModule(am, true);
    }

    private static void showResults(ViewObject vo, String comment) {
        System.out.println("");
        System.out.println("---" + comment + " ---");
        System.out.println("");
        while (vo.hasNext()) {
            Row curUser = vo.next();
            System.out.println(curUser.getAttribute("Name") + " " + curUser.getAttribute("City") + " [" +
                               curUser.getAttribute("SalesRepId") + ", " + curUser.getAttribute("CreditRatingId") +
                               "]");
        }
    }    
    
    
    
    
}
