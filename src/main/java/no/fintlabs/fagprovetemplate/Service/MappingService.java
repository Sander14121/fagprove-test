package no.fintlabs.fagprovetemplate.Service;

import no.fintlabs.fagprovetemplate.model.dto.ContactInfo;
import no.fintlabs.fagprovetemplate.model.dto.Name;
import no.fintlabs.fagprovetemplate.model.dto.Student;
import no.fintlabs.fagprovetemplate.model.entity.ContactInfoEntity;
import no.fintlabs.fagprovetemplate.model.entity.NameEntity;
import no.fintlabs.fagprovetemplate.model.entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingService {


    public StudentEntity mapStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setNameEntity(mapName(student.getName(), student.getId()));
        studentEntity.setContactInfoEntity(mapContactInfo(student.getContactInfo(), student.getId()));
        studentEntity.setAvradeGrades(student.getAvradeGrades());
        return studentEntity;

    }

    private ContactInfoEntity mapContactInfo(ContactInfo contactInfo, String id) {
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity();
        contactInfoEntity.setId(id);
        contactInfoEntity.setEmail(contactInfo.getEmail());
        contactInfoEntity.setPhoneNumber(contactInfo.getPhoneNumber());
        return contactInfoEntity;

    }

    private NameEntity mapName(Name name, String id) {
        NameEntity nameEntity = new NameEntity();
        nameEntity.setId(id);
        nameEntity.setFirstName(name.getFirstName());
        nameEntity.setLastName(name.getLastName());
        return nameEntity;
    }
}
