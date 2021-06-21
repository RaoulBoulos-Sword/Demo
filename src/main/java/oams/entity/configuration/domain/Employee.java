package oams.entity.configuration.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employees",uniqueConstraints = {@UniqueConstraint(columnNames = {"email","mobileNumber"})})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Employee_ID;

    @NotBlank
    @NonNull
    @Size(min = 3, max = 20)
    private String firstName;

    @NotBlank
    @NonNull
    @Size(min = 3, max = 20)
    private String lastName;

    @NotBlank
    @NonNull
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @NonNull
    @Size(max = 8)
    private Long mobileNumber;

    @NotBlank
    @NonNull
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Details",
                joinColumns = @JoinColumn(name = "OAMS_Employee_ID"),
                inverseJoinColumns = @JoinColumn(name = "OAMS_Role_ID"))
    @NonNull
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Details",
                joinColumns = @JoinColumn(name = "OAMS_Employee_ID"),
                inverseJoinColumns = @JoinColumn(name = "OAMS_Team_ID"))
    @NonNull
    private Set<Team> teams = new HashSet<>();
}
