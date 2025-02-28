package com.ammdev.financialaggregator.domain.user;

import com.ammdev.financialaggregator.entity.PermissionEntity;
import lombok.Getter;

@Getter
public enum Permission {
    CARD_USER("card"),
    FINANCING_USER("financing"),
    LOAN_USER("loan"),
    ACCOUNT_USER("account"),
    INVESTMENT_USER("investment");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public static Permission fromPermissionEntity(PermissionEntity permissionEntity) {
        for (Permission permission : Permission.values()) {
            if (permission.getPermission().equalsIgnoreCase(permissionEntity.getPermissionName().getPermission())) {
                return permission;
            }
        }
        throw new IllegalArgumentException("Não existe valor válido para: " + permissionEntity + " no enum Permission");
    }
}
