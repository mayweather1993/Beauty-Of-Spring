package com.homework.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class AppUser {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;
    @Column(name = "password")
    @NotEmpty
    private String password;
    @Column(name = "firstName")
    @NotEmpty
    private String firstName;
    @NotEmpty
    @Column(name = "lastName")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
}
