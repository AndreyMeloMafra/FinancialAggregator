package com.ammdev.financialaggregator.entity;

import com.ammdev.financialaggregator.domain.user.Permission;
import lombok.Getter;

import java.util.List;

@Getter
public enum PermissionName {
    CARD_USER("card"),
    FINANCING_USER("financing"),
    LOAN_USER("loan"),
    ACCOUNT_USER("account"),
    INVESTMENT_USER("investment");

    private final String permission;

    PermissionName(String permission) {
        this.permission = permission;
    }

    public static PermissionName fromPermissionName(Permission permission) {
        for (PermissionName permissionName : PermissionName.values()) {
            if (permissionName.getPermission().equalsIgnoreCase(permission.getPermission())) {
                return permissionName;
            }
        }
        throw new IllegalArgumentException("Não existe valor válido para: " + permission + " no enum PermissionName");
    }
}
