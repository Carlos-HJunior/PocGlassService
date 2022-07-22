package com.poc.pocglassservice;

import com.poc.pocglassservice.models.entities.Contact;
import com.poc.pocglassservice.services.ContactService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ContactController implements Serializable {
    @EJB
    private ContactService service;

    private Contact contact;
    private List<Contact> contacts;

    @PostConstruct
    public void init() {
        contact = new Contact();
        contacts = service.list();
    }

    public void insert() {
        service.insert(contact);
        init();
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
