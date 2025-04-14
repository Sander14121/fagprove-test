package no.fintlabs.fagprovetemplate.Repository;

import no.fintlabs.fagprovetemplate.model.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInforEntityRepository extends JpaRepository<ContactInfoEntity, Long> {
}
