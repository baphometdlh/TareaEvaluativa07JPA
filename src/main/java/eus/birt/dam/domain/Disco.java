package eus.birt.dam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="disco")
public class Disco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="ano_publicacion")
    private int anoPublicacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_grupo")
    private Grupo idGrupo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_estilo")
    private Estilo idEstilo;

    @Column(name="duracion")
    private int duracion;

    public String getBandName() {
    	return idGrupo != null ? idGrupo.getNombre(): null;
    }

    public String getEstiloName() {
    	return idEstilo != null ? idEstilo.getNombre(): null;
    }
    
    public Disco(String nombre, int anoPublicacion, Grupo idGrupo, Estilo idEstilo) {
    	super();
    	this.nombre = nombre;
    	this.anoPublicacion = anoPublicacion;
    	this.idGrupo = idGrupo;
    	this.idEstilo = idEstilo;
    }

}
