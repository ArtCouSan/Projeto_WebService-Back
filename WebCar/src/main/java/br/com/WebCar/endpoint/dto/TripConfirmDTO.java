package br.com.WebCar.endpoint.dto;

import lombok.Data;

@Data
public class TripConfirmDTO {

    private Long idUser;
    private Long idVehicle;
    private String adress;

}
