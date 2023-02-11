package com.example.form.Registation.Detailsserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.form.Registation.Detailsserver.entity.Forms;
import com.example.form.Registation.Detailsserver.repository.FormRepository;

@Service
public class FormService {
    
    @Autowired
    private FormRepository formRepository;

    public List <Forms> listAll() {
        return formRepository.findAll();
    }

    public void save(Forms form) {
        formRepository.save(form);
    }

    public Forms get(Long id) {
        return formRepository.findById(id).get();
    }
   

    public void delete(Long id) {
        formRepository.deleteById(id);
    }
}
