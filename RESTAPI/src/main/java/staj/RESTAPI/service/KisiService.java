package staj.RESTAPI.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import staj.RESTAPI.dto.KisiDto;

import java.util.List;

public interface KisiService {

    KisiDto save(KisiDto kisiDto);

    void delete(Long id);

    List<KisiDto> getAll();

    Page<KisiDto> getAll(Pageable pageable);
}
