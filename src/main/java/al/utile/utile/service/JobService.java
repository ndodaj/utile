package al.utile.utile.service;


import al.utile.utile.dto.JobDTO;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<JobDTO> findAll();

    Optional<JobDTO> findById(Long id);

    JobDTO save(JobDTO jobDTO);

    JobDTO update(Long id, JobDTO jobDTO);

    void delete(Long id);
}

