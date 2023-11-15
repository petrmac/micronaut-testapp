package com.petrmacek.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Introspected
@Getter
@Setter
@Serdeable
@MappedEntity
public class Person {

    @Id
    @AutoPopulated
    private UUID id;

    @NotEmpty(message = "can not be empty")
    @Size(min = 1, max = 20)
    private String name;

    @Min(18)
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

}