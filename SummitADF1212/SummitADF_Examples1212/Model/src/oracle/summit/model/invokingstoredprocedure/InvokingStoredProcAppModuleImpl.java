package oracle.summit.model.invokingstoredprocedure;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

import oracle.summit.base.SummitApplicationModuleImpl;
import oracle.summit.model.invokingstoredprocedure.common.InvokingStoredProcAppModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 18 14:22:37 CDT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InvokingStoredProcAppModuleImpl extends SummitApplicationModuleImpl implements InvokingStoredProcAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public InvokingStoredProcAppModuleImpl() {
    }
    
    
    public void callProcWithNoArgs() {
      getDBTransaction().executeCommand("begin invokestoredprocpkg.proc_with_no_args; end;");
    }
    public void callProcWithThreeArgs(Number n, Date d, String v) {
      callStoredProcedure("invokestoredprocpkg.proc_with_three_args(?,?,?)",
                          new Object[]{n,d,v});
    }
    public String callFuncWithThreeArgs(Number n, Date d, String v) {
      return (String)callStoredFunction(VARCHAR2,
                                "invokestoredprocpkg.func_with_three_args(?,?,?)",
                                new Object[]{n,d,v});
    }  
    public DateAndStringBean callProcWithOutArgs(Number n, String v) {
      CallableStatement st = null;
      try  {
        String stmt = "begin invokestoredprocpkg.proc_with_out_args(?,?,?); end;";
        st = getDBTransaction().createCallableStatement(stmt,0);
        st.registerOutParameter(2,Types.DATE);
        st.registerOutParameter(3,Types.VARCHAR);
        st.setObject(1,n);
        st.setObject(3,v);
        st.executeUpdate();
        DateAndStringBean result = new DateAndStringBean();
        result.setDateVal(new Date(st.getDate(2)));
        result.setStringVal(st.getString(3));
        return result;
      } catch (SQLException e)  {
        throw new JboException(e);
      } finally  {
        if (st != null) {
          try {
            st.close();
          }
          catch (SQLException e) {}
        }    
      }
    }   
    //----------------[ Begin Helper Code ]------------------------------
    public static int NUMBER = Types.NUMERIC;
    public static int DATE = Types.DATE;
    public static int VARCHAR2 = Types.VARCHAR;

    /**
     * Simplifies calling a stored procedure with bind variables
     * 
     * NOTE: If you want to invoke a stored procedure without any bind variables
     * ====  then you can just use the basic getDBTransaction().executeCommand()
     * 
     * @param stmt stored procedure statement to execute
     * @param bindVars Object array of parameters
     */
    protected void callStoredProcedure(String stmt, Object[] bindVars) {
      PreparedStatement st = null;
      try {
        st = getDBTransaction().createPreparedStatement("begin " + stmt +
            "; end;", 0);
        if (bindVars != null) {
          for (int z = 0; z < bindVars.length; z++) {
            st.setObject(z + 1, bindVars[z]);
          }
        }
        st.executeUpdate();
      }
      catch (SQLException e) {
        throw new JboException(e);
      }
      finally {
        if (st != null) {
          try {
            st.close();
          }
          catch (SQLException e) {}
        }
      }
    }
    /**
     * Simplifies calling a stored function with bind variables
     * 
     * You can use the NUMBER, DATE, and VARCHAR2 constants in this
     * class to indicate the function return type for these three common types,
     * otherwise use one of the JDBC types in the java.sql.Types class.
     * 
     * NOTE: If you want to invoke a stored procedure without any bind variables
     * ====  then you can just use the basic getDBTransaction().executeCommand()
     * 
     * @param sqlReturnType JDBC datatype constant of function return value
     * @param stmt stored function statement
     * @param bindVars Object array of parameters
     * @return function return value as an Object
     */
    protected Object callStoredFunction(int sqlReturnType, String stmt,
      Object[] bindVars) {
      CallableStatement st = null;
      try {
        st = getDBTransaction().createCallableStatement("begin ? := " + stmt +
            "; end;", 0);
        st.registerOutParameter(1, sqlReturnType);
        if (bindVars != null) {
          for (int z = 0; z < bindVars.length; z++) {
            st.setObject(z + 2, bindVars[z]);
          }
        }
        st.executeUpdate();
        return st.getObject(1);
      }
      catch (SQLException e) {
        throw new JboException(e);
      }
      finally {
        if (st != null) {
          try {
            st.close();
          }
          catch (SQLException e) {}
        }
      }
    }

    //----------------[ End Helper Code ]------------------------------  

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
      launchTester("oracle.summit.model.invokingstoredprocedure", /* package name */
        "InvokingStoredProcAppModuleLocal" /* Configuration Name */);
    }
    
    
    
    
    
    
}

