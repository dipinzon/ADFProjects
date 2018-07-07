package oracle.summit.model.wrapplsql;

import oracle.summit.base.SummitEntityImpl;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jbo.JboException;
import oracle.jbo.RowInconsistentException;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

public class PLSQLEntityImpl extends SummitEntityImpl {
    //----------------[ Begin Helper Code ]------------------------------
    public static int NUMBER = Types.NUMERIC;
    public static int DATE = Types.DATE;
    public static int VARCHAR2 = Types.VARCHAR;

    /**
     * Override the default doSelect processing
     * to invoke an appropriate stored procedure
     * instead of performing the
     * @param lock
     */
    protected void doSelect(boolean lock) {
        if (lock) {
            callLockProcedureAndCheckForRowInconsistency();
        } else {
            callSelectProcedure();
        }
    }

    /**
     * Override the default doDML() processing to
     * invoke an appropriate stored procedure instead
     * of performing the default.
     */
    protected void doDML(int operation, TransactionEvent e) {
        // super.doDML(operation, e);
        if (operation == DML_INSERT)
            callInsertProcedure(e);
        else if (operation == DML_UPDATE)
            callUpdateProcedure(e);
        else if (operation == DML_DELETE)
            callDeleteProcedure(e);
    }
    
    /* Override in a subclass to perform non-default processing */

    protected void callInsertProcedure(TransactionEvent e) {
        super.doDML(DML_INSERT, e);
    }
    
    /* Override in a subclass to perform non-default processing */

    protected void callUpdateProcedure(TransactionEvent e) {
        super.doDML(DML_UPDATE, e);
    }
    
    /* Override in a subclass to perform non-default processing */

    protected void callDeleteProcedure(TransactionEvent e) {
        super.doDML(DML_DELETE, e);
    }
    
    /* Override in a subclass to perform non-default processing */

    protected void callLockProcedureAndCheckForRowInconsistency() {
        super.doSelect(true);
    }
    
    /* Override in a subclass to perform non-default processing */

    protected void callSelectProcedure() {
        super.doSelect(false);
    }

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
            st = 
 getDBTransaction().createPreparedStatement("begin " + stmt + "; end;", 0);
            if (bindVars != null) {
                for (int z = 0; z < bindVars.length; z++) {
                    st.setObject(z + 1, bindVars[z]);
                }
            }
            st.executeUpdate();
        } catch (SQLException e) {
            throw new JboException(e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    /**
     * Helps subclasses detect whether old attribute values
     * are different from new attribute values retrieved at
     * locking time.
     * @param attrIndex
     * @param newVal
     */
    protected void compareOldAttrTo(int attrIndex, Object newVal) {
        if ((getPostedAttribute(attrIndex) == null && newVal != null) || 
            (getPostedAttribute(attrIndex) != null && newVal == null) || 
            (getPostedAttribute(attrIndex) != null && newVal != null && 
             !getPostedAttribute(attrIndex).equals(newVal))) {
            throw new RowInconsistentException(getKey());
        }
    }
    //----------------[ End Helper Code ]------------------------------  
}
