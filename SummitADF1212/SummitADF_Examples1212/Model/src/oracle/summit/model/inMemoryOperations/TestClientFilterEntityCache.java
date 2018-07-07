package oracle.summit.model.inMemoryOperations;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClientFilterEntityCache {
    public static void main(String[] args) {
      String        amDef = "oracle.summit.model.inMemoryOperations.AppModule";
      String        config = "AppModuleLocal";
      ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
      // Uncomment this line to generate SQL Trace Information
      // am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE TRUE");
      ViewObject vo = am.findViewObject("CreateProductsView");
      vo.setAssociationConsistent(false);
      Row newProd1 = vo.createRow();
      newProd1.setAttribute("Id","9997");
      newProd1.setAttribute("Name","First of the new products");
      vo.insertRow(newProd1);
      Row newProd2 = vo.createRow();
      newProd2.setAttribute("Id","9998");
      newProd2.setAttribute("Name","Product with interesting features");
      vo.insertRow(newProd2);    
      vo.clearCache();
      showRows(vo,"After adding two new entities and clearing the VO cache");
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_ENTITY_ROWS);
      ViewCriteria vc = vo.createViewCriteria();
      ViewCriteriaRow vcr = vc.createViewCriteriaRow();
      vcr.setAttribute("Name","LIKE '%interesting%'");
      vc.add(vcr);
      vo.applyViewCriteria(vc);
      vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
    //    vo.setRowMatch(new RowMatch("Name LIKE '%interesting%'"));
      vo.executeQuery();
      showRows(vo,"After performing in-memory query over EO cache");
      Configuration.releaseRootApplicationModule(am, true);
    }
    private static void showRows(RowSet rs, String comment) {
      System.out.println("");  
      System.out.println("--- " + comment + " ---");
      System.out.println("");
      rs.reset();
      while (rs.hasNext()) {
        Row r = rs.next();
        String id = (String)r.getAttribute("Id").toString();
        String name = (String)r.getAttribute("Name");
        System.out.println(id + ", " + name);
      }
    }
    }

