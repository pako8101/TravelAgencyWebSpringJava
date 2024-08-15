package com.kamenov.travelagencywebspringjava.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "bookings")
public class Bookings extends BaseEntity{
    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private HolidayTypesEntity holidayType;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    public Bookings() {
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public Bookings setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public HolidayTypesEntity getHolidayType() {
        return holidayType;
    }

    public Bookings setHolidayType(HolidayTypesEntity holidayType) {
        this.holidayType = holidayType;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public Bookings setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
