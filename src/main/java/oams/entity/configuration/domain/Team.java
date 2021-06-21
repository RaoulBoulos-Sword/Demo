package oams.entity.configuration.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Teams")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Team_ID;

    @Enumerated(EnumType.STRING)
    @NotBlank
    @NonNull
    private ETeam name;
}
