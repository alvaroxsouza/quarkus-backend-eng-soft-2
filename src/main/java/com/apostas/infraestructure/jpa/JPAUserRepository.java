package com.apostas.infraestructure.jpa;

import com.apostas.domain.user.User;
import com.apostas.domain.repository.UserRepository;
import com.apostas.infraestructure.panache.PanacheUserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JPAUserRepository implements UserRepository {

    private PanacheUserRepository panacheUserRepository;

    @Inject
    public JPAUserRepository(PanacheUserRepository panacheUserRepository) {
        this.panacheUserRepository = panacheUserRepository;
    }

    @Override
    public void add(User obj) {
        this.panacheUserRepository.persist(obj);
    }

    @Override
    public void remove(User obj) {
        this.panacheUserRepository.delete(obj);
    }

    @Override
    public User get(Long id) {
        return this.panacheUserRepository.findById(id);
    }

    @Override
    public boolean exists(User obj) {
        return this.get(obj.id) != null;
    }

    @Override
    public List<User> all() {
        return this.panacheUserRepository.listAll();
    }
}
