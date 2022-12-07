package com.vhs.rental.service;

import com.vhs.rental.model.Vhs;
import com.vhs.rental.repository.VhsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VhsService {

    private final VhsRepository vhsRepository;

    @Autowired
    public VhsService(VhsRepository vhsRepository) {
        this.vhsRepository = vhsRepository;
    }

    public List<Vhs> getAllVhs(){
        return vhsRepository.findAll();
    }

    public Vhs getVhsById(Long id){
        return vhsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("No VHS found with ID = %d", id)));
    }

    public void addVhs(Vhs vhs){
        vhsRepository.save(vhs);
    }

    public void deleteVhs(Long id){
        vhsRepository.deleteById(id);
    }

    public void editVhs(Long id, Vhs vhs){
        Vhs oldVhs = vhsRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("No VHS found with ID = %d", id)));

        oldVhs.setName(vhs.getName());
        oldVhs.setAvailableForRent(vhs.isAvailableForRent());
        vhsRepository.save(oldVhs);
    }
}
