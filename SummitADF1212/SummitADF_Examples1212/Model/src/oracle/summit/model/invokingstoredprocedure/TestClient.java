package oracle.summit.model.invokingstoredprocedure;

import oracle.summit.model.invokingstoredprocedure.common.InvokingStoredProcAppModule;
import oracle.jbo.domain.Number;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.*;


public class TestClient {
    public static void main(String[] args) {
      String        amDef = "oracle.summit.model.invokingstoredprocedure.InvokingStoredProcAppModule";
      String        config = "InvokingStoredProcAppModuleLocal";
      InvokingStoredProcAppModule svc = 
      (InvokingStoredProcAppModule)Configuration.createRootApplicationModule(amDef,config);
      svc.callProcWithNoArgs();
      Number n = new Number(101);
      Date   d = new Date(Date.getCurrentDate());
      String s = "Testing";
      svc.callProcWithThreeArgs(n,d,s);
      String result = svc.callFuncWithThreeArgs(n,d,s);
      System.out.println(result);
      DateAndStringBean b = svc.callProcWithOutArgs(n,s);
      System.out.println("Date returned is: "+b.getDateVal());
      System.out.println("String returned is: "+b.getStringVal());
      Configuration.releaseRootApplicationModule(svc,true);    
    }
    }
