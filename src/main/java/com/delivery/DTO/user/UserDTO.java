package com.delivery.DTO.user;

import com.delivery.entity.RoleEntity;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String userName;
    private String fullName;
    private String email;
    private String phone;
    private Date dataOfBirth;
    private String avatar;
    private Set<RoleEntity> roles;
}
