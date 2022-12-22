package staj.RESTAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import staj.RESTAPI.entity.Adres;

public interface AdresRepository extends JpaRepository<Adres, Long> {
}
