package al.utile.utile.controller;

import al.utile.utile.dto.JobDTO;
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
    public List<JobDTO> getAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public JobDTO getJobById(@PathVariable Long id) {
        return jobService.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }

    @PostMapping
    public JobDTO createJob(@RequestBody JobDTO jobDTO) {
        return jobService.save(jobDTO);
    }

    @PutMapping("/{id}")
    public JobDTO updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO) {
        return jobService.update(id, jobDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.delete(id);
    }
}

