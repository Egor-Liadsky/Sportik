package com.college.sportik.feature.user.service;

import com.college.sportik.feature.user.entity.UserEntity;
import com.college.sportik.feature.user.dto.UserDTOReceive;
import com.college.sportik.feature.user.dto.UserDTOResponse;
import com.college.sportik.feature.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerUser(UserDTOResponse userDTOResponse);

    Object authUser(UserDTOReceive userDTOReceive);
}

@Service
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(UserDTOResponse userDTOResponse) {
        if (repository.findByUsername(userDTOResponse.getUsername()) == null) {
            repository.save(new UserEntity(
                    userDTOResponse.getId(),
                    userDTOResponse.getUsername(),
                    userDTOResponse.getFirstName(),
                    userDTOResponse.getLastName(),
                    userDTOResponse.getPassword()
            ));
        } else {
            throw new RuntimeException("user already exist");
        }
    }

    @Override
    public UserDTOResponse authUser(UserDTOReceive userDTOReceive) {
        UserDTOResponse user = repository.findByUsername(userDTOReceive.getUsername());
        if (user != null && user.getPassword().equals(userDTOReceive.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("invalid username or password");
        }
    }
}
