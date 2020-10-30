package com.trimix.dao;

import java.util.List;

import com.trimix.model.Persona;

public interface PersonaDao {

	long save(Persona persona);

	Persona get(long id);

	List<Persona> list();

	void update(long id, Persona persona);

	void delete(long id);

	List<Persona> list(String tipo, int pagina, int cantidad);

	List<Persona> list(String tipo, String nombre, int pagina, int cantidad);

	Long cant(String tipo);

	Long cant(String tipo, String nombre);

}
