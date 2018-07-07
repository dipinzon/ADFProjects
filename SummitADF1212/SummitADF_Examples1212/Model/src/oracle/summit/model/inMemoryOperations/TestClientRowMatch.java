package oracle.summit.model.inMemoryOperations;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowMatch;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClientRowMatch {
    public static void main(String[] args) {
        String        amDef = "oracle.summit.model.inMemoryOperations.AppModule";
        String        config = "AppModuleLocal";
      ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
      // Uncomment this line to generate SQL Trace Information
      // am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE TRUE");
      ViewObject vo = am.findViewObject("CustomerList");
      vo.executeQuery();
      showRows(vo,"Initial database results");
      markOddRowsAsSelected(vo);
      showRows(vo,"After marking odd rows selected");
      RowMatch rm = new RowMatch("Selected = true");
      vo.setRowMatch(rm);
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
      vo.executeQuery();
      showRows(vo, "After in-memory filtering on only selected rows - Selected is True");

      rm = new RowMatch("Name like 'M%' or (Name like '%i%' and City like 'H%')");
      vo.setRowMatch(rm);
      vo.executeQuery();
      showRows(vo,"After in-memory filtering with more complex expression - Name like M%, OR name contains i and City like H% ");
      vo.setRowMatch(null);
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_DATABASE_TABLES);
      vo.executeQuery();
      showRows(vo,"After re-querying to see a full list again");

      Configuration.releaseRootApplicationModule(am, true);
    }
    private static void markOddRowsAsSelected(ViewObject vo) {
      vo.reset();
      while (vo.hasNext()) {
        Row r = vo.next();
        if (vo.getCurrentRowIndex() % 2 == 1) {
          r.setAttribute("Selected",Boolean.TRUE);
        }
      }
    }
    private static void showRows(ViewObject vo, String comment) {
      System.out.println("");  
      System.out.println("--- "+comment+" ---");
      System.out.println("");
      vo.reset();
      while (vo.hasNext()) {
        Row r = vo.next();
        String name = (String)r.getAttribute("Name");
        String city = (String)r.getAttribute("City");
        Boolean sel = (Boolean)r.getAttribute("Selected");
        System.out.println(name + " " + city + " [" + sel + "]");
      }
    }
}
