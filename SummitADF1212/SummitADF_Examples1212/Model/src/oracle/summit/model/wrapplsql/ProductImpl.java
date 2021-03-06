package oracle.summit.model.wrapplsql;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.SQLException;

import oracle.jbo.AlreadyLockedException;
import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 23 14:50:11 CST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProductImpl extends PLSQLEntityImpl {
    @Override
    protected void callDeleteProcedure(TransactionEvent e) {
        callStoredProcedure("products_api.delete_product(?)",
        new Object[] { getId() });
    }

    @Override
    protected void callInsertProcedure(TransactionEvent e) {
        callStoredProcedure("products_api.insert_product(?,?,?,?,?,?,?)",
        new Object[] { getId(), getName(), getShortDesc(), getLongtextId(), 
                       getImageId(), getSuggestedWhlslPrice(), getWhlslUnits() });
    }

    @Override
    protected void callLockProcedureAndCheckForRowInconsistency() {
        String stmt = "begin products_api.lock_product(?,?,?,?,?,?,?);end;";
        CallableStatement st = 
            getDBTransaction().createCallableStatement(stmt, 0);
        try {
            st.registerOutParameter(2, VARCHAR2);
            st.registerOutParameter(3, VARCHAR2);
            st.registerOutParameter(4, NUMBER);
            st.registerOutParameter(5, NUMBER);
            st.registerOutParameter(6, NUMBER);
            st.registerOutParameter(7, VARCHAR2);
            st.setObject(1, getId());
            st.executeUpdate();
            String possiblyUpdatedName = st.getString(2);
            String possiblyUpdatedShortDesc = st.getString(3);
            String possiblyUpdatedLongTextId = st.getString(4);
            String possiblyUpdatedImageId = st.getString(5);
            String possiblyUpdatedSuggestedPrice = st.getString(6);
            String possiblyUpdatedWlhslUnits = st.getString(7);
            compareOldAttrTo(NAME, possiblyUpdatedName);
            compareOldAttrTo(SHORTDESC, possiblyUpdatedShortDesc);
            compareOldAttrTo(LONGTEXTID, possiblyUpdatedLongTextId);
            compareOldAttrTo(IMAGEID, possiblyUpdatedImageId);
            compareOldAttrTo(SUGGESTEDWHLSLPRICE, possiblyUpdatedSuggestedPrice);
            compareOldAttrTo(WHLSLUNITS, possiblyUpdatedWlhslUnits);
        } catch (SQLException e) {
            if (Math.abs(e.getErrorCode()) == 54) {
                throw new AlreadyLockedException(e);
            } else {
                throw new JboException(e);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
            }
        }    }

    @Override
    protected void callSelectProcedure() {
        String stmt = "begin products_api.select_product(?,?,?,?,?,?,?);end;";
        // 1. Create a CallableStatement for the PLSQL block to invoke
        CallableStatement st = 
            getDBTransaction().createCallableStatement(stmt, 0);
        try {
            // 2. Register the OUT parameters and types
            st.registerOutParameter(2, VARCHAR2);
            st.registerOutParameter(3, VARCHAR2);
            st.registerOutParameter(4, NUMBER);
            st.registerOutParameter(5, NUMBER);
            st.registerOutParameter(6, NUMBER);
            st.registerOutParameter(7, VARCHAR2);

            // 3. Set the IN parameter value
            st.setObject(1, getId());
            // 4. Execute the statement
            st.executeUpdate();
            // 5. Retrieve the possibly updated column values
            String possiblyUpdatedName = st.getString(2);
            String possiblyUpdatedShortDesc = st.getString(3);
            String possiblyUpdatedLongTextId = st.getString(4);
            String possiblyUpdatedImageId = st.getString(5);
            String possiblyUpdatedSuggestedPrice = st.getString(6);
            String possiblyUpdatedWhlslUnits = st.getString(7);

            // 6. Populate the possibly updated attribute values in the row
            populateAttribute(NAME, possiblyUpdatedName, true, false, 
                              false);
            populateAttribute(SHORTDESC, possiblyUpdatedShortDesc, true, 
                              false, false);
            populateAttribute(LONGTEXTID, possiblyUpdatedLongTextId, true, false, 
                              false);
            populateAttribute(IMAGEID, possiblyUpdatedImageId, true, false, 
                              false);
            populateAttribute(SUGGESTEDWHLSLPRICE, possiblyUpdatedSuggestedPrice, true, false, 
                              false);
            populateAttribute(WHLSLUNITS, possiblyUpdatedWhlslUnits, true, 
                              false, false);
        } catch (SQLException e) {
            throw new JboException(e);
        } finally {
            if (st != null) {
                try {
                    // 7. Closing the statement
                    st.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    @Override
    protected void callUpdateProcedure(TransactionEvent e) {
        callStoredProcedure("products_api.update_product(?,?,?,?,?,?)",
        new Object[] { getId(), getName(), getShortDesc(), getLongtextId(), 
                       getImageId(), getSuggestedWhlslPrice(), getWhlslUnits() });
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(ProductImpl obj) {
                return obj.getId();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setId((Integer)value);
            }
        }
        ,
        Name {
            public Object get(ProductImpl obj) {
                return obj.getName();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setName((String)value);
            }
        }
        ,
        ShortDesc {
            public Object get(ProductImpl obj) {
                return obj.getShortDesc();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setShortDesc((String)value);
            }
        }
        ,
        LongtextId {
            public Object get(ProductImpl obj) {
                return obj.getLongtextId();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setLongtextId((Integer)value);
            }
        }
        ,
        ImageId {
            public Object get(ProductImpl obj) {
                return obj.getImageId();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setImageId((Integer)value);
            }
        }
        ,
        SuggestedWhlslPrice {
            public Object get(ProductImpl obj) {
                return obj.getSuggestedWhlslPrice();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setSuggestedWhlslPrice((BigDecimal)value);
            }
        }
        ,
        WhlslUnits {
            public Object get(ProductImpl obj) {
                return obj.getWhlslUnits();
            }

            public void put(ProductImpl obj, Object value) {
                obj.setWhlslUnits((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ProductImpl object);

        public abstract void put(ProductImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int ID = AttributesEnum.Id.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int SHORTDESC = AttributesEnum.ShortDesc.index();
    public static final int LONGTEXTID = AttributesEnum.LongtextId.index();
    public static final int IMAGEID = AttributesEnum.ImageId.index();
    public static final int SUGGESTEDWHLSLPRICE = AttributesEnum.SuggestedWhlslPrice.index();
    public static final int WHLSLUNITS = AttributesEnum.WhlslUnits.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ProductImpl() {
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the value of Id
     */
    public Integer getId() {
        return (Integer)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(Integer value) {
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
     * Gets the attribute value for ShortDesc, using the alias name ShortDesc.
     * @return the value of ShortDesc
     */
    public String getShortDesc() {
        return (String)getAttributeInternal(SHORTDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for ShortDesc.
     * @param value value to set the ShortDesc
     */
    public void setShortDesc(String value) {
        setAttributeInternal(SHORTDESC, value);
    }

    /**
     * Gets the attribute value for LongtextId, using the alias name LongtextId.
     * @return the value of LongtextId
     */
    public Integer getLongtextId() {
        return (Integer)getAttributeInternal(LONGTEXTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LongtextId.
     * @param value value to set the LongtextId
     */
    public void setLongtextId(Integer value) {
        setAttributeInternal(LONGTEXTID, value);
    }

    /**
     * Gets the attribute value for ImageId, using the alias name ImageId.
     * @return the value of ImageId
     */
    public Integer getImageId() {
        return (Integer)getAttributeInternal(IMAGEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImageId.
     * @param value value to set the ImageId
     */
    public void setImageId(Integer value) {
        setAttributeInternal(IMAGEID, value);
    }

    /**
     * Gets the attribute value for SuggestedWhlslPrice, using the alias name SuggestedWhlslPrice.
     * @return the value of SuggestedWhlslPrice
     */
    public BigDecimal getSuggestedWhlslPrice() {
        return (BigDecimal)getAttributeInternal(SUGGESTEDWHLSLPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for SuggestedWhlslPrice.
     * @param value value to set the SuggestedWhlslPrice
     */
    public void setSuggestedWhlslPrice(BigDecimal value) {
        setAttributeInternal(SUGGESTEDWHLSLPRICE, value);
    }

    /**
     * Gets the attribute value for WhlslUnits, using the alias name WhlslUnits.
     * @return the value of WhlslUnits
     */
    public String getWhlslUnits() {
        return (String)getAttributeInternal(WHLSLUNITS);
    }

    /**
     * Sets <code>value</code> as the attribute value for WhlslUnits.
     * @param value value to set the WhlslUnits
     */
    public void setWhlslUnits(String value) {
        setAttributeInternal(WHLSLUNITS, value);
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
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer id) {
        return new Key(new Object[]{id});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.summit.model.wrapplsql.Product");
    }
}
