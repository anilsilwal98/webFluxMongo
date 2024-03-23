package com.fluxmongo.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ={"id", "fName", "lName", "dob"})
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String fName;
    private String lName;
    private String dob;
    private Address address;
}
