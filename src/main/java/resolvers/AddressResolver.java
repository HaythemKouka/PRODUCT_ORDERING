package resolvers; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import entities.Address;
import repo.AddressRepository;

@Controller
public class AddressResolver {

    @Autowired
    private AddressRepository addressRepository;

    @QueryMapping
    public Address address(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Address createAddress(@Argument String street,@Argument  String city,@Argument  String country,@Argument  Long userId) {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setCountry(country);
        // Set the user to the address here (you may need to find the user by their ID)
        return addressRepository.save(address);
    }
}
