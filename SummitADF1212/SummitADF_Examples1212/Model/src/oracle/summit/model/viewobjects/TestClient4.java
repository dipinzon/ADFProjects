package oracle.summit.model.viewobjects;

import java.util.Date;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.DBSequence;


public class TestClient4 {

    public static void main(String[] args) {
                String amDef = "oracle.summit.model.viewobjects.AppModule";
                String config = "AppModuleLocal";
                ApplicationModule am = 
                        Configuration.createRootApplicationModule(amDef, config);
                // 1. Find the Orders view object instance.
                ViewObject orders = am.findViewObject("SOrdView1");
                // 2. Create a new row and insert it into the row set
                Row newOrder = orders.createRow();
                orders.insertRow(newOrder);
                // Show the entity object-related defaulting for DateOrdered attribute
                System.out.println("DateOrdered defaults to: " + 
                                    newOrder.getAttribute("DateOrdered"));
                // 3. Set values for some of the required attributes        
                //Date now = new Date(new Timestamp(System.currentTimeMillis()));
                //newOrder.setAttribute("OrderDate", now);
                newOrder.setAttribute("CustomerId", 201);
                newOrder.setAttribute("SalesRepId", 12);
                newOrder.setAttribute("PaymentTypeId", 2);
                newOrder.setAttribute("OrderFilled", "N");
                // 4. Commit the transaction
                am.getTransaction().commit();
                // 5. Retrieve and display the trigger-assigned order id
                DBSequence id = (DBSequence)newOrder.getAttribute("Id");
                System.out.println("Thanks, reference number is " +
                                    id.getSequenceNumber());
                Configuration.releaseRootApplicationModule(am, true);
            }
        }
