package no.fintlabs.fagproveOving.Repository;

import no.fintlabs.fagproveOving.model.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInforEntityRepository extends JpaRepository<ContactInfoEntity, Long> {
}
