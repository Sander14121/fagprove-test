package no.fintlabs.fagprovetemplate.Repository;

import no.fintlabs.fagprovetemplate.model.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameEntityRepository extends JpaRepository<NameEntity, Long> {
}
