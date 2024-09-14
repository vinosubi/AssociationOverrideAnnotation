package com.example.officeemployee.model;

import javax.persistence.*;

@Entity
@AssociationOverride(
    name = "homeAddress.city",
    joinColumns = @JoinColumn(name = "work_city_id")
)
public class OfficeEmployee extends Employee {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "work_street")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "work_zipCode"))
    })
    private Address workAddress;

    public OfficeEmployee() {}

    public OfficeEmployee(String name, Address homeAddress, Address workAddress) {
        super(name, homeAddress);
        this.workAddress = workAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
}
