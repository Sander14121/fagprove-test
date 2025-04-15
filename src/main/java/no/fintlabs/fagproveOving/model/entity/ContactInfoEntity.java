package no.fintlabs.fagproveOving.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactInfoEntity {

    @Id
    private String id;

    private String phoneNumber;
    private String email;
}
