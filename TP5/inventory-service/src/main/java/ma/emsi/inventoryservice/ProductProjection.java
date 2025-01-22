package ma.emsi.inventoryservice;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct",types = Product.class)
interface ProductProjection extends Projection{
    public Long getId();
    public String getName();
    public Double getPrice();

    //    http://localhost:8082/products?page=0&size=1&projection=fullProduct

}
