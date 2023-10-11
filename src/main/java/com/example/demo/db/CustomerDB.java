package com.example.demo.db;

import com.example.demo.beans.Address;
import com.example.demo.beans.Country;
import com.example.demo.beans.Customer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Component
@Getter
public class CustomerDB {

    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US);

    private Set<Country> countries = new HashSet<>();

    private JsonNode jsonNode;

    @PostConstruct
    public void initDB() {

        InputStream customerInputStream = this.getClass().getResourceAsStream("/customer.json");
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {

            //countries = mapper.readerForListOf(Country.class).readValue(customerInputStream);
            jsonNode = mapper.readTree(customerInputStream);
            System.out.println(jsonNode.get(0));
            System.out.println(jsonNode.get(0).get("country"));

            for (int i = 0; i < jsonNode.size(); i++) {

                Country country = new Country(countries.size() + 1, jsonNode.get(i).get("country").asText(), jsonNode.get(i).get("country_code").asText(), new HashSet<>());
                Country countryInDb = new Country();

                int count = 1;
                for (Country country1:
                     countries) {
                    //if (country1.getCountry().equals(country.getCountry())) countryInDb = country1;
                    for (Address address : country1.getAddresses()) {
                        count++;
                    }
                }


                Address address = new Address(count, jsonNode.get(i).get("city").asText(), jsonNode.get(i).get("postal_code").asText(), jsonNode.get(i).get("streetname").asText(), jsonNode.get(i).get("streetnumber").asText(), country, new HashSet<>());

                Address addressInDb = new Address();


                int count2 = 1;

                try {
                    for(Country country1 : countries) {
                        for (Address address1 :
                                country1.getAddresses()) {
                            for (Customer customer : address1.getCustomers()) {
                                count2++;
                            }
                        }
                    }
                } catch (Exception e) {

                }

                Customer customer = new Customer(count2, jsonNode.get(i).get("firstname").asText(), jsonNode.get(i).get("lastname").asText(), jsonNode.get(i).get("gender").asText(), jsonNode.get(i).get("active").asBoolean(), jsonNode.get(i).get("email").asText(), LocalDate.parse(jsonNode.get(i).get("since").asText(), DTF), address);
                country.getAddresses().add(address);
                address.getCustomers().add(customer);

                boolean cheque = false;

                try {
                    for (Country country1 : countries) {
                        if (country1.getCountry().equals(country.getCountry())) {
                            country1.getAddresses().add(address);
                            cheque = true;
                        }
                    }
                } catch (Exception e) {

                }

                if (!cheque) countries.add(country);
            }

            for (Country country : countries) {
                System.out.println("Country: " + country.getId());
                for (Address address : country.getAddresses()) {
                    System.out.println("Address" + address.getId());
                    for (Customer customer : address.getCustomers()) {
                        System.out.println("Customer: " + customer.getId());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public List<Country> getAllCountries() {
        return countries.stream().toList();
    }


}
