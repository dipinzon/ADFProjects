package oracle.summit.failover;



import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

public class EmployeesManagement {
    private List s_emps = null;

    public EmployeesManagement() {
        super();
    }

    public Employee[] getEmployees() {
        //This Method gets a list of the employees and their emails

        Employee[] emps = null;
        if (s_emps == null) {
            emps = this.buildEmpsList();            
        }

        return emps;
    }

    private Employee[] buildEmpsList() {
        Employee[] emps = null;
        s_emps = new ArrayList();
        s_emps.add(new Employee("Bill", "bill@oracle.com", 4000, getADate(2011, 3, 24, 9, 0)));
        s_emps.add(new Employee("Joe", "joe@oracle.com", 5000, getADate(2007, 2, 24, 9, 0)));
        s_emps.add(new Employee("Juan", "juan@oracle.com", 5500, getADate(2003, 2, 19, 9, 0)));
        s_emps.add(new Employee("Shay", "shay@oracle.com", 4000, getADate(2012, 2, 13, 9, 0)));
        s_emps.add(new Employee("Srini", "srini@oracle.com", 6000, getADate(2002, 2, 21, 9, 0)));
        emps = (Employee[]) s_emps.toArray(new Employee[s_emps.size()]);
        return emps;
    }
    
    public void createEmployee(String name, String email, int salary, Date hiredate) {
        s_emps.add(new Employee(name, email, salary, hiredate));
    }


    private Date getADate(int y, int m, int d, int h, int mi) {
        Calendar c1 = Calendar.getInstance();
        c1.set(y, m, d, h, mi);
        Date retDate = c1.getTime();
        return retDate;
    }


    public Serializable createSnapshot() {
        return null;
    }

    public void restoreSnapshot(Serializable p0) {
    }

    public void removeSnapshot(Serializable p0) {
    }

    public boolean isTransactionDirty() {
        return false;
    }

    public void rollbackTransaction() {
    }

    public void commitTransaction() {
    }

    public boolean setAttributeValue(AttributeContext p0, Object p1) {
        return false;
    }

    public Object createRowData(RowContext p0) {
        return null;
    }

    public Object registerDataProvider(RowContext p0) {
        return null;
    }

    public boolean removeRowData(RowContext p0) {
        return false;
    }

    public void validate() {
    }
}

