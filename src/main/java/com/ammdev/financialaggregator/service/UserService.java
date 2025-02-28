package com.ammdev.financialaggregator.service;

import com.ammdev.financialaggregator.config.SecurityConfiguration;
import com.ammdev.financialaggregator.domain.dto.CreateUserDto;
import com.ammdev.financialaggregator.domain.dto.LoginUserDto;
import com.ammdev.financialaggregator.domain.dto.RecoveryJwtTokenDto;
import com.ammdev.financialaggregator.domain.user.Permission;
import com.ammdev.financialaggregator.entity.PermissionEntity;
import com.ammdev.financialaggregator.entity.PermissionName;
import com.ammdev.financialaggregator.entity.UserEntity;
import com.ammdev.financialaggregator.repository.UserRepository;
import com.ammdev.financialaggregator.usecase.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    public void createUser(CreateUserDto createUserDto) {
        List<PermissionEntity> permissionEntityList = createPermissionEntities(createUserDto.permissions());
        UserEntity newUser = UserEntity.builder()
                .email(createUserDto.email())
                .password(getEncodedPassword(createUserDto))
                .permissions(permissionEntityList)
                .build();

        userRepository.save(newUser);
    }

    private List<PermissionEntity> createPermissionEntities(List<Permission> permissions) {
        return permissions.stream()
                .map(permission -> PermissionEntity.builder()
                        .permissionName(PermissionName.fromPermissionName(permission))
                        .build())
                .collect(Collectors.toList());
    }

    private String getEncodedPassword(CreateUserDto createUserDto) {
        return securityConfiguration.passwordEncoder().encode(createUserDto.password());
    }
}
