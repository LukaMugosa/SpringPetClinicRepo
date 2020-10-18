package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
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
        PetType savedDogPetType = this.petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat1PetType = this.petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Luka");
        owner1.setLastName("Mugosa");
        owner1.setAddress("123 Streetname");
        owner1.setCity("Podgorica");
        owner1.setTelephone("069842993");

        Pet lukinPas = new Pet();
        lukinPas.setPetType(savedDogPetType);
        lukinPas.setOwner(owner1);
        lukinPas.setBirthDate(LocalDate.now());
        lukinPas.setName("Leon");
        owner1.getPets().add(lukinPas);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivana");
        owner2.setLastName("Djukic");
        owner2.setAddress("123 Streetname");
        owner2.setCity("Podgorica");
        owner2.setTelephone("068858166");

        Pet ivaninPas = new Pet();
        ivaninPas.setPetType(savedDogPetType);
        ivaninPas.setOwner(owner2);
        ivaninPas.setBirthDate(LocalDate.now());
        ivaninPas.setName("Alfi");
        owner2.getPets().add(ivaninPas);

        ownerService.save(owner2);

        System.out.println("Load Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Milos");
        vet1.setLastName("Ostojic");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Andrija");
        vet2.setLastName("Musikic");

        vetService.save(vet2);

        System.out.println("Load Vets...");


    }
}
