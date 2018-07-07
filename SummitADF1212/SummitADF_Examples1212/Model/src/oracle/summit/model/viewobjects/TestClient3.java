package oracle.summit.model.viewobjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import oracle.jbo.ApplicationModule;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient3 {
    public TestClient3() {
        super();
    }

    public static void main(String[] args) {
        String amDef = "oracle.summit.model.viewobjects.AppModule";
        String config = "AppModuleLocal";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
        // 1. Find the Orders view object instance
        ViewObject vo = am.findViewObject("SOrdView1");
        // 2. Construct a new Key to find Order # 100
        Key orderKey = new Key(new Object[] { 100 });
        // 3. Find the row matching this key
        Row[] ordersFound = vo.findByKey(orderKey, 1);
        if (ordersFound != null && ordersFound.length > 0) {
            Row order = ordersFound[0];
            // 4. Print some order information
            Date dateOrdered = (Date) order.getAttribute("DateOrdered");
            String orderDate = dateOrdered.toString();
            System.out.println("Order Date is: " + orderDate);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            Calendar c = Calendar.getInstance();
            try {
                c.setTime(sdf.parse(orderDate));
            } catch (ParseException e) {
            }
            c.add(Calendar.DAY_OF_MONTH, -2);  
            // // number of days to add 
            orderDate = sdf.format(c.getTime());  
            System.out.println(orderDate);
            try {
                // 5. Try setting the ship date to an illegal value
                order.setAttribute("DateShipped", orderDate);
                am.getTransaction().commit();
            } catch (JboException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
            // 6. Set the ship date to a legal value
            order.setAttribute("DateShipped", orderDate);
            // 7. Show the value of the ship date was updated successfully
            System.out.println("Ship date is: " + order.getAttribute("DateShipped"));
            // 8. Show the current value of the customer for this order
            System.out.println("Customer: " + order.getAttribute("CustomerId"));
            // 9. Reassign the order to customer # 210
            order.setAttribute("CustomerId", 210);
            // 10. Show the value of the reference information now
            System.out.println("Customer: " + order.getAttribute("CustomerId"));
            // 11. Rollback the transaction
            am.getTransaction().rollback();
            System.out.println("Transaction canceled");
        }
        Configuration.releaseRootApplicationModule(am, true);
    }

}
