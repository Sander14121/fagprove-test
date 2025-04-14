package no.fintlabs.fagprovetemplate.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Name name;
    private ContactInfo contactInfo;
    private String Id;
    private long avradeGrades;
}
