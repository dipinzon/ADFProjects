package oracle.summit.model.extend;


import oracle.jbo.ApplicationModule;
import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.StructureDef;
import oracle.jbo.ValidationException;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

import oracle.summit.model.extend.common.ProductView;
import oracle.summit.model.extend.common.ProductViewEx;
import oracle.summit.model.extend.common.ProductViewExRow;
import oracle.summit.model.extend.common.ProductViewRow;

public class TestClient {  
    public static void main(String[] args) {
    String        amDef = "oracle.summit.model.extend.AppModule";
    String        config = "AppModuleLocal";
    ApplicationModule am =
    Configuration.createRootApplicationModule(amDef,config);
    ProductView products = (ProductView)am.findViewObject("ProductView1");
    products.executeQuery();
    ProductViewRow product = (ProductViewRow)products.first();
    printAllAttributes(products,product);
    testSomethingOnProductsRow(product);
    products = (ProductView)am.findViewObject("ProductViewEx1");
    ProductViewEx productsByName = (ProductViewEx)products;
    productsByName.setbv_ProductName("bunny");
    productsByName.executeQuery();
    product = (ProductViewRow)productsByName.first();
    printAllAttributes(productsByName,product);
    testSomethingOnProductsRow(product);
    am.getTransaction().rollback();
    Configuration.releaseRootApplicationModule(am,true);
  }
  private static void testSomethingOnProductsRow(ProductViewRow product) {
    try {
      if (product instanceof ProductViewExRow) {
        ProductViewExRow productByName = (ProductViewExRow)product;
        productByName.someExtraFeature("Test");        
      }
      product.setName("Q");
      System.out.println("Setting the Name attribute to 'Q' succeeded.");
    }
    catch (ValidationException v) {
      System.out.println(v.getLocalizedMessage());      
    }    
  }
  private static void printAllAttributes(ViewObject vo, Row r) {
    String viewObjName = vo.getName();
    System.out.println("Printing attribute for a row in VO '"+
                       viewObjName+"'");
    StructureDef def = r.getStructureDef();
    StringBuilder sb = new StringBuilder();
    int numAttrs = def.getAttributeCount();
    AttributeDef[] attrDefs = def.getAttributeDefs();
    for (int z = 0; z < numAttrs; z++) {
      Object value = r.getAttribute(z);
      sb.append(z > 0 ? "  " : "")
        .append(attrDefs[z].getName())
        .append("=")
        .append(value == null ? "<null>" : value)
        .append(z < numAttrs - 1 ? "\n" : "");
    }
    System.out.println(sb.toString());
  }
}
