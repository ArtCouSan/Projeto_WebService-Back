package br.com.WebCar.endpoint.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Setter
@Getter
@Entity
@Table(name = "tb_trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "trip_locales",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "local_id"))
    private List<Local> locales;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "trip_value")
    private BigDecimal tripValue;

}
