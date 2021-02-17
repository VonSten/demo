package ee.bcs.valiit.tasks;

import ee.bcs.valiit.tasks.repo.UsersEntity;
import ee.bcs.valiit.tasks.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceIMpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = usersRepository.findUsersEntityByUserName(username);

        return User.withUsername(user.getUserName())
                .password(user.getPswrd())
                .roles("USER").build();

    }

}
