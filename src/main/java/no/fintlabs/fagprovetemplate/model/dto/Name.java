package no.fintlabs.fagprovetemplate.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Name {
    private String firstName;
    private String lastName;
}
