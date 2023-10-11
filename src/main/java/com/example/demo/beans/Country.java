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
public class Country {

    @JsonIgnore
    private Integer id;

    private String country;
    private String country_code;

    @JsonIgnore
    private Set<Address> addresses;

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", country_code='" + country_code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(country, country1.country) && Objects.equals(country_code, country1.country_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, country_code);
    }
}
