package al.utile.utile.service;



import al.utile.utile_common.utile.dto.JobDto;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<JobDto> findAll();

    Optional<JobDto> findById(Long id);

    JobDto save(JobDto jobDto);

    JobDto update(Long id, JobDto jobDto);

    void delete(Long id);
}

