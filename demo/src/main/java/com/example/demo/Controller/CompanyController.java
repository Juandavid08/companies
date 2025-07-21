package com.example.demo.Controller;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService service;
    
    public CompanyController(CompanyService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Integer id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company create(@RequestBody Company company){
        return service.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Integer id,  @RequestBody Company updated){
        return service.findById(id).map(existing -> {
            existing.setCodigoCompany(updated.getCodigoCompany());
            existing.setNameCompany(updated.getNameCompany());
            existing.setDescriptionCompany(updated.getDescriptionCompany());
            return ResponseEntity.ok(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        return service.findById(id).map(company -> {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }


    
}
