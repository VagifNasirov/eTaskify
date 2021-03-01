package az.itcity.etaskify.service;

import az.itcity.etaskify.entity.User;
import az.itcity.etaskify.repository.UserRepository;
import az.itcity.etaskify.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalServiceImpl implements UserPrincipalService{
    private UserRepository userRepository;

    @Autowired
    public UserPrincipalServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (User) userRepository.findAllById((Iterable<Long>) userPrincipal);
    }
}
