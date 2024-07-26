package al.utile.utile.controller;

import al.utile.utile.dto.JobDto;
import al.utile.utile.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public JobDto getJobById(@PathVariable Long id) {
        return jobService.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    @PostMapping
    public JobDto createJob(@RequestBody JobDto JobDto) {
        return jobService.save(JobDto);
    }

    @PutMapping("/{id}")
    public JobDto updateJob(@PathVariable Long id, @RequestBody JobDto JobDto) {
        return jobService.update(id, JobDto);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.delete(id);
    }
}

