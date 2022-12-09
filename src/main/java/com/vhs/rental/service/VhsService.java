package com.vhs.rental.service;

import com.vhs.rental.exception.VhsNotFoundException;
import com.vhs.rental.form.VhsForm;
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
        System.out.println(vhsRepository.findByVhsId(id));
        return vhsRepository.findByVhsId(id);
    }

    public void addVhs(VhsForm vhsForm){
        Vhs vhs = new Vhs();
        vhs.setName(vhsForm.getName());
        vhs.setAvailableForRent(vhsForm.isAvailableForRent());
        vhsRepository.save(vhs);
    }

    public void deleteVhs(Long id){
        vhsRepository.deleteById(id);
    }

    public void editVhs(Long id, VhsForm vhsForm) throws VhsNotFoundException {
        Vhs oldVhs = vhsRepository.findById(id)
                .orElseThrow(() -> new VhsNotFoundException(String.format("No VHS found with ID = %d", id)));

        oldVhs.setName(vhsForm.getName());
        oldVhs.setAvailableForRent(vhsForm.isAvailableForRent());
        vhsRepository.save(oldVhs);
    }
}
