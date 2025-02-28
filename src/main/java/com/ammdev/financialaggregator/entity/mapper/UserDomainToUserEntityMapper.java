package com.ammdev.financialaggregator.entity.mapper;

import com.ammdev.financialaggregator.domain.user.User;
import com.ammdev.financialaggregator.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDomainToUserEntityMapper {

    UserDomainToUserEntityMapper INSTANCE = Mappers.getMapper(UserDomainToUserEntityMapper.class);

    UserEntity map(User userEntity);
}
