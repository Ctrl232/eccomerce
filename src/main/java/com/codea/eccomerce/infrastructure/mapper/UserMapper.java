package com.codea.eccomerce.infrastructure.mapper;

import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings(

            {
                @Mapping(source = "id", target= "id"),
                    @Mapping(source = "username", target= "username"),
                    @Mapping(source = "firstName", target= "firstName"),
                    @Mapping(source = "lastName", target= "lastName"),
                    @Mapping(source = "email", target= "email"),
                    @Mapping(source = "address", target= "address"),
                    @Mapping(source = "cellphone", target= "cellphone"),
                    @Mapping(source = "password", target= "password"),
                    @Mapping(source = "userType", target= "userType"),
                    @Mapping(source = "dateCreated", target= "dateCreated")
            }
    )
    User toUser(UserEntity userEntity);
    Iterable<UserEntity> toUsers(Iterable<UserEntity> userEntities);


     @InheritInverseConfiguration
    UserEntity toUserEntity(User user);
}
