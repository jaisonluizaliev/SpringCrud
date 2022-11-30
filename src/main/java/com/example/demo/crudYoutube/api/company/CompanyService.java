package com.example.demo.crudYoutube.api.company;

import com.example.demo.crudYoutube.api.util.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CompanyService {
    private final CompanyDao companyDao;

    @Autowired
    public CompanyService(@Qualifier("AnotherFakeDao") CompanyDao companyDao) {
        this.companyDao = companyDao;

    }

    public int addCompany(Company company) {
        return companyDao.insertCompany(company);
    }

    public List<Company> getAllCompanies() {
        return companyDao.selectAllCompanies();
    }

    public Optional<Company> getCompanyById(UUID companyId) {
        return companyDao.selectCompanyById(companyId);
    }


    public int updateCompany(UUID companyId, Company newCompany) {
        return companyDao.updateCompany(companyId, newCompany);
    }

    public int deleteCompany(UUID companyId) {
        return companyDao.deleteCompany(companyId);
    }

}
