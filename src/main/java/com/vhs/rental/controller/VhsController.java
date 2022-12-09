package com.vhs.rental.controller;

import com.vhs.rental.exception.VhsNotFoundException;
import com.vhs.rental.form.VhsForm;
import com.vhs.rental.model.Vhs;
import com.vhs.rental.service.VhsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/vhs")
public class VhsController {

    @Autowired
    VhsService vhsService;

    @GetMapping(value = "/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Vhs> getAll(){
        log.info("GET All Vhs'");
        return vhsService.getAllVhs();
    }

    @GetMapping(value = "/getById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Vhs getById(@PathVariable Long id){
        log.info("GET Vhs by id");
        return vhsService.getVhsById(id);
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasRole('ADMIN')")
    public void addVhs(@RequestBody VhsForm vhsForm){
        log.info("PUT Vhs");
        vhsService.addVhs(vhsForm);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteVhs(@PathVariable Long id){
        log.info("Delete Vhs");
        vhsService.deleteVhs(id);
    }

    @PutMapping(value = "/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editVhs(@PathVariable Long id, @RequestBody VhsForm vhsForm) throws VhsNotFoundException {
        log.info("Edit Vhs");
        vhsService.editVhs(id, vhsForm);
    }


}
