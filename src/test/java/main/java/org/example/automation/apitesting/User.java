package main.java.org.example.automation.apitesting;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String city;
        private String state;


}

