package ma.emsi.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "Bill",types = Bill.class)
interface BillProjection extends Projection{
    public Long getId();
    public Date getBillingDate();
    public long getCustomerID();

    //    http://localhost:8083/bills?page=0&size=1&projection=fullBill

}
