package ma.emsi.customerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer,Long> { }