package al.utile.utile;


import al.utile.utile.converter.JobConverter;
import al.utile.utile.dto.JobDTO;
import al.utile.utile.entity.JobEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobConverterTest {

    private final JobConverter jobConverter = new JobConverter();

    @Test
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

        assertEquals(job.getId(), jobDTO.id());
        assertEquals(job.getTitle(), jobDTO.title());
        assertEquals(job.getDescription(), jobDTO.description());
        assertEquals(job.getAddress(), jobDTO.address());
        assertEquals(job.getZone(), jobDTO.zone());
        assertEquals(job.getTypeOfProfessional(), jobDTO.typeOfProfessional());
        assertEquals(job.getPostedBy(), jobDTO.postedBy());
        assertEquals(job.getContact(), jobDTO.contact());
        assertEquals(job.getCreatedDate(), jobDTO.createdDate());
        assertEquals(job.getLastModifiedDate(), jobDTO.lastModifiedDate());
        assertEquals(job.getCreatedBy(), jobDTO.createdBy());
        assertEquals(job.getLastModifiedBy(), jobDTO.lastModifiedBy());
    }

    @Test
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

        assertEquals(jobDTO.id(), job.getId());
        assertEquals(jobDTO.title(), job.getTitle());
        assertEquals(jobDTO.description(), job.getDescription());
        assertEquals(jobDTO.address(), job.getAddress());
        assertEquals(jobDTO.zone(), job.getZone());
        assertEquals(jobDTO.typeOfProfessional(), job.getTypeOfProfessional());
        assertEquals(jobDTO.postedBy(), job.getPostedBy());
        assertEquals(jobDTO.contact(), job.getContact());
        assertEquals(jobDTO.createdDate(), job.getCreatedDate());
        assertEquals(jobDTO.lastModifiedDate(), job.getLastModifiedDate());
        assertEquals(jobDTO.createdBy(), job.getCreatedBy());
        assertEquals(jobDTO.lastModifiedBy(), job.getLastModifiedBy());
    }
}

