package guru.springboot.petclinic.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns =  @JoinColumn(name="vet_id"),
    inverseJoinColumns = @JoinColumn(name="specialty-id"))
}
