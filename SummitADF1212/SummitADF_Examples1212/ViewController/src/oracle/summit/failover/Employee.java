package oracle.summit.failover;


import java.util.Date;

public class Employee{
    public Employee() {
        super();
    }
    
    private String name;
    private String email;
    private int salary;
    private Date hireDate;

    public Employee(String name, String email) {
    super();
    this.name = name;
    this.email = email; 
    }
    
    public Employee(String name, String email, int salary, Date hireDate) {
        super();
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }
}



