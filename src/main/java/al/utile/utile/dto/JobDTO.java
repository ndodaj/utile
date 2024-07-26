package al.utile.utile.dto;


import java.time.LocalDate;

public record JobDto(
        Long id,
        String title,
        String postcode,
        LocalDate estimatedStartDate,
        Integer estimatedDuration,
        String description,
        String address,
        String zone,
        String typeOfProfessional,
        String phoneNumber
) {}

