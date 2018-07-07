package oracle.summit.model.controlpostorder;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;

import oracle.jbo.server.TransactionEvent;

import oracle.summit.base.SummitEntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 22 21:48:05 CST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DeptEOImpl extends SummitEntityImpl {

    RowSet newEmployeesBeforePost = null;

    @Override
    public void postChanges(TransactionEvent transactionEvent) {
        /* Only bother to update references if Department is a NEW one */
        if (getPostState() == STATUS_NEW) {
        /*
        * Get a rowset of employees related
        * to this new department before calling super
        */
        newEmployeesBeforePost = (RowSet)getEmpEO();
        }
        super.postChanges(transactionEvent);
    }

    @Override
    protected void refreshFKInNewContainees() {
        if (newEmployeesBeforePost != null) {
            Number newDeptId = getId().getSequenceNumber();
          /* 
           * Process the rowset of employees that referenced
           * the new department prior to posting, and update their
           * Id attribute to reflect the refreshed Id value
           * that was assigned by a database sequence during posting.
           */
            while (newEmployeesBeforePost.hasNext()){
                EmpEOImpl emp =
                    (EmpEOImpl)newEmployeesBeforePost.next();
                emp.setDeptId(newDeptId);
            }
            closeNewProductRowSet();

        }  
    }
    
    private void closeNewProductRowSet() {
      if (newEmployeesBeforePost != null) {
        newEmployeesBeforePost.closeRowSet();
        newEmployeesBeforePost = null;
      }
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(DeptEOImpl obj) {
                return obj.getId();
            }

            public void put(DeptEOImpl obj, Object value) {
                obj.setId((DBSequence)value);
            }
        }
        ,
        Name {
            public Object get(DeptEOImpl obj) {
                return obj.getName();
            }

            public void put(DeptEOImpl obj, Object value) {
                obj.setName((String)value);
            }
        }
        ,
        RegionId {
            public Object get(DeptEOImpl obj) {
                return obj.getRegionId();
            }

            public void put(DeptEOImpl obj, Object value) {
                obj.setRegionId((Number)value);
            }
        }
        ,
        EmpEO {
            public Object get(DeptEOImpl obj) {
                return obj.getEmpEO();
            }

            public void put(DeptEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        RegionEO {
            public Object get(DeptEOImpl obj) {
                return obj.getRegionEO();
            }

            public void put(DeptEOImpl obj, Object value) {
                obj.setRegionEO((SummitEntityImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(DeptEOImpl object);

        public abstract void put(DeptEOImpl object, Object value);

        public int index() {
            return DeptEOImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return DeptEOImpl.AttributesEnum.firstIndex() + DeptEOImpl.AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = DeptEOImpl.AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ID = AttributesEnum.Id.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int REGIONID = AttributesEnum.RegionId.index();
    public static final int EMPEO = AttributesEnum.EmpEO.index();
    public static final int REGIONEO = AttributesEnum.RegionEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DeptEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.summit.model.controlpostorder.DeptEO");
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the value of Id
     */
    public DBSequence getId() {
        return (DBSequence)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(DBSequence value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for Name, using the alias name Name.
     * @return the value of Name
     */
    public String getName() {
        return (String)getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Name.
     * @param value value to set the Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for RegionId, using the alias name RegionId.
     * @return the value of RegionId
     */
    public Number getRegionId() {
        return (Number)getAttributeInternal(REGIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RegionId.
     * @param value value to set the RegionId
     */
    public void setRegionId(Number value) {
        setAttributeInternal(REGIONID, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmpEO() {
        return (RowIterator)getAttributeInternal(EMPEO);
    }

    /**
     * @return the associated entity oracle.summit.base.SummitEntityImpl.
     */
    public SummitEntityImpl getRegionEO() {
        return (SummitEntityImpl)getAttributeInternal(REGIONEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.summit.base.SummitEntityImpl.
     */
    public void setRegionEO(SummitEntityImpl value) {
        setAttributeInternal(REGIONEO, value);
    }

    /**
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence id) {
        return new Key(new Object[]{id});
    }


}