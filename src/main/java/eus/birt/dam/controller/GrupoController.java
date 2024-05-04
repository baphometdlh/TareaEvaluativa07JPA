package eus.birt.dam.controller;

import eus.birt.dam.domain.Grupo;
import eus.birt.dam.repository.DiscoRepository;
import eus.birt.dam.repository.EstiloRepository;
import eus.birt.dam.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//Chequeado que hace todos los crud

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/bands")
public class GrupoController {

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    DiscoRepository discoRepository;

    @Autowired
    EstiloRepository estiloRepository;

    @GetMapping({"/",""})
    public List <Grupo> index(){
        return grupoRepository.findAll();        
    }

    @GetMapping("/{id}")
    public Grupo show(@PathVariable Long id) {

        return grupoRepository.findById(id).orElse(null);
    }

    @PostMapping({"/", ""})
    @ResponseStatus (HttpStatus.CREATED)
    public Grupo create(@RequestBody Grupo grupo) {
    	return grupoRepository.save(grupo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo update(@RequestBody Grupo grupo, @PathVariable Long id){
        Grupo tempGrupo = grupoRepository.findById(id).orElse(null);

        tempGrupo.setNombre(grupo.getNombre());
        tempGrupo.setPais(grupo.getPais());
        tempGrupo.setAnoCreacion(grupo.getAnoCreacion());
        tempGrupo.setDisco(grupo.getDisco());

        return grupoRepository.save(tempGrupo);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        grupoRepository.deleteById(id);
    }

}
