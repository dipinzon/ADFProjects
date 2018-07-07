package oracle.summit.model.declblock;


import oracle.jbo.AttributeList;
import oracle.jbo.JboException;
import oracle.jbo.server.Entity;
import oracle.jbo.server.ViewRowImpl;

public class CustomViewRowImpl extends ViewRowImpl{
    public boolean isAttributeUpdateable(int index) {
      if (hasEntities() && 
          ((isNewOrInitialized() && !isInsertAllowed()) ||
           (isModifiedOrUnmodified() && !isUpdateAllowed()))) {
        return false;
      }
      return super.isAttributeUpdateable(index);
    }
    protected void setAttributeInternal(int index, Object val) {
      if (hasEntities()) {
        if (isNewOrInitialized() && !isInsertAllowed())
          throw new JboException("No inserts allowed in this view");
        else if (isModifiedOrUnmodified() && !isUpdateAllowed())
          throw new JboException("No updates allowed in this view");
      }
      super.setAttributeInternal(index, val);
    }
    public void remove() {
      if (!hasEntities() || isDeleteAllowed() || isNewOrInitialized())
        super.remove();
      else
          throw new JboException("Delete not allowed in this view");
    }
    protected void create(AttributeList nvp) {
      if (isInsertAllowed()) {
        super.create(nvp);
      } else {
        throw new JboException("Insert not allowed in this view");
      }
    }
    private boolean isNewOrInitialized() {
      byte s = getViewRowStatus();
      return s == Entity.STATUS_NEW || s == Entity.STATUS_INITIALIZED;
    }
    private boolean isModifiedOrUnmodified() {
      byte s = getViewRowStatus();
      return s == Entity.STATUS_UNMODIFIED || s == Entity.STATUS_MODIFIED;
    }
    private boolean isInsertAllowed() {
      return isStringInAppModulePropertyNamedAfterVOInstance("Insert");
    }
    private boolean isUpdateAllowed() {
      return isStringInAppModulePropertyNamedAfterVOInstance("Update");
    }
    private boolean isDeleteAllowed() {
      return isStringInAppModulePropertyNamedAfterVOInstance("Delete");
    }
    private boolean isStringInAppModulePropertyNamedAfterVOInstance(String s) {
      String voInstName = getViewObject().getName();
      String propVal = (String)getApplicationModule().getProperty(voInstName);
      return propVal != null ? propVal.indexOf(s) >= 0 : true;
    }
    private boolean hasEntities() {
      return getEntity(0) != null;
    }
    /*
     * By convention, we'll say that the state of this VO row
     * is the state of its first entity object.
     *
     * Only makes sense to call this if VO row has entities
     */
    private byte getViewRowStatus() {
      return getEntity(0).getEntityState();
    }
    }


