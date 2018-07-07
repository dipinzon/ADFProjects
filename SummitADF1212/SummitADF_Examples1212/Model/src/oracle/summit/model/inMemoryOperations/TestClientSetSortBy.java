package oracle.summit.model.inMemoryOperations;


import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;

public class TestClientSetSortBy {
    public static void main(String[] args) {
      String        amDef = "oracle.summit.model.inMemoryOperations.AppModule";
      String        config = "AppModuleLocal";
      ApplicationModule am =
      Configuration.createRootApplicationModule(amDef,config);
      // Uncomment this line to generate SQL Trace Information
      am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE TRUE");
      ViewObject vo = am.findViewObject("CustomersInTx");
      vo.executeQuery();
      showRows(vo,"Initial database results");
      vo.setSortBy("Name");
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
      vo.executeQuery();

      showRows(vo,"After in-memory sorting by Customer Name ");
      vo.setSortBy("CreditRatingId desc, ZipCode");
      vo.executeQuery();
      showRows(vo,"After in-memory sorting by CreditRating desc, and ZipCode");
      am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE FALSE");      
      Configuration.releaseRootApplicationModule(am,true);

    }
    private static void showRows(ViewObject vo, String comment) {
      System.out.println("");
      System.out.println("--- "+comment+" ---");
      System.out.println("");
      while (vo.hasNext()) {
        Row r = vo.next();
        Integer id = (Integer)r.getAttribute("Id");
        String name = (String)r.getAttribute("Name");
        String address = (String)r.getAttribute("Address");
        Integer cr = (Integer)r.getAttribute("CreditRatingId");
        String zipcode = (String)r.getAttribute("ZipCode");
        String state = (String)r.getAttribute("State");
        System.out.println(id +","+name+","+address+","+zipcode + ", " +cr + ", " + state);
      }
    }
    }
