package oracle.summit.model.viewobjects;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient2 {
    public static void main(String[] args) {
            String        amDef = "oracle.summit.model.viewobjects.AppModule";
            String config = "AppModuleLocal";
            ApplicationModule am = 
                Configuration.createRootApplicationModule(amDef, config);
            ViewObject vo = am.findViewObject("SCustomerView1");
          // Add an extra where clause with a new named bind variable
            vo.setWhereClause("credit_rating_id = :theCreditRating");
            vo.defineNamedWhereClauseParam("theCreditRating", null, null);
            vo.setNamedWhereClauseParam("theCreditRating", "4");
          // Show results when :theCreditRating = '4'
          executeAndShowResults(vo);
          Configuration.releaseRootApplicationModule(am, true);
        }
        private static void executeAndShowResults(ViewObject vo) {
          System.out.println("---");
          vo.executeQuery();
          while (vo.hasNext()) {
            Row curCustomer = vo.next();
            // Access the row set of details using the view link accessor attribute
            RowSet orders = (RowSet)curCustomer.getAttribute("SOrdView");
            long numOrders = orders.getEstimatedRowCount();
            System.out.println(curCustomer.getAttribute("Id") + " " + 
                               curCustomer.getAttribute("Name")+" ["+
                               numOrders+" orders]");
            while (orders.hasNext()) {
              Row curOrder = orders.next();
              System.out.println("--> (" + curOrder.getAttribute("Id") + ") " + 
                                 curOrder.getAttribute("Total"));
            }
          }
        }
}
