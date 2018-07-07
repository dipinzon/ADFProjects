package oracle.summit.model.invokingstoredprocedure;

import java.io.Serializable;
import oracle.jbo.domain.Date;

public class DateAndStringBean implements Serializable {
      Date dateVal;
      String stringVal;
      public void setDateVal(Date dateVal) {
        this.dateVal = dateVal;
      }
      public Date getDateVal() {
        return dateVal;
      }
      public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
      }
      public String getStringVal() {
        return stringVal;
      }
    }
