package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.models.Rol;
import com.example.clinicaOdontologica.models.User;
import com.example.clinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nombreUser) throws UsernameNotFoundException {
        Optional<User> user = repository.getUserByName(nombreUser);
        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        for (Rol rol : user.get().getRoles()) {
            GrantedAuthority autorizacion = new SimpleGrantedAuthority(rol.getNombre());
            autorizaciones.add(autorizacion);
        }
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.get().getNombre(),"{noop}"+ user.get().getPassword(), true ,true, true,true, autorizaciones);
        return userDetails;
    }
}
