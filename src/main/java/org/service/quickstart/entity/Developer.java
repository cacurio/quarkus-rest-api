package org.service.quickstart.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Developer {

    @Id
    private Long id;

    @Column(unique = true)
    public String name;

    @Column
    public Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
