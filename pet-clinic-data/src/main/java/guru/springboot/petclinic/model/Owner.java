package guru.springboot.petclinic.model;

import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Table(name="owners")
public class Owner extends Person{
    private String address;
    private String city;
    private String Telephone;
    private Set<Pet> pet = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }
}
