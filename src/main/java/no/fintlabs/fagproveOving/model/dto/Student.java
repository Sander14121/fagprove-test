package no.fintlabs.fagproveOving.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Student {
    private String id;
    private String fodselsnummer;
    private Name name;
    private ContactInfo contactInfo;
    private float avradeGrades;
}
