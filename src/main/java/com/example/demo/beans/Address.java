package com.example.demo.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    @JsonIgnore
    private Integer id;
    private String city;
    private String postal_code;
    private String streetname;
    private String streetnumber;

    @JsonIgnore
    private Country country;
    @JsonIgnore
    private Set<Customer> customers;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", streetname='" + streetname + '\'' +
                ", streetnumber='" + streetnumber + '\'' +
                ", customers=" + customers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(city, address.city) && Objects.equals(postal_code, address.postal_code) && Objects.equals(streetname, address.streetname) && Objects.equals(streetnumber, address.streetnumber) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, postal_code, streetname, streetnumber, country);
    }
}
