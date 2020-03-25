package guru.springboot.petclinic.bootstrap;

import guru.springboot.petclinic.model.Owner;
import guru.springboot.petclinic.model.Vet;
import guru.springboot.petclinic.services.OwnerService;
import guru.springboot.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Pat");
        owner1.setLastName("Smith");

        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Porter");

        vetService.save(vet1);

        System.out.println("Loaded Vets .....");
    }
}
