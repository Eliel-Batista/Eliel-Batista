package com.example.adress_maneger.Repositories;

import com.example.adress_maneger.Model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {


}
