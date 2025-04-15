package com.ammdev.financialaggregator.config;

import com.ammdev.financialaggregator.domain.mapper.UserEntityToUserDomainMapper;
import com.ammdev.financialaggregator.domain.user.User;
import com.ammdev.financialaggregator.entity.user.UserEntity;
import com.ammdev.financialaggregator.exception.AuthenticationException;
import com.ammdev.financialaggregator.exception.UserException;
import com.ammdev.financialaggregator.repository.UserRepository;
import com.ammdev.financialaggregator.service.JwtTokenService;
import com.ammdev.financialaggregator.usecase.user.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER_PARAM = "Authorization";
    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        if (!checkIfEndpointIsNotPublic(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = recoveryToken(request);

        String subject = jwtTokenService.getSubjectFromToken(token);
        Optional<UserEntity> userEntity = userRepository.findByEmail(subject);

        UserDetailsImpl userDetails = getUserDetails(userEntity);

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private static UserDetailsImpl getUserDetails(Optional<UserEntity> userEntity) {
        if (userEntity.isEmpty()) {
            throw new UserException("Usuário não encontrado");
        }

        User user = UserEntityToUserDomainMapper.INSTANCE.map(userEntity.get());

        return new UserDetailsImpl(user);
    }

    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER_PARAM);

        if (ObjectUtils.isEmpty(authorizationHeader)) {
            throw new AuthenticationException(HttpStatus.UNAUTHORIZED.value(), "O token está ausente.");
        }

        return authorizationHeader.replace("Bearer ", "");
    }

    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return !Arrays.asList(SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).contains(requestURI);
    }

}