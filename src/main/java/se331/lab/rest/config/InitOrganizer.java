package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Component
public class InitOrganizer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        organizerRepository.save(Organizer.builder()
                .id(789L)
                .name("Will")
                .address("A")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(790L)
                .name("Jho")
                .address("B")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(791L)
                .name("Toy")
                .address("C")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(792L)
                .name("Tom")
                .address("D")
                .build());
    }

}