package com.example.productservice_wfs.models;

import java.util.Date;

public class BaseModel {
    private Long id;
    private String createBy;
    private Date createdAt;
    private Boolean isDeleted; // This can be an Enum as well.
}
