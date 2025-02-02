package com.bolingcavalry.resource;

import com.bolingcavalry.model.Person;
import com.bolingcavalry.repository.PersonRepositoryAsyncAwait;
import io.smallrye.common.annotation.RunOnVirtualThread;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/vt/persons")
@RunOnVirtualThread
public class VTPersonResource {

    @Inject
    PersonRepositoryAsyncAwait personRepository;

    @GET
    @Path("/{id}")
    public Person getPersonById(@PathParam("id") Long id) {
        return personRepository.findById(id);
    }

}
