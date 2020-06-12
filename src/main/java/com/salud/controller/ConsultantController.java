package com.salud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.salud.exception.ResourceNotFoundException;
import com.salud.model.Consultant;
import com.salud.repository.ConsultantRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ConsultantController {
	
    @Autowired
    private ConsultantRepository consultantRepository;

    @GetMapping("/consultant/all")
    public List<Consultant> getAllConsultants() {
        return consultantRepository.findAll();
    }

    @GetMapping("/consultant/{id}")
    public ResponseEntity<Consultant> getConsultantById(@PathVariable(value = "id") Long consId)
        throws ResourceNotFoundException {
    	Consultant cons = consultantRepository.findById(consId)
          .orElseThrow(() -> new ResourceNotFoundException("Consultant not found for this id :: " + consId));
        return ResponseEntity.ok().body(cons);
    }
    
    @PostMapping("/register/consultant")
    public Consultant createConsultant(@Valid @RequestBody Consultant cons) {
        return consultantRepository.save(cons);
    }

    @PutMapping("/update/consultant/{id}")
    public ResponseEntity<Consultant> updateConsultant(@PathVariable(value = "id") Long consId,
         @Valid @RequestBody Consultant consultantDetails) throws ResourceNotFoundException {
        Consultant cons = consultantRepository.findById(consId)
        .orElseThrow(() -> new ResourceNotFoundException("Consultant not found for this id :: " + consId));

        cons.setMail(consultantDetails.getMail());
        cons.setConsultantPassword(consultantDetails.getConsultantPassword());
        cons.setConsultantName(consultantDetails.getConsultantName());
        cons.setConsultantLastName(consultantDetails.getConsultantLastName());
        cons.setSex(consultantDetails.getSex());
        cons.setTelephone(consultantDetails.getTelephone());
        cons.setStatus(consultantDetails.getStatus());
        final Consultant updatedConsultant = consultantRepository.save(cons);
        return ResponseEntity.ok(updatedConsultant);
    }

    @DeleteMapping("/delete/consultant/{id}")
    public Map<String, Boolean> deleteConsultant(@PathVariable(value = "id") Long consId)
         throws ResourceNotFoundException {
        Consultant cons = consultantRepository.findById(consId)
       .orElseThrow(() -> new ResourceNotFoundException("Consultant not found for this id :: " + consId));

        consultantRepository.delete(cons);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
