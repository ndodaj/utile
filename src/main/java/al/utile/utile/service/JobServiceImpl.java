package al.utile.utile.service;

import al.utile.utile.converter.JobConverter;
import al.utile.utile.entity.JobEntity;
import al.utile.utile.repository.JobRepository;
import al.utile.utile_common.utile.dto.JobDto;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final JobConverter jobConverter;

    public JobServiceImpl(JobRepository jobRepository, JobConverter jobConverter) {
        this.jobRepository = jobRepository;
        this.jobConverter = jobConverter;
    }

    @Override
    public List<JobDto> findAll() {
        return jobRepository.findAll()
                .stream()
                .map(jobConverter::entityToDto)
                .toList();
    }

    @Override
    public Optional<JobDto> findById(Long id) {
        return jobRepository.findById(id).map(jobConverter::entityToDto);
    }

    @Override
    public JobDto save(JobDto jobDto) {
        return jobConverter.entityToDto(jobRepository.save(jobConverter.dtoToEntity(jobDto)));
    }

    @Override
    public JobDto update(Long id, JobDto jobDto) {
        if (!jobRepository.existsById(id)) {
            throw new NotFoundException("Job not found");
        }

        JobEntity jobEntity = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobEntity updatedJob = jobConverter.updateJobEntity(jobDto, jobEntity);
        jobRepository.save(updatedJob);
        return jobConverter.entityToDto(updatedJob);
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
