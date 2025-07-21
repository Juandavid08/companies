package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Company")
@Data

public class Company {
    
    @Id
    private Integer idCompany;

    @Column(length = 50)
    private String codigoCompany;

    @Column(length = 100)
    private String nameCompany;

    @Column(columnDefinition = "TEXT")
    private String descriptionCompany;
    
}
