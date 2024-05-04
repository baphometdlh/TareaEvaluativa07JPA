package eus.birt.dam.controller;

import eus.birt.dam.domain.Disco;
import eus.birt.dam.repository.DiscoRepository;
import eus.birt.dam.repository.EstiloRepository;
import eus.birt.dam.repository.GrupoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//Chequeado que hace todos los crud

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/discos")
public class DiscoController {

    @Autowired
    DiscoRepository discoRepository;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    EstiloRepository estiloRepository;

    @GetMapping({"/",""})
    public List <Disco> index(){
        return discoRepository.findAll();        
    }

    @GetMapping("/{id}")
    public Disco show(@PathVariable Long id){
        return discoRepository.findById(id).orElse(null);
    }

    @PostMapping({"/", ""})
    @ResponseStatus(HttpStatus.CREATED)
    public Disco create(@RequestBody Disco disco){
        return discoRepository.save(disco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        discoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Disco update(@RequestBody Disco disco, @PathVariable Long id){
        Disco tempDisco = discoRepository.findById(id).orElse(null);

        tempDisco.setNombre(disco.getNombre());
        tempDisco.setDuracion(disco.getDuracion());
        tempDisco.setIdEstilo(disco.getIdEstilo());
        tempDisco.setIdGrupo(disco.getIdGrupo());

        return discoRepository.save(tempDisco);
    }


}
