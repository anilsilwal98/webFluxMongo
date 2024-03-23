package com.fluxmongo.testing.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
public class Address {
    private String city;
    private String state;
    private String address1;
    private String country;
}
