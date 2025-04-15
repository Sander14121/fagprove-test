package no.fintlabs.fagprovetemplate.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentEntity {

    @Id
    private String id;

    private String fodselsnummer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private NameEntity nameEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id", referencedColumnName = "id")
    private ContactInfoEntity contactInfoEntity;

    private float avradeGrades;

}
