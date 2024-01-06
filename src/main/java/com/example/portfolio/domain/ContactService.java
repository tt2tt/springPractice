package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    public List<Contact> contactIndex() {return contactRepository.contactIndex();}
    public void contactCreate(String category,String content) {contactRepository.contactCreate(category,content);}
}
