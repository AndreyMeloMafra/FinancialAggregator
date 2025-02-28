package com.ammdev.financialaggregator.usecase.user;

import com.ammdev.financialaggregator.domain.mapper.UserEntityToUserDomainMapper;
import com.ammdev.financialaggregator.domain.user.User;
import com.ammdev.financialaggregator.entity.UserEntity;
import com.ammdev.financialaggregator.exception.UserException;
import com.ammdev.financialaggregator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username)
                .orElseThrow(() -> new UserException("Usuário não encontrado."));

        User user = UserEntityToUserDomainMapper.INSTANCE.map(userEntity);
        return new UserDetailsImpl(user);
    }
}
