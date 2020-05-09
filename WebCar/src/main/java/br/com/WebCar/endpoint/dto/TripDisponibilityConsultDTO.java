package br.com.WebCar.endpoint.dto;

import lombok.Data;

@Data
public class TripDisponibilityConsultDTO {

    private String cep;
    private String street;
    private String avenue;
    private String neighborhood;

}
