package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Contact;

import java.util.List;

public interface ContactService {
    public void addContact(Contact contact);
    public List<Contact> getContact();
}
