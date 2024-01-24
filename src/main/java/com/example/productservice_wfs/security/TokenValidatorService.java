package com.example.productservice_wfs.security;

import com.example.productservice_wfs.security.dto.JwtDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

@Service
public class TokenValidatorService {
    RestTemplateBuilder restTemplate;

    public TokenValidatorService(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<JwtDTO> validateToken(String token) {

        RestTemplate template = restTemplate.build();
        JwtDTO responseDTO = template.getForEntity("localhost:8080/auth/validate",
                JwtDTO.class).getBody();

        if (Objects.isNull(responseDTO)) {
            return Optional.empty();
        }

        return Optional.of(responseDTO);

    }
}
