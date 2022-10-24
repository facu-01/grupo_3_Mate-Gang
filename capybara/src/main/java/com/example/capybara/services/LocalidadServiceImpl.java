package com.example.capybara.services;

import com.example.capybara.entities.Localidad;
import com.example.capybara.repositories.BaseRepository;
import com.example.capybara.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {super(baseRepository);}

    public Page<Localidad> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Localidad> localidades = localidadRepository.search(filtro, pageable);
            return localidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
