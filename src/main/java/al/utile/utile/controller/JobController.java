package al.utile.utile.controller;

import al.utile.utile.dto.JobDto;
import al.utile.utile.service.JobService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public JobDto getJobById(@PathVariable Long id) {
        return jobService.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    @PostMapping
    public JobDto createJob(@RequestBody JobDto jobDto) {
        return jobService.save(jobDto);
    }

    @PutMapping("/{id}")
    public JobDto updateJob(@PathVariable Long id, @RequestBody JobDto jobDto) {
        return jobService.update(id, jobDto);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.delete(id);
    }
}

