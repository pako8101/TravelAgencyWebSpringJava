package com.kamenov.travelagencywebspringjava.service;

import com.kamenov.travelagencywebspringjava.model.entities.UserEntity;
import com.kamenov.travelagencywebspringjava.model.entities.UserRoleEntity;
import com.kamenov.travelagencywebspringjava.model.user.AppUserDetails;
import com.kamenov.travelagencywebspringjava.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return
                userRepository.
                        findUserEntByUsername(username).
                        map(ApplicationUserDetailsService::map).
                        orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }

    private static   UserDetails map(UserEntity userEntity) {

        return new AppUserDetails(
                userEntity.getUsername(),
                userEntity.getPassword(),
                extractAuthorities(userEntity)
        ).setAge(userEntity.getAge()).
                setFullName(userEntity.getFullName());

    }


    private static List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
        return userEntity.
                getRoles().
                stream().
                map(ApplicationUserDetailsService::mapRole).
                toList();
    }

    private static GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getUserRole().name());

    }
}
