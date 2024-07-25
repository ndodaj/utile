package al.utile.utile;

import al.utile.utile.controller.JobController;
import al.utile.utile.dto.JobDTO;
import al.utile.utile.service.JobService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(JobController.class)
public class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobService jobService;

    @Test
    public void testGetAllJobs() throws Exception {
        JobDTO jobDTO = new JobDTO(
                1L,
                "Test Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                null,
                null,
                null,
                null
        );

        when(jobService.findAll()).thenReturn(List.of(jobDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/jobs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Test Title"));
    }

    @Test
    public void testGetJobById() throws Exception {
        JobDTO jobDTO = new JobDTO(
                1L,
                "Test Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                null,
                null,
                null,
                null
        );

        when(jobService.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(jobDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/jobs/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Title"));
    }

    @Test
    public void testCreateJob() throws Exception {
        JobDTO jobDTO = new JobDTO(
                null,
                "Test Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                null,
                null,
                null,
                null
        );

        JobDTO createdJobDTO = new JobDTO(
                1L,
                "Test Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                null,
                null,
                null,
                null
        );

        when(jobService.save(ArgumentMatchers.any(JobDTO.class))).thenReturn(createdJobDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/jobs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Test Title\", \"description\": \"Test Description\", \"address\": \"Test Address\", \"zone\": \"Test Zone\", \"typeOfProfessional\": \"Test Professional\", \"postedBy\": \"Test Poster\", \"contact\": \"Test Contact\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Title"));
    }

    @Test
    public void testUpdateJob() throws Exception {
        JobDTO jobDTO = new JobDTO(
                null,
                "Updated Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                null,
                null,
                null,
                null
        );

        JobDTO updatedJobDTO = new JobDTO(
                1L,
                "Updated Title",
                "Test Description",
                "Test Address",
                "Test Zone",
                "Test Professional",
                "Test Poster",
                "Test Contact",
                null,
                null,
                null,
                null
        );

        when(jobService.update(ArgumentMatchers.anyLong(), ArgumentMatchers.any(JobDTO.class))).thenReturn(updatedJobDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/jobs/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Updated Title\", \"description\": \"Test Description\", \"address\": \"Test Address\", \"zone\": \"Test Zone\", \"typeOfProfessional\": \"Test Professional\", \"postedBy\": \"Test Poster\", \"contact\": \"Test Contact\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteJob() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/jobs/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(jobService, Mockito.times(1)).delete(1L);
    }
}

