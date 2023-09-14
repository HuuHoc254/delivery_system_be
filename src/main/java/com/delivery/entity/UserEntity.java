package com.delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @NotBlank
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\\b")
    @Column(name = "phone", unique = true)
    private String phone;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private Date dataOfBirth;

    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_has_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();
}
