package oracle.summit.model.multieoupdate;

import oracle.jbo.AttributeList;
import oracle.jbo.JboException;
import oracle.jbo.RowCreateException;
import oracle.jbo.server.AttributeDefImpl;

import oracle.jbo.server.EntityImpl;

import oracle.summit.base.SummitViewRowImpl;
import oracle.summit.model.entities.ProductEOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 27 14:40:41 CDT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProductInventoryVORowImpl extends SummitViewRowImpl {
    public static final int ENTITY_PRODUCT = 0;
    public static final int ENTITY_INVENTORY = 1;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Id {
            public Object get(ProductInventoryVORowImpl obj) {
                return obj.getId();
            }

            public void put(ProductInventoryVORowImpl obj, Object value) {
                obj.setId((Integer) value);
            }
        }
        ,
        Name {
            public Object get(ProductInventoryVORowImpl obj) {
                return obj.getName();
            }

            public void put(ProductInventoryVORowImpl obj, Object value) {
                obj.setName((String) value);
            }
        }
        ,
        ShortDesc {
            public Object get(ProductInventoryVORowImpl obj) {
                return obj.getShortDesc();
            }

            public void put(ProductInventoryVORowImpl obj, Object value) {
                obj.setShortDesc((String) value);
            }
        }
        ,
        AmountInStock {
            public Object get(ProductInventoryVORowImpl obj) {
                return obj.getAmountInStock();
            }

            public void put(ProductInventoryVORowImpl obj, Object value) {
                obj.setAmountInStock((Integer) value);
            }
        }
        ,
        ProductId {
            public Object get(ProductInventoryVORowImpl obj) {
                return obj.getProductId();
            }

            public void put(ProductInventoryVORowImpl obj, Object value) {
                obj.setProductId((Integer) value);
            }
        }
        ,
        WarehouseId {
            public Object get(ProductInventoryVORowImpl obj) {
                return obj.getWarehouseId();
            }

            public void put(ProductInventoryVORowImpl obj, Object value) {
                obj.setWarehouseId((Integer) value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(ProductInventoryVORowImpl object);

        public abstract void put(ProductInventoryVORowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int ID = AttributesEnum.Id.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int SHORTDESC = AttributesEnum.ShortDesc.index();
    public static final int AMOUNTINSTOCK = AttributesEnum.AmountInStock.index();
    public static final int PRODUCTID = AttributesEnum.ProductId.index();
    public static final int WAREHOUSEID = AttributesEnum.WarehouseId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ProductInventoryVORowImpl() {
    }
    
    @Override
    protected void create(AttributeList attributeList) {
        System.out.println("getting the entity list");
        EntityImpl[] entityList =   (EntityImpl[])getEntities();
        
       /*
        *  looking at the entityList all I see is the ProductEOImpl, no InventoryEOImpl
        */
        
        System.out.println("stop here to inspect entityList array");

        EntityImpl x = entityList[0]; // I put this here just to poke around in the EntityList to make sure what I had


        EntityImpl y = entityList[1]; // take a looke at entity [1]

       
        
     /*
      *  here is where I see the problem. 
      *  the getProductEO returns a productEOempl
      *  whereas the getInventoryEO retuns a generic impl or something like that.
      */
        
        System.out.println("In the create(AttributeList) method");
        ProductImpl newProduct = getProduct();
        InventoryImpl newInventory = getInventory();
        System.out.println("after getInventory");
        
        try {
           // Let product "blank" entity instance to do programmatic defaulting
            newProduct.create(attributeList);
           // Let product "blank" entity instance to do programmatic
           // defaulting passing in new SuppliersImpl instance so its attributes
           // are available to the EmployeeImpl's create method.
            newInventory.create(newProduct);
        }
        catch (JboException ex) {
          newInventory.revert();
          newProduct.revert();      
          throw ex;
        }
        catch (Exception otherEx) {
          newInventory.revert();
          newProduct.revert();      
          throw new RowCreateException(true      /* EO Row? */,
                                       "Product" /* EO Name */,
                                       otherEx   /* Details */);
        }
    }
    
    
    
    

    /**
     * Gets Product entity object.
     * @return the Product
     */
    public ProductImpl getProduct() {
        return (ProductImpl) getEntity(ENTITY_PRODUCT);
    }

    /**
     * Gets Inventory entity object.
     * @return the Inventory
     */
    public InventoryImpl getInventory() {
        return (InventoryImpl) getEntity(ENTITY_INVENTORY);
    }

    /**
     * Gets the attribute value for ID using the alias name Id.
     * @return the ID
     */
    public Integer getId() {
        return (Integer) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name Id.
     * @param value value to set the ID
     */
    public void setId(Integer value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for NAME using the alias name Name.
     * @return the NAME
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME using the alias name Name.
     * @param value value to set the NAME
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for SHORT_DESC using the alias name ShortDesc.
     * @return the SHORT_DESC
     */
    public String getShortDesc() {
        return (String) getAttributeInternal(SHORTDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for SHORT_DESC using the alias name ShortDesc.
     * @param value value to set the SHORT_DESC
     */
    public void setShortDesc(String value) {
        setAttributeInternal(SHORTDESC, value);
    }

    /**
     * Gets the attribute value for AMOUNT_IN_STOCK using the alias name AmountInStock.
     * @return the AMOUNT_IN_STOCK
     */
    public Integer getAmountInStock() {
        return (Integer) getAttributeInternal(AMOUNTINSTOCK);
    }

    /**
     * Sets <code>value</code> as attribute value for AMOUNT_IN_STOCK using the alias name AmountInStock.
     * @param value value to set the AMOUNT_IN_STOCK
     */
    public void setAmountInStock(Integer value) {
        setAttributeInternal(AMOUNTINSTOCK, value);
    }

    /**
     * Gets the attribute value for PRODUCT_ID using the alias name ProductId.
     * @return the PRODUCT_ID
     */
    public Integer getProductId() {
        return (Integer) getAttributeInternal(PRODUCTID);
    }

    /**
     * Sets <code>value</code> as attribute value for PRODUCT_ID using the alias name ProductId.
     * @param value value to set the PRODUCT_ID
     */
    public void setProductId(Integer value) {
        setAttributeInternal(PRODUCTID, value);
    }

    /**
     * Gets the attribute value for WAREHOUSE_ID using the alias name WarehouseId.
     * @return the WAREHOUSE_ID
     */
    public Integer getWarehouseId() {
        return (Integer) getAttributeInternal(WAREHOUSEID);
    }

    /**
     * Sets <code>value</code> as attribute value for WAREHOUSE_ID using the alias name WarehouseId.
     * @param value value to set the WAREHOUSE_ID
     */
    public void setWarehouseId(Integer value) {
        setAttributeInternal(WAREHOUSEID, value);
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
}
