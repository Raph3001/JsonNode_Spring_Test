package com.example.demo.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @JsonIgnore
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private boolean active;
    private String email;
    private LocalDate since;

    @JsonIgnore
    private Address address;

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", active=" + active +
                ", email='" + email + '\'' +
                ", since='" + since + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active && Objects.equals(id, customer.id) && Objects.equals(firstname, customer.firstname) && Objects.equals(lastname, customer.lastname) && Objects.equals(gender, customer.gender) && Objects.equals(email, customer.email) && Objects.equals(since, customer.since) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, gender, active, email, since, address);
    }
}
