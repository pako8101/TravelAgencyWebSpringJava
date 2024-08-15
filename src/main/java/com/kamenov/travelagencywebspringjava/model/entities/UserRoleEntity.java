package com.kamenov.travelagencywebspringjava.model.entities;

import com.kamenov.travelagencywebspringjava.model.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity{
@NotNull
@Column(unique = true)
@Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    public UserRoleEntity() {
    }

    public @NotNull UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserRoleEntity setUserRole(@NotNull UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
