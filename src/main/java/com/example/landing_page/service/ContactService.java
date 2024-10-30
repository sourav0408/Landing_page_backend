package com.example.landing_page.service;

import com.example.landing_page.entity.Contact;
import com.example.landing_page.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }


    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }


    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}