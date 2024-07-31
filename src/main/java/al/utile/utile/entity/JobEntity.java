package al.utile.utile.entity;


import al.utile.utile.dto.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "jobs", schema = "utile")
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    public JobEntity() {/* for JPA */ }

    private JobEntity(JobBuilder JobBuilder) {
        this.id = JobBuilder.id;
        this.title = JobBuilder.title;
        this.postcode = JobBuilder.postcode;
        this.estimatedStartDate = JobBuilder.estimatedStartDate;
        this.estimatedDuration = JobBuilder.estimatedDuration;
        this.description = JobBuilder.description;
        this.address = JobBuilder.address;
        this.zone = JobBuilder.zone;
        this.typeOfProfessional = JobBuilder.typeOfProfessional;
        this.phoneNumber = JobBuilder.phoneNumber;
    }


    public static class JobBuilder {
        private Long id;
        private String title;
        private String postcode;
        private LocalDate estimatedStartDate;
        private Integer estimatedDuration;
        private String description;
        private String address;
        private String zone;
        private String typeOfProfessional;
        private String phoneNumber;

        public JobBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public JobBuilder title(String title) {
            this.title = title;
            return this;
        }

        public JobBuilder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public JobBuilder estimatedStartDate(LocalDate estimatedStartDate) {
            this.estimatedStartDate = estimatedStartDate;
            return this;
        }

        public JobBuilder estimatedDuration(Integer estimatedDuration) {
            this.estimatedDuration = estimatedDuration;
            return this;
        }

        public JobBuilder description(String description) {
            this.description = description;
            return this;
        }

        public JobBuilder address(String address) {
            this.address = address;
            return this;
        }

        public JobBuilder zone(String zone) {
            this.zone = zone;
            return this;
        }

        public JobBuilder typeOfProfessional(String typeOfProfessional) {
            this.typeOfProfessional = typeOfProfessional;
            return this;
        }

        public JobBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public JobEntity build() {
            return new JobEntity(this);
        }
    }

}

