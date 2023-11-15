package com.petrmacek;

import com.petrmacek.model.Person;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

import java.util.UUID;

@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface PersonRepository extends ReactorPageableRepository<Person, UUID> {
}
