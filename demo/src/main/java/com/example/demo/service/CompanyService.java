package com.example.demo.service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository){
        this.repository = repository;
    }

    public List<Company> findAll(){
        return repository.findAll();
    }

    public Optional<Company> findById(Integer id){
        return repository.findById(id);
    }

    public Company save(Company company){
        return repository.save(company);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }


}
