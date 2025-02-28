package com.ammdev.financialaggregator.domain.user;

import lombok.Builder;

import java.util.List;

@Builder
public record User(String email, String password, List<Permission> permissions) {

}
