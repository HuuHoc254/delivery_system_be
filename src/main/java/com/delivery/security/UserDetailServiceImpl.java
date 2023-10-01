package com.delivery.security;

import com.delivery.entity.UserEntity;
import com.delivery.repository.UserRepository;
import com.delivery.security.impl.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =  userRepository.findByUserNameOrPhone(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with account: " + username));
        return UserDetailImpl.convertUserEntityToUserDetail(user);
    }
}
