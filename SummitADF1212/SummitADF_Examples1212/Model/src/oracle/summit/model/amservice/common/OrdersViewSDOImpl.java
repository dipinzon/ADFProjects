package oracle.summit.model.amservice.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class OrdersViewSDOImpl extends SDODataObject implements OrdersViewSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 8;

   public OrdersViewSDOImpl() {}

   public java.lang.Integer getId() {
      return getInt(START_PROPERTY_INDEX + 0);
   }

   public void setId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.Integer getCustomerId() {
      return getInt(START_PROPERTY_INDEX + 1);
   }

   public void setCustomerId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.sql.Date getDateOrdered() {
      return (java.sql.Date)get(START_PROPERTY_INDEX + 2);
   }

   public void setDateOrdered(java.sql.Date value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.sql.Date getDateShipped() {
      return (java.sql.Date)get(START_PROPERTY_INDEX + 3);
   }

   public void setDateShipped(java.sql.Date value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.lang.Integer getSalesRepId() {
      return getInt(START_PROPERTY_INDEX + 4);
   }

   public void setSalesRepId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.math.BigDecimal getTotal() {
      return getBigDecimal(START_PROPERTY_INDEX + 5);
   }

   public void setTotal(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.lang.Integer getPaymentTypeId() {
      return getInt(START_PROPERTY_INDEX + 6);
   }

   public void setPaymentTypeId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.Integer getPaymentOptionId() {
      return getInt(START_PROPERTY_INDEX + 7);
   }

   public void setPaymentOptionId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.lang.String getOrderFilled() {
      return getString(START_PROPERTY_INDEX + 8);
   }

   public void setOrderFilled(java.lang.String value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }


}

