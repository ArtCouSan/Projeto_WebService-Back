package br.com.WebCar.endpoint.entity;

import br.com.WebCar.endpoint.enums.LocalType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Setter
@Getter
@Entity
@Table(name = "tb_local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long id;

    @Column(name = "local_cep")
    private String cep;

    @Column(name = "local_street")
    private String street;

    @Column(name = "local_avenue")
    private String avenue;

    @Column(name = "local_neighborhood")
    private String neighborhood;

    @Column(name = "local_type")
    @Enumerated(EnumType.STRING)
    private LocalType type;

    @JsonManagedReference
    @ManyToMany(mappedBy = "locales")
    private List<Trip> locales;

}
