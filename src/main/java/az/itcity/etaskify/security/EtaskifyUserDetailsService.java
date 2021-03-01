package az.itcity.etaskify.security;

import az.itcity.etaskify.entity.User;
import az.itcity.etaskify.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtaskifyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public EtaskifyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getUserByEmail(email);

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            UserPrincipal userPrincipal = new UserPrincipal(user);


            return userPrincipal;

        }
        throw new UsernameNotFoundException("User with this email" + email + " is not found") ;
    }
}
