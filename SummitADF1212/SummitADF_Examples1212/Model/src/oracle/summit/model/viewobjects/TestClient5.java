package oracle.summit.model.viewobjects;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient5 {
    public static void main(String[] args) {
            String amDef = "oracle.summit.model.viewobjects.AppModule";
            String config = "AppModuleLocal";
        ApplicationModule am = 
             Configuration.createRootApplicationModule(amDef, config);
         // 1. Find the Orders view object instance
         ViewObject vo = am.findViewObject("SOrdView1");
         // 2. Construct a key to find order number 100
         Key orderKey = new Key(new Object[] { 100 });
         // 3. Find the Orders row with the key
         Row[] ordersFound = vo.findByKey(orderKey, 1);
         if (ordersFound != null && ordersFound.length > 0) {
             Row order = ordersFound[0];
             // 4. Displays the key of the Orders row
             showKeyFor(order);
             // 5. Accesses row set of Orders using OrderItems view link accessor
             RowSet items = (RowSet)order.getAttribute("SItemView");
             // 6. Iterates over the Items row
             while (items.hasNext()) {
                 Row itemRow = items.next();
                 // 4. Displays the key of each Items row
                 showKeyFor(itemRow);
             }
         }
         Configuration.releaseRootApplicationModule(am, true);
        }

        private static void showKeyFor(Row r) {
         // get the key for the row passed in
         Key k = r.getKey();
         // format the key as "(val1,val2)"
         String keyAttrs = formatKeyAttributeNamesAndValues(k);
         // get the serialized string format of the key, too
         String keyStringFmt = r.getKey().toStringFormat(false);
         System.out.println("Key " + keyAttrs + " has string format " + 
                             keyStringFmt);
        }
        // Build up "(val1,val2)" string for key attributes

        private static String formatKeyAttributeNamesAndValues(Key k) {
         StringBuffer sb = new StringBuffer("(");
         int attrsInKey = k.getAttributeCount();
         for (int i = 0; i < attrsInKey; i++) {
             if (i > 0)
                 sb.append(",");
                 sb.append(k.getAttributeValues()[i]);
         }
         sb.append(")");
         return sb.toString();
        }
        }
