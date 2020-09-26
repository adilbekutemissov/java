package cz.cvut.fel.nss.tripguide.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * The class Custom success handler.
 */
@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * On authentication success method. controls authentication
     * and redirect depend on current users's role
     *
     * @param request        the request
     * @param response       the response
     * @param authentication the authentication
     * @throws IOException      the io exception
     * @throws ServletException the servlet exception
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String redirectUrl = null;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        label:
        for (GrantedAuthority grantedAuthority : authorities) {
            switch (grantedAuthority.getAuthority()) {
                case "TOURIST":
                    redirectUrl = "/tourist/home";
                    break label;
                case "ADMIN":
                    redirectUrl = "/admin/home";
                    break label;
                case "DELEGATE":
                    redirectUrl = "/delegate/home";
                    break label;
            }
        }
        if (redirectUrl == null) {
            throw new IllegalStateException();
        }
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}