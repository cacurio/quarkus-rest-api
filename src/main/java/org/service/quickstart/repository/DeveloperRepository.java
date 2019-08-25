package org.service.quickstart.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.service.quickstart.entity.Developer;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DeveloperRepository implements PanacheRepository<Developer> {

    public  Developer create(Developer developer){
        persist(developer);
        return developer;
    }

    @Transactional
    public Developer findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Developer> findAllRecords(){
        return listAll();
    }

    public Developer findByNameAndAge(String name, Integer age){
        return find("name = ?1 and age = ?2", name, age).firstResult();
    }

    public Developer findById(Long id){
        return find("id",id).firstResult();
    }
}
