package com.example.demo.crudYoutube.api.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Company {


    private final UUID companyId;

    private final String companyLeader;

    private final String companyDescription;

    public Company
            (@JsonProperty("companyId") UUID companyId,
             @JsonProperty("companyLeader") String companyLeader,
             @JsonProperty("companyDescription") String companyDescription
            ) {
        this.companyId = companyId;
        this.companyLeader = companyLeader;
        this.companyDescription = companyDescription;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public String getCompanyLeader() {
        return companyLeader;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }
}
