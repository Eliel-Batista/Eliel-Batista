package com.example.adress_maneger.Services;

import com.example.adress_maneger.Model.Adress;
import com.example.adress_maneger.Repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    public Page<Adress> buscarProdutosPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return adressRepository.findAll(pageable);
    }
}
