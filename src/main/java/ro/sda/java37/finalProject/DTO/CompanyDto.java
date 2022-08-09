package ro.sda.java37.finalProject.DTO;

import lombok.Data;

@Data
public class CompanyDto {
    private int id;
    private String companyName;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logoType;

}
