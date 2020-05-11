package br.com.WebCar.endpoint.service.impl;

import br.com.WebCar.endpoint.dto.*;
import br.com.WebCar.endpoint.entity.Local;
import br.com.WebCar.endpoint.entity.Trip;
import br.com.WebCar.endpoint.entity.User;
import br.com.WebCar.endpoint.entity.Vehicle;
import br.com.WebCar.endpoint.enums.CarStep;
import br.com.WebCar.endpoint.enums.LocalType;
import br.com.WebCar.endpoint.repository.LocalRepository;
import br.com.WebCar.endpoint.repository.TripRepository;
import br.com.WebCar.endpoint.repository.UserRepository;
import br.com.WebCar.endpoint.repository.VehicleRepository;
import br.com.WebCar.endpoint.service.TripService;
import br.com.WebCar.endpoint.service.UserService;
import br.com.WebCar.endpoint.service.VehicleService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    private VehicleService serviceVehicle;
    private UserService serviceUser;

    private VehicleRepository repositoryVehicle;
    private LocalRepository repositoryLocal;
    private TripRepository repositoryTrip;

    public TripServiceImpl(
            VehicleService serviceVehicle,
            UserService serviceUser,
            VehicleRepository repositoryVehicle,
            LocalRepository repositoryLocal,
            TripRepository repositoryTrip) {
        this.serviceVehicle = serviceVehicle;
        this.serviceUser = serviceUser;
        this.repositoryVehicle = repositoryVehicle;
        this.repositoryLocal = repositoryLocal;
        this.repositoryTrip = repositoryTrip;
    }

    @Override
    public List<VehicleResponseDTO> disponibilityConsult(TripDisponibilityConsultDTO disponibilityConsultDTO) {
        List<VehicleResponseDTO> vehicle = repositoryVehicle
                .findVehicleRandom(PageRequest.of(0, 5))
                .stream()
                .map(VehicleResponseDTO::new)
                .collect(Collectors.toList());

        return vehicle;
    }

    @Override
    public TripResponseDTO tripConfirm(TripConfirmDTO tripConfirmDTO) {

        List<Local> locales = new ArrayList<Local>();

        Local localTo = new Local();
        localTo.setAdress(tripConfirmDTO.getAdress());
        localTo.setType(LocalType.FOR);

        localTo = repositoryLocal.save(localTo);
        locales.add(localTo);

        Local localFor = new Local();
        localFor.setAdress("Fiap Lins");
        localFor.setType(LocalType.TO);

        localFor = repositoryLocal.save(localFor);
        locales.add(localFor);

        Trip trip = new Trip();
        trip.setLocales(locales);

        User user = serviceUser.userExist(tripConfirmDTO.getIdUser());
        trip.setUser(user);
        UserAlterDTO userAlterDTO = new UserAlterDTO();
        userAlterDTO.setInVehicle(true);
        serviceUser.alterUser(user.getId(), userAlterDTO);

        Vehicle vehicle = serviceVehicle.vehicleExist(tripConfirmDTO.getIdVehicle(), null);
        trip.setVehicle(vehicle);
        VehicleAlterDTO vehicleAlterDTO = new VehicleAlterDTO();
        vehicleAlterDTO.setStatus(CarStep.IN_USE);
        serviceVehicle.alterVehicle(vehicle.getId(), vehicleAlterDTO);

        repositoryTrip.save(trip);

        TripResponseDTO tripResponseDTO = new TripResponseDTO();
        tripResponseDTO.setConfirmado(true);

        return tripResponseDTO;
    }
}
