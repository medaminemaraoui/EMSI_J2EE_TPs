package ma.emsi.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

//@EnableConfigurationProperties({ConfigParams.class, InventoryParams.class})
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration config){

        config.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Computer Desk Top HP",900));
            productRepository.save(new Product(null,"Printer Epson",80));
            productRepository.save(new Product(null,"Pc Deskptop",19999));
            productRepository.save(new Product(null,"Pc Portable",29999));
            productRepository.save(new Product(null,"Impriment",2599));
            productRepository.save(new Product(null,"MacBook Pro Lap Top",11800));
            productRepository.save(new Product(null,"Tv 4K",20000));
            productRepository.save(new Product(null,"Monitor",8000));
            productRepository.save(new Product(null,"Mobile",9999));
            productRepository.findAll().forEach(System.out::println);
        };

    }
}
