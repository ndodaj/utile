package al.utile.utile.converter;

import al.utile.utile.dto.JobDto;
import al.utile.utile.entity.JobEntity;
import org.springframework.stereotype.Component;

@Component
public class JobConverter {

    public JobDto entityToDto(JobEntity entity) {
        return new JobDto(
                entity.getId(),
                entity.getTitle(),
                entity.getPostcode(),
                entity.getEstimatedStartDate(),
                entity.getEstimatedDuration(),
                entity.getDescription(),
                entity.getAddress(),
                entity.getZone(),
                entity.getTypeOfProfessional(),
                entity.getPhoneNumber()
        );
    }

    public JobEntity dtoToEntity(JobDto dto) {
        return new JobEntity.JobBuilder()
                .id(dto.id())
                .title(dto.title())
                .postcode(dto.postcode())
                .estimatedStartDate(dto.estimatedStartDate())
                .estimatedDuration(dto.estimatedDuration())
                .description(dto.description())
                .address(dto.address())
                .zone(dto.zone())
                .typeOfProfessional(dto.typeOfProfessional())
                .phoneNumber(dto.phoneNumber())
                .build();
    }

    public JobEntity updateJobEntity(JobDto dto, JobEntity entity) {
        entity.setTitle(dto.title());
        entity.setPostcode(dto.postcode());
        entity.setEstimatedStartDate(dto.estimatedStartDate());
        entity.setEstimatedDuration(dto.estimatedDuration());
        entity.setDescription(dto.description());
        entity.setAddress(dto.address());
        entity.setZone(dto.zone());
        entity.setTypeOfProfessional(dto.typeOfProfessional());
        entity.setPhoneNumber(dto.phoneNumber());
        return entity;
    }
}

