package al.utile.utile;


import al.utile.utile.converter.JobConverter;
import al.utile.utile.dto.JobDTO;
import al.utile.utile.entity.JobEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobConverterTest {

    private final JobConverter jobConverter = new JobConverter();

//    @Test
    public void testEntityToDto() {
        JobEntity job = new JobEntity();
        job.setId(1L);
        job.setTitle("Test Title");
        job.setDescription("Test Description");
        job.setAddress("Test Address");
        job.setZone("Test Zone");
        job.setTypeOfProfessional("Test Professional");
        job.setPostedBy("Test Poster");
        job.setContact("Test Contact");
        job.setCreatedDate(LocalDateTime.now());
        job.setLastModifiedDate(LocalDateTime.now());
        job.setCreatedBy("Test Creator");
        job.setLastModifiedBy("Test Modifier");

        JobDTO jobDTO = jobConverter.entityToDto(job);

        Assertions.assertEquals(job.getId(), jobDTO.id());
        Assertions.assertEquals(job.getTitle(), jobDTO.title());
        Assertions.assertEquals(job.getDescription(), jobDTO.description());
        Assertions.assertEquals(job.getAddress(), jobDTO.address());
        Assertions.assertEquals(job.getZone(), jobDTO.zone());
        Assertions.assertEquals(job.getTypeOfProfessional(), jobDTO.typeOfProfessional());
        Assertions.assertEquals(job.getPostedBy(), jobDTO.postedBy());
        Assertions.assertEquals(job.getContact(), jobDTO.contact());
        Assertions.assertEquals(job.getCreatedDate(), jobDTO.createdDate());
        Assertions.assertEquals(job.getLastModifiedDate(), jobDTO.lastModifiedDate());
        Assertions.assertEquals(job.getCreatedBy(), jobDTO.createdBy());
        Assertions.assertEquals(job.getLastModifiedBy(), jobDTO.lastModifiedBy());
    }

//    @Test
    public void testDtoToEntity() {
        JobDTO jobDTO = new JobDTO(
                1L,
                "Test Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                LocalDateTime.now(),
                LocalDateTime.now(),
                "Test Creator",
                "Test Modifier"
        );

        JobEntity job = jobConverter.dtoToEntity(jobDTO);

        Assertions.assertEquals(jobDTO.id(), job.getId());
        Assertions.assertEquals(jobDTO.title(), job.getTitle());
        Assertions.assertEquals(jobDTO.description(), job.getDescription());
        Assertions.assertEquals(jobDTO.address(), job.getAddress());
        Assertions.assertEquals(jobDTO.zone(), job.getZone());
        Assertions.assertEquals(jobDTO.typeOfProfessional(), job.getTypeOfProfessional());
        Assertions.assertEquals(jobDTO.postedBy(), job.getPostedBy());
        Assertions.assertEquals(jobDTO.contact(), job.getContact());
        Assertions.assertEquals(jobDTO.createdDate(), job.getCreatedDate());
        Assertions.assertEquals(jobDTO.lastModifiedDate(), job.getLastModifiedDate());
        Assertions.assertEquals(jobDTO.createdBy(), job.getCreatedBy());
        Assertions.assertEquals(jobDTO.lastModifiedBy(), job.getLastModifiedBy());
    }
}

