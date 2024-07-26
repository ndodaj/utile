package al.utile.utile.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "job")
public class JobEntity extends AuditEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank
    @Column(name = "postcode", nullable = false)
    private String postcode;

    @NotNull
    @Column(name = "estimated_start_date")
    private LocalDate estimatedStartDate;

    @Column(name = "estimated_duration")
    private Integer estimatedDuration;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "zone")
    private String zone;

    @Column(name = "type_of_professional")
    private String typeOfProfessional;

    @Column(name = "phone_number")
    private String phoneNumber;

}

