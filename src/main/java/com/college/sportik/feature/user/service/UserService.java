package com.college.sportik.feature.user.service;

import com.college.sportik.feature.user.entity.UserEntity;
import com.college.sportik.feature.user.dto.UserDTOReceive;
import com.college.sportik.feature.user.dto.UserDTOResponse;
import com.college.sportik.feature.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerUser(UserDTOResponse userDTOResponse);

    UserDTOResponse authUser(UserDTOReceive userDTOReceive);
}

@Service
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(UserDTOResponse userDTOResponse) {
        repository.save(new UserEntity(
                userDTOResponse.getId(),
                userDTOResponse.getUsername(),
                userDTOResponse.getFirstName(),
                userDTOResponse.getLastName(),
                userDTOResponse.getPassword()
        ));
    }

    @Override
    public UserDTOResponse authUser(UserDTOReceive userDTOReceive) {
         return new UserDTOResponse(0, "1", "2", "3", "4");
    }
}
