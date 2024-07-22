package al.utile.utile.entity;


import al.utile.utile_rest_common.utile.AccountType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends AuditEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    @NotNull
    private Integer userId;

    @NotBlank
    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank
    @Email(message = "Email is not valid") // create a file tha contains all validation messages
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false, name = "password")
    private String password;

    @NotNull
    @Column(name = "birthday")
    private LocalDate birthday;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Mobile phone number is invalid")
    @NotBlank(message = "Mobile phone number is mandatory")
    private String mobilePhone;

    @NotBlank(message = "Address is mandatory")
    @Column(length = 255)
    private String address;

    @NotBlank
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

}


