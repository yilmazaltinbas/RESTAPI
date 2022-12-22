package staj.RESTAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import staj.RESTAPI.entity.Kisi;

public interface KisiRepostiory extends JpaRepository<Kisi, Long> {
}
