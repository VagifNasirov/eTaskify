package az.itcity.etaskify.dto;

import lombok.Data;

import java.io.Serializable;

//lombok bezen islemir todo
@Data
public class OrganizationDto implements Serializable {
    private static final long serialVersionUID = 6423983589426100520L;
    private Long id;
    private String orgName;
    private String number;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
