package server.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import server.model.PassengerEntity;

import java.util.*;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private PassengerEntity passenger;

    protected final Set<GrantedAuthority> authorities;

    public UserDetails(PassengerEntity passenger) {
        Objects.requireNonNull(passenger);
        this.passenger = passenger;
        this.authorities = new HashSet<>();
        addDefaultRole();
    }

    public UserDetails(PassengerEntity passenger, Collection<GrantedAuthority> authorities) {
        Objects.requireNonNull(passenger);
        Objects.requireNonNull(authorities);
        this.passenger = passenger;
        this.authorities = new HashSet<>();
        addDefaultRole();
        this.authorities.addAll(authorities);
    }

    private void addDefaultRole() {
        authorities.add(new SimpleGrantedAuthority(DEFAULT_ROLE));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.unmodifiableCollection(authorities);
    }

    @Override
    public String getPassword() {
        return passenger.getPassword();
    }

    @Override
    public String getUsername() {
        return passenger.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }
}
