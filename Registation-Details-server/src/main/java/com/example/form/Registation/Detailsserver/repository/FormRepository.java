package com.example.form.Registation.Detailsserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.form.Registation.Detailsserver.entity.Forms;

@Repository
public interface FormRepository extends JpaRepository<Forms, Long>{
    
}
