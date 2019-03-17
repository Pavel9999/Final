package by.epam.task05.service;

import by.epam.task05.entity.Car;
import by.epam.task05.entity.Contract;
import by.epam.task05.entity.ContractData;

import java.util.List;

public interface CarService {

    List<Car> selectAllCars();
    List<Car> selectFreeCars();
    List<Car> selectClientCars(int id);
    List<Car> selectCarsFromContracts(List<Contract> contracts);
    List<Car> selectCarsFromContractData(List<ContractData> contracts);
    Car selectCar(int car_id);
    void AddCar(Car car);
}
