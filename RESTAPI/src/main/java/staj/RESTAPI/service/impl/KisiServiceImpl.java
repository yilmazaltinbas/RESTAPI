package staj.RESTAPI.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import staj.RESTAPI.dto.KisiDto;
import staj.RESTAPI.entity.Adres;
import staj.RESTAPI.entity.Kisi;
import staj.RESTAPI.repo.AdresRepository;
import staj.RESTAPI.repo.KisiRepostiory;
import staj.RESTAPI.service.KisiService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {


    private final KisiRepostiory kisiRepostiory;

    private final AdresRepository adresRepository;

    @Override
    public KisiDto save(KisiDto kisiDto) {
        final Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final Kisi kisidb = kisiRepostiory.save(kisi);
        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresler().forEach(item->{
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisidb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisidb.getId());
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepostiory.findAll(); // bu eklenmedi rapğora eklencek unutma
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(it ->{
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(it.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
