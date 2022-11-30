package com.example.demo.crudYoutube.api.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/company")
@RestController
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }


    @GetMapping
    public List<Company> getAllPeople() {
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "{id}")
    public Company getCompanyById(@PathVariable("id") UUID companyId) {
        return companyService.getCompanyById(companyId).orElse(null);

    }

    @PutMapping(path = "{id}")
    public void updateCompany(
            @PathVariable("id") UUID companyId,
            @RequestBody Company companyToUpdate
    )
    {
        companyService.updateCompany(companyId, companyToUpdate);

    }

    @DeleteMapping(path = "{id}")
    public void deleteCompany(@PathVariable("id") UUID companyId) {
        companyService.deleteCompany(companyId);
    }


}
