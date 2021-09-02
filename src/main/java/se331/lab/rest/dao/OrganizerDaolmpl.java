package se331.lab.rest.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaolmpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(789L)
                .name("Will")
                .address("A")
                .build());
        organizerList.add(Organizer.builder()
                .id(790L)
                .name("Jho")
                .address("B")
                .build());
        organizerList.add(Organizer.builder()
                .id(791L)
                .name("Toy")
                .address("C")
                .build());
        organizerList.add(Organizer.builder()
                .id(792L)
                .name("Tom")
                .address("D")
                .build());
        organizerList.add(Organizer.builder()
                .id(793L)
                .name("Malee")
                .address("E")
                .build());
        organizerList.add(Organizer.builder()
                .id(794L)
                .name("Whee")
                .address("F")
                .build());
    }


    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1)*pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(event ->
                event.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer){
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }

}
