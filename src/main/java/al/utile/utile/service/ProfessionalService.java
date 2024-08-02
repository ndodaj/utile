package al.utile.utile.service;

import al.utile.utile_common.utile.dto.ProfessionalDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ProfessionalService {

    private final RestTemplate restTemplate;

    public ProfessionalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "professionalService", fallbackMethod = "fallbackGetProfessional")
    public ProfessionalDto getProfessional(Long id) {
        String url = "http://{professional-service}/professionals/" + id;// @TODO apply feign call here
        return restTemplate.getForObject(url, ProfessionalDto.class);
    }

    public ProfessionalDto fallbackGetProfessional(Long id, Throwable throwable) {
        // Handle the fallback logic here, return a default object or throw an exception
        return new ProfessionalDto(id, "Default Description", 0, Collections.emptyList(), 0.0);
    }
}

