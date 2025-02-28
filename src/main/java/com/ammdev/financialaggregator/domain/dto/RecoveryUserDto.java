package com.ammdev.financialaggregator.domain.dto;

import com.ammdev.financialaggregator.domain.user.Permission;

import java.util.List;

public record RecoveryUserDto(
        Long id,
        String email,
        List<Permission> permissions
) {
}
