package guru.springboot.petclinic.model;

import java.util.Set;

public class Owner extends Person{
    private Set<Pet> pet;

    public Owner(Set<Pet> pet) {
        this.pet = pet;
    }
}
