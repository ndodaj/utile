package al.utile.utile.converter;

import al.utile.utile.dto.JobDto;
import al.utile.utile.entity.JobEntity;
import org.springframework.stereotype.Component;

@Component
public class JobConverter {

    public JobDto entityToDto(JobEntity job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getAddress(),
                job.getZone(),
                job.getTypeOfProfessional(),
                job.getCreatedBy(),
                job.getPhoneNumber(),
                job.getCreatedDate(),
                job.getLastModifiedDate(),
                job.getCreatedBy(),
                job.getLastModifiedBy()
        );
    }

    public JobEntity dtoToEntity(JobDto JobDto) {
        JobEntity job = new JobEntity();
        job.setId(JobDto.id());
        job.setTitle(JobDto.title());
        job.setDescription(JobDto.description());
        job.setAddress(JobDto.address());
        job.setZone(JobDto.zone());
        job.setTypeOfProfessional(JobDto.typeOfProfessional());
        job.setPostedBy(JobDto.postedBy());
        job.setContact(JobDto.contact());
        job.setCreatedDate(JobDto.createdDate());
        job.setLastModifiedDate(JobDto.lastModifiedDate());
        job.setCreatedBy(JobDto.createdBy());
        job.setLastModifiedBy(JobDto.lastModifiedBy());
        return job;
    }
}

