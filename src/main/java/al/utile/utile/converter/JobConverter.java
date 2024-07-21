package al.utile.utile.converter;

import al.utile.utile.dto.JobDTO;
import al.utile.utile.entity.JobEntity;
import org.springframework.stereotype.Component;

@Component
public class JobConverter {

    public JobDTO entityToDto(JobEntity job) {
        return new JobDTO(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getAddress(),
                job.getZone(),
                job.getTypeOfProfessional(),
                job.getPostedBy(),
                job.getContact(),
                job.getCreatedDate(),
                job.getLastModifiedDate(),
                job.getCreatedBy(),
                job.getLastModifiedBy()
        );
    }

    public JobEntity dtoToEntity(JobDTO jobDTO) {
        JobEntity job = new JobEntity();
        job.setId(jobDTO.id());
        job.setTitle(jobDTO.title());
        job.setDescription(jobDTO.description());
        job.setAddress(jobDTO.address());
        job.setZone(jobDTO.zone());
        job.setTypeOfProfessional(jobDTO.typeOfProfessional());
        job.setPostedBy(jobDTO.postedBy());
        job.setContact(jobDTO.contact());
        job.setCreatedDate(jobDTO.createdDate());
        job.setLastModifiedDate(jobDTO.lastModifiedDate());
        job.setCreatedBy(jobDTO.createdBy());
        job.setLastModifiedBy(jobDTO.lastModifiedBy());
        return job;
    }
}

