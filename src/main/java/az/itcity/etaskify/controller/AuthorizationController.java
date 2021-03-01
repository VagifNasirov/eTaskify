package az.itcity.etaskify.controller;

import az.itcity.etaskify.security.EtaskifyUserDetailsService;
import az.itcity.etaskify.security.JwtRequest;
import az.itcity.etaskify.security.JwtResponse;
import az.itcity.etaskify.security.UserPrincipal;
import az.itcity.etaskify.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private AuthenticationManager authenticationManager;
    private EtaskifyUserDetailsService userDetailsService;
    private JwtUtil jwtUtil;

    public AuthorizationController(AuthenticationManager authenticationManager, EtaskifyUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/")
    public JwtResponse authenticate(@RequestBody JwtRequest request){

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserPrincipal userPrincipal = (UserPrincipal) userDetailsService.loadUserByUsername(request.getUsername());
            String token = jwtUtil.generateToken(userPrincipal);
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setToken(token);
            return jwtResponse;
        }catch (BadCredentialsException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
