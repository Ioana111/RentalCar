package ro.sda.java37.finalProject.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String companyName;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logoType;

}
