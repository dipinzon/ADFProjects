package oracle.summit.model.controlpostorder;

import oracle.jbo.domain.Number;
import java.io.Serializable;

public class Result implements Serializable {
    Number deptId;
    Number empId;

    public Result() {
    }

    public void setDeptId(Number deptId) {
        this.deptId = deptId;
    }

    public Number getInventoryId() {
        return deptId;
    }

    public void setEmpId(Number empId) {
        this.empId = empId;
    }

    public Number getProductId() {
        return empId;
    }
}