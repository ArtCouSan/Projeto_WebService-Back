package br.com.WebCar.endpoint.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "tb_user")
public class User {

    @GeneratedValue
    @Id
    @Column(name ="user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_birth")
    private LocalDate dtBirth;

    @Column(name = "user_cpf")
    private String cpf;

    @Column(name = "user_status")
    private Boolean status;

    @Column(name = "user_in_vehicle")
    private Boolean inVehicle;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Trip> trips;

}
