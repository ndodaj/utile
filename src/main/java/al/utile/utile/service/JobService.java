package al.utile.utile.service;


import al.utile.utile.dto.JobDto;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<JobDto> findAll();

    Optional<JobDto> findById(Long id);

    JobDto save(JobDto JobDto);

    JobDto update(Long id, JobDto JobDto);

    void delete(Long id);
}

