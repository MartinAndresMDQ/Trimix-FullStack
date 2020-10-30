package com.trimix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trimix.model.Persona;
import com.trimix.service.PersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	/*---Add new persona---*/
	@PostMapping("/persona")
	public ResponseEntity<?> save(@RequestBody Persona persona) {

		HttpHeaders headers = new HttpHeaders();
		long id = 0;
		try {
			id = personaService.save(persona);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(id, headers, HttpStatus.OK);

	}

	/*---Get a persona by id---*/
	@GetMapping("/persona/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") long id) {

		HttpHeaders headers = new HttpHeaders();
		Persona personas = new Persona();
		try {
			personas = personaService.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(personas, headers, HttpStatus.OK);

	}

	/*---get all personas---*/
	@GetMapping("/personas")
//	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> list() {

		HttpHeaders headers = new HttpHeaders();
		List<Persona> personas = new ArrayList<Persona>();
		try {
			personas = personaService.list();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(personas, headers, HttpStatus.OK);

	}

	/*---get all personas---*/
	@GetMapping("/personas/{tipo}/{pagina}/{cantidad}")
//	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> list(@PathVariable("tipo") String tipo, @PathVariable("pagina") int pagina,
			@PathVariable("cantidad") int cantidad) {
		HttpHeaders headers = new HttpHeaders();
		List<Persona> personas = new ArrayList<Persona>();
		try {
			personas = personaService.list(tipo, pagina, cantidad);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(personas, headers, HttpStatus.OK);
	}

	/*---get all personas---*/
	@GetMapping("/personas/{tipo}/{nombre}/{pagina}/{cantidad}")
//	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> list(@PathVariable("tipo") String tipo, @PathVariable("nombre") String nombre,
			@PathVariable("pagina") int pagina, @PathVariable("cantidad") int cantidad) {

		HttpHeaders headers = new HttpHeaders();
		List<Persona> personas = new ArrayList<Persona>();
		try {
			personas = personaService.list(tipo, nombre, pagina, cantidad);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(personas, headers, HttpStatus.OK);

	}

	/*---get all personas---*/
	@GetMapping("/personasCant/{tipo}")
//	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cant(@PathVariable("tipo") String tipo) {
		HttpHeaders headers = new HttpHeaders();
		Long cantidad = new Long(0);
		try {
			cantidad = personaService.cant(tipo);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(cantidad, headers, HttpStatus.OK);
	}

	/*---get all personas---*/
	@GetMapping("/personasCant/{tipo}/{nombre}")
//	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cant(@PathVariable("tipo") String tipo, @PathVariable("nombre") String nombre) {

		HttpHeaders headers = new HttpHeaders();
		Long cantidad = new Long(0);
		try {
			cantidad = personaService.cant(tipo, nombre);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(cantidad, headers, HttpStatus.OK);

	}

	/*---Update a persona by id---*/
	@PutMapping("/persona/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Persona persona) {

		HttpHeaders headers = new HttpHeaders();
		try {
			personaService.update(id, persona);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(id, headers, HttpStatus.OK);
	}

	/*---Delete a persona by id---*/
	@DeleteMapping("/persona/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {

		HttpHeaders headers = new HttpHeaders();
		try {
			personaService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), headers, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(id, headers, HttpStatus.OK);

	}
}