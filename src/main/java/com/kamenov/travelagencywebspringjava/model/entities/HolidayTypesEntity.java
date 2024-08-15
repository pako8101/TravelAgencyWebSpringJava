package com.kamenov.travelagencywebspringjava.model.entities;

import com.kamenov.travelagencywebspringjava.model.enums.HolidayTapesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "holiday_tapes")
public class HolidayTypesEntity extends BaseEntity {


    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private HolidayTapesEnum holidayTapes;

    public HolidayTypesEntity() {
    }

    public @NotNull HolidayTapesEnum getHolidayTapes() {
        return holidayTapes;
    }

    public HolidayTypesEntity setHolidayTapes(@NotNull HolidayTapesEnum holidayTapes) {
        this.holidayTapes = holidayTapes;
        return this;
    }
}
