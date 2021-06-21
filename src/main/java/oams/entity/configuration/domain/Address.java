package oams.entity.configuration.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Address_ID;

    @NotBlank
    @NonNull
    private Integer floorLevel;

    @NotBlank
    @NonNull
    private char block;

    @NotBlank
    @NonNull
    private char office;

    @NotBlank
    @NonNull
    private Integer desk;

}
