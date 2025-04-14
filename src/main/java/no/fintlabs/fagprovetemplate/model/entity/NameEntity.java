package no.fintlabs.fagprovetemplate.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NameEntity {

    @Id
    private String id;

    private String firstName;
    private String lastName;
}
