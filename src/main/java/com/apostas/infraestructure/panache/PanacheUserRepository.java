package com.apostas.infraestructure.panache;

import com.apostas.domain.user.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheUserRepository implements PanacheRepository<User> {

//    public User getByEmail(String email) {
//        return find("email", email).firstResult();
//    }
//
//    public boolean existsByEmail(String email) {
//        return count("email", email) > 0;
//    }
//
//    public List<User> findByPerfil(Perfil perfil) {
//        return find("perfil", perfil).list();
//    }
}
