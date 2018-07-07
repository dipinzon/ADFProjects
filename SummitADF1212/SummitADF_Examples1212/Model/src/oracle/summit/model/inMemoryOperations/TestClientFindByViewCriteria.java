package oracle.summit.model.inMemoryOperations;


import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClientFindByViewCriteria {
    public static void main(String[] args) {
      String        amDef = "oracle.summit.model.inMemoryOperations.AppModule";
      String        config = "AppModuleLocal";
      ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
      // Uncomment this line to generate SQL Trace Information
      // am.getTransaction().executeCommand("ALTER SESSION SET SQL_TRACE TRUE");
      ViewObject vo = am.findViewObject("CustomerList");
      
      // Show customers with a last name starting with a 'M'
      ViewCriteria vc = vo.createViewCriteria();
      ViewCriteriaRow vcr1 = vc.createViewCriteriaRow();
      vcr1.setAttribute("Name","LIKE 'M%'");
      vo.applyViewCriteria(vc);
      vo.executeQuery();
      vc.add(vcr1);
      vo.executeQuery();
      showRows(vo, "Initial database results with applied view criteria - Name like M");
      
      // Subset results in memory to those with city starting with 'D'
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
      ViewCriteriaRow vcr2 = vc.createViewCriteriaRow();
      vcr2.setAttribute("City","LIKE 'D%'");
      vcr2.setConjunction(ViewCriteriaRow.VC_CONJ_AND);
      vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
      vc.add(vcr2);
      vo.executeQuery();
      showRows(vo,"After augmenting view criteria and applying in-memory - Cities with D");
      
      // Set conjuction back to OR and re-apply to database query to find
      // customers with name like 'M%' or city like 'D%'
      vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_QUERY);
      vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_DATABASE_TABLES);
      vcr2.setConjunction(ViewCriteriaRow.VC_CONJ_OR);
      vo.executeQuery();
      showRows(vo,"After changing view criteria and applying to database again - Name like M and City like D");
      
      // Define new critera to find customers with first or last name like '%a%'
      ViewCriteria nameContainsA = vo.createViewCriteria();
      ViewCriteriaRow rowContainsA = nameContainsA.createViewCriteriaRow();
      rowContainsA.setAttribute("Name","LIKE '%a%'");
      nameContainsA.add(rowContainsA);

      nameContainsA.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
      
      // Use new criteria in memory find new rowset rather than subsetting
      RowSet rs = (RowSet)vo.findByViewCriteria(nameContainsA,
                              -1,ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
      showRows(rs,"Rows returned from in-memory findByViewCriteria - Name contains A");
      
      showRows(vo,"Note findByViewCriteria didn't change rows in the view");

      Configuration.releaseRootApplicationModule(am, true);

    }
    private static void showRows(RowSet rs, String comment) {
      System.out.println("");
      System.out.println("--- " + comment + " ---");
      System.out.println("");
      rs.reset();
      while (rs.hasNext()) {
        Row r = rs.next();
        String name = (String)r.getAttribute("Name");
        String city = (String)r.getAttribute("City");
        System.out.println(name + " " + city);
      }
    }
    }
