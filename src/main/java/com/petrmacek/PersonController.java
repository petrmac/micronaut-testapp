package com.petrmacek;

import com.petrmacek.model.Message;
import com.petrmacek.model.Person;
import com.petrmacek.model.PersonPage;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller("/persons")
@Slf4j
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;


    @Post()
    public Mono<HttpResponse<?>> savePerson(@Body @Valid Person person) {
        return this.personRepository.save(person)
                .thenReturn(HttpResponse.status(HttpStatus.CREATED)
                        .body(new Message(HttpStatus.CREATED.getCode(), "Saved successfully !")));
    }

    @Get()
    public Mono<HttpResponse<PersonPage>> getPersons(Pageable pageable) {
        return this.personRepository.findAll(pageable)
                .map(personsPage -> HttpResponse.status(HttpStatus.OK)
                        .body(PersonPage.forPage(personsPage)));
    }

}
