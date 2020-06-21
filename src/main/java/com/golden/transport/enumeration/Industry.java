package com.golden.transport.enumeration;

/**
 * Created by Temri Mustapha on 05/12/2016.
 */
public enum Industry {

    PME("Pme"), ERP("Erp"), ASP("Asp"), ADMINISTRATOR("Administrator"), OTHERS("Others");

    private final String industry;

    Industry(String industry) {
        this.industry = industry;
    }


    public String getIndustry() {
        return industry;
    }
}
