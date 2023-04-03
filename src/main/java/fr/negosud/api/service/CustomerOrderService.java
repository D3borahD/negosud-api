package fr.negosud.api.service;

import fr.negosud.api.model.CustomerOrder;
import fr.negosud.api.model.SupplierOrder;
import fr.negosud.api.repository.CustomerOrderRepository;
import fr.negosud.api.repository.SupplierOrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public Iterable<CustomerOrder> getCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    public Optional<CustomerOrder> getCustomerOrder(final Integer id) {
        return customerOrderRepository.findById(id);
    }

    public void deleteCustomerOrder(final Integer id) {
            customerOrderRepository.deleteById(id);
    }

    public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
        CustomerOrder savedCustomerOrder = customerOrderRepository.save(customerOrder);
        return savedCustomerOrder;
    }
}
