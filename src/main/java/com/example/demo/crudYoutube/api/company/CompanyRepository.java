package com.example.demo.crudYoutube.api.company;

import com.example.demo.crudYoutube.api.util.CompanyDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("AnotherFakeDao")
public class CompanyRepository implements CompanyDao {
    private static List<Company> DB = new ArrayList<>();


    @Override
    public int insertCompany(UUID companyId, Company company) {
        DB.add(new Company(
                companyId,
                company.getCompanyLeader(),
                company.getCompanyDescription())
        );
        return 1;
    }

    @Override
    public List<Company> selectAllCompanies() {
        return DB;
    }

    @Override
    public Optional<Company> selectCompanyById(UUID companyId) {
        return DB.stream()
                .filter(company -> company.getCompanyId().equals(companyId))
                .findFirst();
    }

    @Override
    public int updateCompany(UUID companyId, Company companyUpdate) {
        return selectCompanyById(companyId).map(company -> {
            int indexOfPersonToUpdate = DB.indexOf(company);

            if(indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Company(
                        companyId,
                        companyUpdate.getCompanyLeader(),
                        companyUpdate.getCompanyDescription())
                );
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int deleteCompany(UUID companyId) {

        Optional<Company> haveCompany = selectCompanyById(companyId);

        System.out.println(haveCompany);

        if(haveCompany.isEmpty()) {

            return 0;
        }
        DB.remove(haveCompany.get());
        return 1;

    }
}
