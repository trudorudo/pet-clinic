package guru.springboot.petclinic.services;

import guru.springboot.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
