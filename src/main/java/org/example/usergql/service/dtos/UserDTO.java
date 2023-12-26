package org.example.usergql.service.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor @ToString
public class UserDTO {
    private String name;
    private String email;
    private String dateNaissance;
}
