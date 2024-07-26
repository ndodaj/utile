package al.utile.utile.service;

import al.utile.utile.converter.JobConverter;
import al.utile.utile.dto.JobDto;
import al.utile.utile.entity.JobEntity;
import al.utile.utile.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobConverter jobConverter;

    public JobServiceImpl(JobRepository jobRepository, JobConverter jobConverter) {
    }

    @Override
    public List<JobDto> findAll() {
        return jobRepository.findAll()
                .stream()
                .map(jobConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JobDto> findById(Long id) {
        return jobRepository.findById(id).map(jobConverter::entityToDto);
    }

    @Override
    public JobDto save(JobDto JobDto) {
        return jobConverter.entityToDto(jobRepository.save(jobConverter.dtoToEntity(JobDto)));
    }

    @Override
    public JobDto update(Long id, JobDto updatedJobDto) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found");
        }

        JobEntity JobEntity = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobEntity updatedJob = jobConverter.updateJobEntity(updatedJobDto, JobEntity);
        jobRepository.save(updatedJob);
        return jobConverter.entityToDto(updatedJob);
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
