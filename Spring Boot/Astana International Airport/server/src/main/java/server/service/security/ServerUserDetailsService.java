package server.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import server.model.PassengerEntity;
import server.repositories.PassengerRepository;

@Service
public class ServerUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private final PassengerRepository repository;

    @Autowired
    public ServerUserDetailsService(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final PassengerEntity passenger= repository.findOneByName(name);
        if (passenger == null) {
            throw new UsernameNotFoundException("User with username " + name + " not found.");
        }

        return new server.security.model.UserDetails(passenger);
    }
}
