package oracle.summit.model.amservice.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class CustomersViewSDOImpl extends SDODataObject implements CustomersViewSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 11;

   public CustomersViewSDOImpl() {}

   public java.lang.Integer getId() {
      return getInt(START_PROPERTY_INDEX + 0);
   }

   public void setId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getName() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.lang.String getPhone() {
      return getString(START_PROPERTY_INDEX + 2);
   }

   public void setPhone(java.lang.String value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getAddress() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setAddress(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.lang.String getCity() {
      return getString(START_PROPERTY_INDEX + 4);
   }

   public void setCity(java.lang.String value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.lang.String getState() {
      return getString(START_PROPERTY_INDEX + 5);
   }

   public void setState(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.lang.Integer getCountryId() {
      return getInt(START_PROPERTY_INDEX + 6);
   }

   public void setCountryId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.String getZipCode() {
      return getString(START_PROPERTY_INDEX + 7);
   }

   public void setZipCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.lang.Integer getCreditRatingId() {
      return getInt(START_PROPERTY_INDEX + 8);
   }

   public void setCreditRatingId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

   public java.lang.Integer getSalesRepId() {
      return getInt(START_PROPERTY_INDEX + 9);
   }

   public void setSalesRepId(java.lang.Integer value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }

   public java.lang.String getComments() {
      return getString(START_PROPERTY_INDEX + 10);
   }

   public void setComments(java.lang.String value) {
      set(START_PROPERTY_INDEX + 10 , value);
   }

   public java.util.List getOrdersView() {
      return getList(START_PROPERTY_INDEX + 11);
   }

   public void setOrdersView(java.util.List value) {
      set(START_PROPERTY_INDEX + 11 , value);
   }


}

