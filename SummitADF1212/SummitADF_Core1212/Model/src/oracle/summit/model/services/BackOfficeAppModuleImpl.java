package oracle.summit.model.services;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.Transaction;
import oracle.jbo.ViewObject;
import oracle.jbo.server.TransactionEvent;
import oracle.jbo.server.ViewLinkImpl;

import oracle.summit.base.SummitApplicationModuleImpl;
import oracle.summit.base.SummitViewObjectImpl;
import oracle.summit.model.views.CustomerVOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 01 15:14:13 CDT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BackOfficeAppModuleImpl extends SummitApplicationModuleImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public BackOfficeAppModuleImpl() {
    }
    
    private Row currentRow = null;

    /**
     * Container's getter for Customers.
     * @return Customers
     */
    public CustomerVOImpl getCustomers() {
        return (CustomerVOImpl) findViewObject("Customers");
    }

    /**
     * Container's getter for OrdersForCustomer.
     * @return OrdersForCustomer
     */
    public SummitViewObjectImpl getOrdersForCustomer() {
        return (SummitViewObjectImpl) findViewObject("OrdersForCustomer");
    }

    /**
     * Container's getter for ItemsForOrder.
     * @return ItemsForOrder
     */
    public SummitViewObjectImpl getItemsForOrder() {
        return (SummitViewObjectImpl) findViewObject("ItemsForOrder");
    }

    /**
     * Container's getter for SalesPeople.
     * @return SalesPeople
     */
    public SummitViewObjectImpl getSalesPeople() {
        return (SummitViewObjectImpl) findViewObject("SalesPeople");
    }

    /**
     * Container's getter for InventoryForOrderItem.
     * @return InventoryForOrderItem
     */
    public SummitViewObjectImpl getInventoryForOrderItem() {
        return (SummitViewObjectImpl) findViewObject("InventoryForOrderItem");
    }

    /**
     * Container's getter for Countries.
     * @return Countries
     */
    public SummitViewObjectImpl getCountries() {
        return (SummitViewObjectImpl) findViewObject("Countries");
    }

    /**
     * Container's getter for Inventory.
     * @return Inventory
     */
    public SummitViewObjectImpl getInventory() {
        return (SummitViewObjectImpl) findViewObject("Inventory");
    }

    /**
     * Container's getter for PaymentOption.
     * @return PaymentOption
     */
    public SummitViewObjectImpl getPaymentOption() {
        return (SummitViewObjectImpl) findViewObject("PaymentOption");
    }

    /**
     * Container's getter for LowStock.
     * @return LowStock
     */
    public SummitViewObjectImpl getLowStock() {
        return (SummitViewObjectImpl) findViewObject("LowStock");
    }

    /**
     * Container's getter for OrdCustomerIdFkLink1.
     * @return OrdCustomerIdFkLink1
     */
    public ViewLinkImpl getOrdCustomerIdFkLink1() {
        return (ViewLinkImpl) findViewLink("OrdCustomerIdFkLink1");
    }

    /**
     * Container's getter for ItemOrdIdFkLink1.
     * @return ItemOrdIdFkLink1
     */
    public ViewLinkImpl getItemOrdIdFkLink1() {
        return (ViewLinkImpl) findViewLink("ItemOrdIdFkLink1");
    }

    /**
     * Container's getter for InventoryForProductItemLink1.
     * @return InventoryForProductItemLink1
     */
    public ViewLinkImpl getInventoryForProductItemLink1() {
        return (ViewLinkImpl) findViewLink("InventoryForProductItemLink1");
    }

    @Override
    /** 
     * This method is required to workaround bug 16569722 where 
     * the DBSequence/composite association between orders and items is causing
     * a JBO error because faces is calling into bindings using the pre-commit
     * row keys after the row keys are updated by the model layer. The beforeCommit
     * method sets the current row before the commit fires so that it can be found
     * after re-executing the OrdersVO query.
     */
    public void afterCommit(TransactionEvent transactionEvent) {
        ViewObject ordersVO = this.findViewObject("OrdersForCustomer");
        ordersVO.executeQuery();
        ordersVO.setCurrentRow(currentRow);
        super.afterCommit(transactionEvent);
    }

    @Override
    public void beforeCommit(TransactionEvent transactionEvent) {
        ViewObject ordersVO = this.findViewObject("OrdersForCustomer");
        currentRow = ordersVO.getCurrentRow();
        super.beforeCommit(transactionEvent);
    }
}

