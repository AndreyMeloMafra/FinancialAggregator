package com.ammdev.financialaggregator.domain.dto;

import com.ammdev.financialaggregator.domain.user.Permission;

import java.util.List;

public record CreateUserDto(

        String email,
        String password,
        List<Permission> permissions

) {
}
