package ris.RIS_Sprint1.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ris.RIS_Sprint1.dao.PravnikRepository;
import ris.RIS_Sprint1.models.Pravnik;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PravnikService {

    private final PravnikRepository pravnikRepository;

    @Autowired
    public PravnikService(PravnikRepository pravnikRepository) {
        this.pravnikRepository = pravnikRepository;
    }

    public void deletePravnik(Long pravnikid) {
        boolean obstaja = pravnikRepository.existsById(pravnikid);
        if(!obstaja){
            throw new IllegalStateException("Pravnik s id: " + pravnikid + " ne obstaja." );
        }
        pravnikRepository.deleteById(pravnikid);

    }

    public List<Pravnik> getVsiPravnik(){
        return pravnikRepository.findAll();
    }

    public void addNewPravnik(Pravnik pravnik) {
        Optional<Pravnik> pravnikOptional = pravnikRepository.findPravnikByEmail(pravnik.getEmail());
        if(pravnikOptional.isPresent()){
            throw new IllegalStateException("email je že uporabljen");
        }
        pravnikRepository.save(pravnik);
    }
//jaksjfojedočerpkverpivner
    @Transactional
    public void updatePravnik(Long pravnikId, String ime, String email) {
        Pravnik pravnik = pravnikRepository.findById(pravnikId).orElseThrow(() -> new IllegalStateException("Pravnik s id: " + pravnikId + " ne obstaja."));

        if (ime != null && ime.length() > 0 && !Objects.equals(pravnik.getIme(), ime)){
            pravnik.setIme(ime);
        }

        if(email != null && email.length() > 0 && !Objects.equals(pravnik.getEmail(), email)){
            Optional<Pravnik> pravnikOptional = pravnikRepository.findPravnikByEmail(email);
            if(pravnikOptional.isPresent()){
                throw new IllegalStateException("Email je zaseden");
            }
            pravnik.setEmail(email);
        }else{
            throw new IllegalStateException("Neveljaven vnos idk");
        }

    }






    public Optional<Pravnik> getidPravnik(Long pravnikid) {
        boolean obstaja = pravnikRepository.existsById(pravnikid);
        if(!obstaja){
            throw new IllegalStateException("Pravnik s id: " + pravnikid + " ne obstaja." );
        }
        return pravnikRepository.findById(pravnikid);
    }



}
