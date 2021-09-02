package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.repository.EventRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Misterm Exam")
                .description("A time for takind th exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT").build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU hall")
                .date("21th Jan")
                .time("8.00-4.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Loy Krathong")
                .location("Ping river")
                .date("21th Nov")
                .time("3.00-10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's play water")
                .location("Cnx moat")
                .date("13rd April")
                .time("10.00-6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai").build());
    }

}