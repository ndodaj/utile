package al.utile.utile.dto;


import java.time.LocalDateTime;

public record JobDTO(
        Long id,
        String title,
        String description,
        String address,
        String zone,
        String typeOfProfessional,
        String postedBy,
        String contact,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy
) {}

