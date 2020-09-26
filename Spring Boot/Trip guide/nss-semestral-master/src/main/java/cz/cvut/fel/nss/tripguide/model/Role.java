package cz.cvut.fel.nss.tripguide.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * The enum Role represents roles in our app.
 */
public enum Role implements GrantedAuthority {

    /**
     * Admin role.
     */
    ADMIN,
    /**
     * Delegate role.
     */
    DELEGATE,
    /**
     * Tourist role.
     */
    TOURIST;

    /**
     * Gets authority.
     *
     * @return the authority
     */
    @Override
    public String getAuthority() {
        return name();
    }
}