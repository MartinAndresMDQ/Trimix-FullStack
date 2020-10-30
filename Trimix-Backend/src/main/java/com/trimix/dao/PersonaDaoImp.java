package com.trimix.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trimix.model.Persona;

@Repository
public class PersonaDaoImp implements PersonaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Persona person) {
//		System.out.println(person);
		sessionFactory.getCurrentSession().save(person);
		return person.getPerId();
	}

	@Override
	public Persona get(long id) {
		return sessionFactory.getCurrentSession().get(Persona.class, id);
	}

//	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> list() {

		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
		Root<Persona> root = cq.from(Persona.class);
		cq.orderBy(cb.asc(root.get("perId"))).distinct(true);

		List<Persona> object = this.sessionFactory.getCurrentSession().createQuery(cq)
				// .setFirstResult(desde) // offset
				// .setMaxResults(hasta) // limit
				.getResultList();
		return object;
//		
//		List<Persona> list = sessionFactory.getCurrentSession().createQuery("from persona").list();
//		return list;
	}

	@Override
	public void update(long id, Persona person) {
		Session session = sessionFactory.getCurrentSession();
		Persona person2 = session.byId(Persona.class).load(id);
		person2.setPerApellido(person.getPerApellido());
		person2.setPerFechaNacimiento(person.getPerFechaNacimiento());
		person2.setPerNombre(person.getPerNombre());
		person2.setPerNumeroDocumento(person.getPerNumeroDocumento());
		person2.setPerTipoDocumento(person.getPerTipoDocumento());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Persona persona = sessionFactory.getCurrentSession().byId(Persona.class).load(id);
		sessionFactory.getCurrentSession().delete(persona);
	}

	@Override
	public List<Persona> list(String tipo, int pagina, int cantidad) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
		Root<Persona> root = cq.from(Persona.class);
		if (!tipo.equals("Todas")) {
			Predicate predicate = cb.equal(root.get("perTipoDocumento"), tipo);
			cq.where(predicate);
		}
		cq.orderBy(cb.asc(root.get("perId"))).distinct(true);

		List<Persona> object = this.sessionFactory.getCurrentSession().createQuery(cq)
				.setFirstResult((pagina - 1) * cantidad) // offset
				.setMaxResults(cantidad) // limit
				.getResultList();
		return object;

	}

	@Override
	public Long cant(String tipo) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Persona> root = cq.from(Persona.class);
		cq.select(cb.count(root));
		if (!tipo.equals("Todas")) {
			Predicate predicate = cb.equal(root.get("perTipoDocumento"), tipo);
			cq.where(predicate);
		}
		cq.distinct(true);

		Long object = this.sessionFactory.getCurrentSession().createQuery(cq).getSingleResult();
		return object;

	}

	@Override
	public Long cant(String tipo, String nombre) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Persona> root = cq.from(Persona.class);
		cq.select(cb.count(root));
		Predicate predicate = cb.like(cb.lower(root.get("perNombre")), "%" + nombre.toLowerCase() + "%");
		if (!tipo.equals("Todas")) {
			predicate = cb.and(predicate, cb.equal(root.get("perTipoDocumento"), tipo));
		}
		cq.where(predicate).distinct(true);

		Long object = this.sessionFactory.getCurrentSession().createQuery(cq).getSingleResult();
		return object;

	}

	@Override
	public List<Persona> list(String tipo, String nombre, int pagina, int cantidad) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
		Root<Persona> root = cq.from(Persona.class);
		Predicate predicate = cb.like(cb.lower(root.get("perNombre")), "%" + nombre.toLowerCase() + "%");
		if (!tipo.equals("Todas")) {
			predicate = cb.and(predicate, cb.equal(root.get("perTipoDocumento"), tipo));
		}
		cq.where(predicate).orderBy(cb.asc(root.get("perId"))).distinct(true);

		List<Persona> object = this.sessionFactory.getCurrentSession().createQuery(cq)
				.setFirstResult((pagina - 1) * cantidad) // offset
				.setMaxResults(cantidad) // limit
				.getResultList();
		return object;
	}

}
