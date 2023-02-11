package com.example.form.Registation.Detailsserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.Registation.Detailsserver.entity.Forms;
import com.example.form.Registation.Detailsserver.service.FormService;

@RestController
@RequestMapping("/register")
public class FormController {
    
    @Autowired
    private FormService formService;

    @GetMapping("/getall")
    public List<Forms> list()
    {
        return formService.listAll();
    }

@PostMapping("/add")
    public String addinformation(@RequestBody Forms form)
    {

        // Forms form  = new Forms();
        // form.setName(dto.getName());
        // form.setCollege(dto.getCollege());
        // form.setEmail(dto.getEmail());
        // form.setPhone(dto.getPhone());

          formService.save(form);
        return "New Registation Info Added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Forms> getTeam(@PathVariable Long id)
    {
        try {
            Forms form = formService.get(id);
            return new ResponseEntity<Forms>(form,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


@PutMapping("/{id}")
    public ResponseEntity<Forms> Update(@RequestBody Forms form, @PathVariable Long id)
    {
        try {
            formService.save(form);
            return new ResponseEntity<Forms>(HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<Forms>(HttpStatus.NOT_FOUND);
        }
    }

@DeleteMapping("/{id}")
    public String deleteInformation(@PathVariable Long id)
    {
        formService.delete(id);
        return "Team Id is Deleted! "+id;
    }

}
