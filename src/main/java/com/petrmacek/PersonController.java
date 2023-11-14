package com.petrmacek;

import com.petrmacek.model.Message;
import com.petrmacek.model.Person;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Controller("/persons")
@Slf4j
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;


    @Post()
    public HttpResponse<?> savePerson(@Body @Valid Person person) {
        this.personRepository.save(person);
        return HttpResponse.status(HttpStatus.CREATED)
                .body(new Message(HttpStatus.CREATED.getCode(),"Saved successfully !"));
    }

    @Get()
    public HttpResponse<?> getPersons() {
        return HttpResponse.status(HttpStatus.OK)
                .body(this.personRepository.findAll());
    }

}
