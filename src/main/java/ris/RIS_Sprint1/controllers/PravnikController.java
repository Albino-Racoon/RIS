package ris.RIS_Sprint1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ris.RIS_Sprint1.models.Pravnik;
import ris.RIS_Sprint1.service.PravnikService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/pravnik")
public class PravnikController {
//aaaqjhvgooub
    private final PravnikService pravnikService;

    @Autowired
    public PravnikController(PravnikService pravnikService) {
        this.pravnikService = pravnikService;
    }


    @GetMapping()
    public List<Pravnik> getVsiPravnik(){
        return pravnikService.getVsiPravnik();
    }
    @GetMapping(path =  "{pravnikId}")
    public Optional<Pravnik> getidPravnik(@PathVariable("pravnikId") Long pravnikid){
        return pravnikService.getidPravnik(pravnikid);
    }

    @PostMapping()
    public void dodajPravnik(@RequestBody Pravnik pravnik){
        pravnikService.addNewPravnik(pravnik);

    }
    @DeleteMapping(path = "{pravnikId}" )
    public void izbrisiPravnik(@PathVariable("pravnikId") Long pravnikid){
        pravnikService.deletePravnik(pravnikid);

    }

    @PutMapping(path = "{pravnikid}")
    public void posodobiPravnik(@PathVariable("pravnikid") Long pravnikId, @RequestParam(required = false) String ime, @RequestParam(required = false) String email){
        pravnikService.updatePravnik(pravnikId, ime , email);
    }





}
