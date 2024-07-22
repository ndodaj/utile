package al.utile.utile;

import al.utile.utile.converter.JobConverter;
import al.utile.utile.dto.JobDTO;
import al.utile.utile.entity.JobEntity;
import al.utile.utile.repository.JobRepository;
import al.utile.utile.service.JobService;
import al.utile.utile.service.JobServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JobServiceTest {

    private JobRepository jobRepository;
    private JobConverter jobConverter;
    private JobService jobService;

    @BeforeEach
    public void setUp() {
        jobRepository = Mockito.mock(JobRepository.class);
        jobConverter = new JobConverter();
        jobService = new JobServiceImpl(jobRepository, jobConverter);
    }

    @Test
    public void testFindAll() {
        JobEntity job = new JobEntity();
        job.setId(1L);
        job.setTitle("Test Title");

        when(jobRepository.findAll()).thenReturn(List.of(job));

        List<JobDTO> jobDTOs = jobService.findAll();

        assertEquals(1, jobDTOs.size());
        assertEquals("Test Title", jobDTOs.get(0).title());
    }

    @Test
    public void testFindById() {
        JobEntity job = new JobEntity();
        job.setId(1L);
        job.setTitle("Test Title");

        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));

        Optional<JobDTO> jobDTO = jobService.findById(1L);

        assertTrue(jobDTO.isPresent());
        assertEquals("Test Title", jobDTO.get().title());
    }

    @Test
    public void testSave() {
        JobEntity job = new JobEntity();
        job.setId(1L);
        job.setTitle("Test Title");

        when(jobRepository.save(any(JobEntity.class))).thenReturn(job);

        JobDTO jobDTO = new JobDTO(
                null,
                "Test Title",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        JobDTO savedJob = jobService.save(jobDTO);

        assertEquals("Test Title", savedJob.title());
    }

    @Test
    public void testUpdate() {
        JobEntity job = new JobEntity();
        job.setId(1L);
        job.setTitle("Test Title");

        when(jobRepository.existsById(1L)).thenReturn(true);
        when(jobRepository.save(any(JobEntity.class))).thenReturn(job);

        JobDTO jobDTO = new JobDTO(
                null,
                "Updated Title",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        JobDTO updatedJob = jobService.update(1L, jobDTO);

        assertEquals("Updated Title", updatedJob.title());
    }

    @Test
    public void testDelete() {
        jobService.delete(1L);
        verify(jobRepository, times(1)).deleteById(1L);
    }
}
