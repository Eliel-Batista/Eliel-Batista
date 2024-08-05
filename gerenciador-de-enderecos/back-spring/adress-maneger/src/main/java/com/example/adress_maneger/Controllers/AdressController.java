package com.example.adress_maneger.Controllers;


import com.example.adress_maneger.Model.Adress;
import com.example.adress_maneger.Repositories.AdressRepository;
import com.example.adress_maneger.Services.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class AdressController {

    @Autowired
    private final AdressRepository adressRepository;

    @Autowired
    private AdressService adressService;

    @GetMapping
    public Page<Adress> listarProdutos(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        return adressService.buscarProdutosPaginados(page, size);
    }

//    @GetMapping
//    public List<Adress> adressList() {
//        return adressRepository.findAll();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Adress> findById(@PathVariable Long id) {
        return adressRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Adress> create(@RequestBody Adress adress) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adressRepository.save(adress));
                //adressRepository.save(adress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adress> update(@PathVariable Long id, @RequestBody Adress adress){
        return adressRepository.findById(id)
                .map(record -> {
                    record.setStreet(adress.getStreet());
                    record.setCity(adress.getCity());
                    record.setNumber(adress.getNumber());
                    record.setDistrict(adress.getDistrict());
                    record.setState(adress.getState());
                    record.setComplement(adress.getComplement());
                    record.setCep(adress.getCep());

                    Adress updated = adressRepository.save(record);

                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return adressRepository.findById(id)
                .map(record -> {
                    adressRepository.deleteById(id);
                    return  ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
