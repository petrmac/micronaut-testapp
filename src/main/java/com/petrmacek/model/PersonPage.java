package com.petrmacek.model;

import io.micronaut.data.model.Page;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record PersonPage(List<Person> persons, int pageNumber, int pageSize, int totalElements) {

    public static PersonPage forPage(Page<Person> personPage) {
        return new PersonPage(personPage.getContent(), personPage.getPageNumber(), personPage.getSize(), personPage.getNumberOfElements());
    }
}
