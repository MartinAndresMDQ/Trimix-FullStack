package com.trimix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trimix.dao.PersonaDao;
import com.trimix.model.Persona;

@Service
@Transactional(readOnly = true)
public class PersonaServiceImp implements PersonaService {

	@Autowired
	private PersonaDao personaDao;

	@Transactional
	@Override
	public long save(Persona person) {
		return personaDao.save(person);
	}

	@Override
	public Persona get(long id) {
		return personaDao.get(id);
	}

	@Override
	public List<Persona> list() {
		return personaDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Persona person) {
		personaDao.update(id, person);
	}

	@Transactional
	@Override
	public void delete(long id) {
		personaDao.delete(id);
	}

	@Override
	public List<Persona> list(String tipo, int pagina, int cantidad) {
		// TODO Auto-generated method stub
		return personaDao.list(tipo, pagina, cantidad);
	}

	@Override
	public List<Persona> list(String tipo, String nombre, int pagina, int cantidad) {
		// TODO Auto-generated method stub
		return personaDao.list(tipo, nombre, pagina, cantidad);
	}

	@Override
	public Long cant(String tipo) {
		// TODO Auto-generated method stub
		return personaDao.cant(tipo);
	}

	@Override
	public Long cant(String tipo, String nombre) {
		// TODO Auto-generated method stub
		return personaDao.cant(tipo, nombre);
	}

}
