package com.example.demo.crudYoutube.api.util;

import com.example.demo.crudYoutube.api.company.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDao {


    int insertCompany(UUID companyId, Company company);

    default int insertCompany(Company company) {
        UUID companyId = UUID.randomUUID();

        return insertCompany(companyId, company);
    }


    List<Company> selectAllCompanies();

    Optional<Company> selectCompanyById(UUID companyId);




    int updateCompany(UUID companyId, Company company);

    int deleteCompany(UUID companyId);




}
