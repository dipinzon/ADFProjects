package oracle.summit.model.amservice.common;

public interface OrdersViewSDO extends java.io.Serializable {

   public java.lang.Integer getId();

   public void setId(java.lang.Integer value);

   public java.lang.Integer getCustomerId();

   public void setCustomerId(java.lang.Integer value);

   public java.sql.Date getDateOrdered();

   public void setDateOrdered(java.sql.Date value);

   public java.sql.Date getDateShipped();

   public void setDateShipped(java.sql.Date value);

   public java.lang.Integer getSalesRepId();

   public void setSalesRepId(java.lang.Integer value);

   public java.math.BigDecimal getTotal();

   public void setTotal(java.math.BigDecimal value);

   public java.lang.Integer getPaymentTypeId();

   public void setPaymentTypeId(java.lang.Integer value);

   public java.lang.Integer getPaymentOptionId();

   public void setPaymentOptionId(java.lang.Integer value);

   public java.lang.String getOrderFilled();

   public void setOrderFilled(java.lang.String value);


}

