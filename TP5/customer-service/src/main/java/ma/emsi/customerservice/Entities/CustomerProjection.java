package ma.emsi.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types = Customer.class)
public interface CustomerProjection extends Projection{
    public Long getId();
    public String getName();
    public String getEmail();


//    http://localhost:8081/customers?page=0&size=1&projection=fullCustomer

}
