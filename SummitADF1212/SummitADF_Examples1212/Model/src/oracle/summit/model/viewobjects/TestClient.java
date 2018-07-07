package oracle.summit.model.viewobjects;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient {
    public static void main(String[] args) {
        TestClient testClient = new TestClient();
        String        amDef = "oracle.summit.model.viewobjects.AppModule";
        String        config = "AppModuleLocal";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef,config);
        // Work with your appmodule and view object here
        // 1. Find the Customer view object instance.
        ViewObject customerList = am.findViewObject("SCustomerView1");
        // 2. Execute the query
          customerList.executeQuery();
          // 3. Iterate over the resulting rows
          while (customerList.hasNext()) {
              Row customer = customerList.next();
              // 4. Print the person's email
              System.out.println("Customer: " + customer.getAttribute("Name"));
              // 5. Get related rowset of Orders using view link accessor attribute
              RowSet orders = (RowSet)customer.getAttribute("SOrdView");
              // 6. Iterate over the Orders rows
              while (orders.hasNext()) {
                  Row order = orders.next();
                  // 7. Print out some order attribute values
                    System.out.println(" ["+order.getAttribute("CustomerId")+"] "+
                                          order.getAttribute("Id")+": "+
                                          order.getAttribute("Total"));
                  Object orderFilled = order.getAttribute("OrderFilled");
                  if (orderFilled != null && orderFilled.equals("Y")){
                        // 8. Get related rowset of Items
                        RowSet items = (RowSet)order.getAttribute("SItemView");
                        // 9. Iterate over the Items rows
                        while (items.hasNext()) {
                           Row item = items.next();
                           // 10. Print out some order items attributes
                           System.out.println("  "+item.getAttribute("ItemId")+": $"+
                                                item.getAttribute("Price"));
                      }                  
                  }
              }
          }
        Configuration.releaseRootApplicationModule(am, true);
    }
}
