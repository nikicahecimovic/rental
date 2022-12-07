package com.vhs.rental.controller;

import com.vhs.rental.model.Vhs;
import com.vhs.rental.service.VhsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/vhs")
public class VhsRestApi {

    @Autowired
    VhsService vhsService;

    @GetMapping(value = "/all")
    public List<Vhs> getAll(){
        log.info("GET All Vhs'");
        return vhsService.getAllVhs();
    }

    @GetMapping(value = "/getById/{id}")
    public Vhs getById(@PathVariable Long id){
        log.info("GET Vhs by id");
        return vhsService.getVhsById(id);
    }

    @PostMapping(value = "/add")
    public void addVhs(@RequestBody Vhs vhs){
        log.info("PUT Vhs");
        vhsService.addVhs(vhs);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteVhs(@PathVariable Long id){
        log.info("Delete Vhs");
        vhsService.deleteVhs(id);
    }

    @PutMapping(value = "/edit/{id}")
    public void editVhs(@PathVariable Long id, @RequestBody Vhs vhs){
        log.info("Edit Vhs");
        vhsService.editVhs(id, vhs);
    }


}
