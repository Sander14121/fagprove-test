package no.fintlabs.fagproveOving.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContactInfo {
    private String phoneNumber;
    private String email;

}
