package ma.emsi.billingservice.entities;

import ma.emsi.billingservice.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "fullBill",types = Bill.class)
public interface BillFullProjection extends Projection {
    public Long getId();
    public Date getBillingDate();
    public long getCustomerID();
    public Customer getCustomer();
    public Collection<ProductItem> getProductItems();

    //    http://localhost:8083/bills?page=0&size=1&projection=fullBill

}