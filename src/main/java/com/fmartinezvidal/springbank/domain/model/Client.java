package com.fmartinezvidal.springbank.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private String password;
}
