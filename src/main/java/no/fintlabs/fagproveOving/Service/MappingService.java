package no.fintlabs.fagproveOving.Service;

import no.fintlabs.fagproveOving.model.dto.ContactInfo;
import no.fintlabs.fagproveOving.model.dto.Name;
import no.fintlabs.fagproveOving.model.dto.Student;
import no.fintlabs.fagproveOving.model.entity.ContactInfoEntity;
import no.fintlabs.fagproveOving.model.entity.NameEntity;
import no.fintlabs.fagproveOving.model.entity.StudentEntity;
import org.springframework.stereotype.Service;


@Service
public class MappingService {

    private final CryptationService cryptationService;

    public MappingService(CryptationService cryptationService) {
        this.cryptationService = cryptationService;
    }


    public StudentEntity mapStudent(Student student) {
        try {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(student.getId());
            studentEntity.setFodselsnummer(cryptationService.encrypt(student.getFodselsnummer()));
            studentEntity.setNameEntity(mapName(student.getName(), student.getId()));
            studentEntity.setContactInfoEntity(mapContactInfo(student.getContactInfo(), student.getId()));
            studentEntity.setAvradeGrades(student.getAvradeGrades());
            return studentEntity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public Student mapToStudentDto(StudentEntity studentEntity) {
        try {
            return Student.builder()
                    .id(studentEntity.getId())
                    .fodselsnummer(cryptationService.decrypt(studentEntity.getFodselsnummer()))
                    .name(mapNameToDto(studentEntity.getNameEntity()))
                    .contactInfo(mapContactToDto(studentEntity.getContactInfoEntity()))
                    .avradeGrades(studentEntity.getAvradeGrades())
                    .build();
        } catch (Exception e) {
            return null;
        }
    }

    private ContactInfo mapContactToDto(ContactInfoEntity contactInfoEntity) {
        return ContactInfo.builder()
                .email(contactInfoEntity.getEmail())
                .phoneNumber(contactInfoEntity.getPhoneNumber())
                .build();
    }

    private Name mapNameToDto(NameEntity nameEntity) {
        return Name.builder()
                .firstName(nameEntity.getFirstName())
                .lastName(nameEntity.getLastName())
                .build();
    }
}
