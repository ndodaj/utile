package al.utile.utile.service;

import al.utile.utile.converter.JobConverter;
import al.utile.utile.dto.JobDTO;
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
    public List<JobDTO> findAll() {
        return jobRepository.findAll()
                .stream()
                .map(jobConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JobDTO> findById(Long id) {
        return jobRepository.findById(id).map(jobConverter::entityToDto);
    }

    @Override
    public JobDTO save(JobDTO jobDTO) {
        return jobConverter.entityToDto(jobRepository.save(jobConverter.dtoToEntity(jobDTO)));
    }

    @Override
    public JobDTO update(Long id, JobDTO jobDTO) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found");
        }
        jobDTO = new JobDTO(
                id,
                jobDTO.title(),
                jobDTO.description(),
                jobDTO.address(),
                jobDTO.zone(),
                jobDTO.typeOfProfessional(),
                jobDTO.postedBy(),
                jobDTO.contact(),
                jobDTO.createdDate(),
                jobDTO.lastModifiedDate(),
                jobDTO.createdBy(),
                jobDTO.lastModifiedBy()
        );
        return jobConverter.entityToDto(jobRepository.save(jobConverter.dtoToEntity(jobDTO)));
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
