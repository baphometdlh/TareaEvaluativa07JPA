package eus.birt.dam.controller;

import eus.birt.dam.domain.Estilo;
import eus.birt.dam.repository.EstiloRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//Chequeado que hace todos los crud

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/estilos")
public class EstiloController {

    @Autowired
    EstiloRepository estiloRepository;

    @GetMapping({"/", ""})
	public List <Estilo> index() {
	return estiloRepository.findAll();
	}
    
    @GetMapping("/{id}")
	public Estilo show(@PathVariable Long id){
	return estiloRepository.findById(id).orElse(null);
	}
    
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	estiloRepository.deleteById(id);
    }
    
    @PostMapping({"/", ""})
	@ResponseStatus (HttpStatus.CREATED)
    public Estilo create(@RequestBody Estilo estilo) {
    	return estiloRepository.save(estilo);
    }
    
    @PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
    public Estilo update(@RequestBody Estilo estilo, @PathVariable Long id) {
    	Estilo tempEstilo = estiloRepository.findById(id).orElse(null);
    	
    	tempEstilo.setNombre(estilo.getNombre());
    	tempEstilo.setPaisCreacion(estilo.getPaisCreacion());
    	tempEstilo.setDisco(estilo.getDisco());
    	
    	return estiloRepository.save(tempEstilo);
    	
    }

}
