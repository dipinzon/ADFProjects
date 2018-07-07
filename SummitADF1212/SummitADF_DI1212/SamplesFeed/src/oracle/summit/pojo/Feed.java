package oracle.summit.pojo;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private List <Sample> samples;
    public Feed() {
        super();
        samples = new ArrayList<Sample> ();
        Sample sa = new Sample ("Summit Desktop Integration Editable Table Sample",
                               "/excel/EditCustomers.xlsx",
                               "/images/customers.jpg",
                               "This sample illustrates the most common used ADF Desktop Integration Table features. You can download data; insert, update, delete and commit data; interact with column list of values, and track changes.");
        samples.add(sa);
        sa = new Sample ("Summit Desktop Integration Navigation Form Sample",
                               "/excel/EditWarehouses.xlsx",
                               "/images/warehouses.jpg",
                               "This sample illustrates how to use ADF Desktop Integration Form components and their features. You can download, navigate and update data; use the dependent list of values, and see form validation in action.");
        samples.add(sa);
        sa = new Sample ("Summit Desktop Integration Editable Table with Web Picker",
                               "/excel/EditableCustomerSearch.xlsx",
                               "/images/webpicker.jpg",
                               "This sample demonstrates how to integrate ADF pages as a web picker, and how the web picker can directly modify data from the ADF Desktop Integration workbooks.");
        samples.add(sa);
        sa = new Sample ("Summit Desktop Integration Quick Location Change",
                               "/excel/WarehouseLocations.xlsx",
                               "/images/formTableLOV.jpg",
                               "This sample demonstrates how to use ADF Desktop Integration form list of value component in combination with dependent list that resides on an ADF Desktop Integration table.");
        samples.add(sa);
    }

    public void setSamples(List samples) {
        this.samples = samples;
    }

    public List<Sample> getSamples() {
        return samples;
    }
}
