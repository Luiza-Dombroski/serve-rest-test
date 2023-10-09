package com.serverest.jsonObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserObject {
    private String nome;
    private String email;
    private String password;
    private String administrador;
}
