package codegym.webConfig;

import codegym.Model.Roles;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String url = "";

        List<Roles> roles = (List<Roles>) authentication.getAuthorities();
        Roles roles1 = roles.get(0);
        if (roles1.getName().equals("ROLE_USER")) {
            url = "/user";
        } else {
            url = "/show";
        }
        response.sendRedirect(url);
    }
}
