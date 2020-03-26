package guru.springboot.petclinic.bootstrap;

import guru.springboot.petclinic.model.Owner;
import guru.springboot.petclinic.model.Pet;
import guru.springboot.petclinic.model.PetType;
import guru.springboot.petclinic.model.Vet;
import guru.springboot.petclinic.services.OwnerService;
import guru.springboot.petclinic.services.PetTypeService;
import guru.springboot.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Pat");
        owner1.setLastName("Smith");
        owner1.setAddress("130 Poplar St");
        owner1.setCity("Miami");
        owner1.setTelephone("906858594");

        ownerService.save(owner1);
        Pet patsCat = new Pet();
        patsCat.setPetType(saveCatPetType);
        patsCat.setOwner(owner1);
        patsCat.setBirthDate(LocalDate.now());
        patsCat.setName("Rosco");
        owner1.getPet().add(patsCat);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mike");
        owner2.setLastName("Kale");
        owner2.setAddress("5 Broadway St");
        owner2.setCity("New York");
        owner2.setTelephone("906464e594");

        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPet().add(mikesPet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Porter");

        vetService.save(vet1);

        System.out.println("Loaded Vets .....");
    }
}
