package com.example.productservice_wfs.security.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class JwtDTO {
    String emailId;
    Long userId;
    Date createdAt;
    Date expiryAt;
    List<RoleDTO> roles = new ArrayList<>();

}
