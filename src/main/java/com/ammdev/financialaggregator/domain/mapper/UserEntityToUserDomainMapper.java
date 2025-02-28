package com.ammdev.financialaggregator.domain.mapper;

import com.ammdev.financialaggregator.domain.user.Permission;
import com.ammdev.financialaggregator.domain.user.User;
import com.ammdev.financialaggregator.entity.PermissionEntity;
import com.ammdev.financialaggregator.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserEntityToUserDomainMapper {

    UserEntityToUserDomainMapper INSTANCE = Mappers.getMapper(UserEntityToUserDomainMapper.class);

    @Mapping(source = "permissions", target = "permissions", qualifiedByName = "stringToPermission")
    User map(UserEntity userEntity);

    @Named("stringToPermission")
    default List<Permission> stringToPermission(List<PermissionEntity> permissionEntityList) {
        return permissionEntityList.stream().map(Permission::fromPermissionEntity).toList();
    }
}
