package com.college.sportik.feature.user.service;

import com.college.sportik.feature.user.entity.UserEntity;
import com.college.sportik.feature.user.models.UserModelDTOReceive;
import com.college.sportik.feature.user.models.UserModelDTOResponse;
import com.college.sportik.feature.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
interface UserService {

    void registerUser(UserModelDTOResponse userModelDTOResponse);

    UserModelDTOResponse authUser(UserModelDTOReceive userModelDTOReceive);
}

@Service
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(UserModelDTOResponse userModelDTOResponse) {
        repository.save(new UserEntity(
                userModelDTOResponse.getId(),
                userModelDTOResponse.getUsername(),
                userModelDTOResponse.getFirstName(),
                userModelDTOResponse.getLastName(),
                userModelDTOResponse.getPassword()
        ));
    }

    @Override
    public UserModelDTOResponse authUser(UserModelDTOReceive userModelDTOReceive) {
         return new UserModelDTOResponse(0, "1", "2", "3", "4");
    }
}
