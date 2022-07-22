package com.poc.pocglassservice.services;

import com.poc.pocglassservice.models.entities.Contact;
import com.poc.pocglassservice.models.validators.ContactValidator;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class ContactService {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void insert(Contact contact) {
        em.persist(contact);
    }

    public List<Contact> list() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);

        return em.createQuery(cq.select(cq.from(Contact.class)))
                .getResultList();
    }
}
