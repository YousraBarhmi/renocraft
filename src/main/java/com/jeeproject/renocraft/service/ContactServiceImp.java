package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Contact;
import com.jeeproject.renocraft.repo.ContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService{

    private final ContactRepo contactRepo;

    public ContactServiceImp(ContactRepo contactRepo){
        this.contactRepo=contactRepo;
    }

    @Override
    public void addContact(Contact contact){
        contactRepo.save(contact);
    }

    @Override
    public List<Contact> getContact() {
        return contactRepo.findAll();
    }

    @Override
    public int contactSize() {
        return (int) contactRepo.count();
    }
}
