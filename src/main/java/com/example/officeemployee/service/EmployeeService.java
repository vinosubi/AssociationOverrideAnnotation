package com.example.officeemployee.service;

import com.example.officeemployee.model.Address;
import com.example.officeemployee.model.City;
import com.example.officeemployee.model.OfficeEmployee;
import com.example.officeemployee.repository.CityRepository;
import com.example.officeemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public void createEmployees() {
        City newYork = new City("New York");
        City losAngeles = new City("Los Angeles");
        cityRepository.save(newYork);
        cityRepository.save(losAngeles);

        // Create home address for John
        Address homeAddress = new Address("Elm St.", "12345", newYork);

        // Create work address for John
        Address workAddress = new Address("Maple St.", "67890", losAngeles);

        // Create OfficeEmployee John with home and work addresses
        OfficeEmployee john = new OfficeEmployee("John", homeAddress, workAddress);

        employeeRepository.save(john);
    }

    public OfficeEmployee getOfficeEmployee(Long id) {
        return (OfficeEmployee) employeeRepository.findById(id).orElse(null);
    }
}
