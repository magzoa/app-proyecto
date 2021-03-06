package com.mycompany.proyecto.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;

/**
 * Un simple POJO con una propiedad nombre.
 * Se utiliza como clase base para los objetos que necesiten 
 * esta propiedad
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	@NotNull 
	@Size(min=5, max=60)
	protected String nombre;
	
	public NamedEntity() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
}