package com.college.sportik.feature.user.service;

import com.college.sportik.feature.user.dto.UserDTOReceive;
import com.college.sportik.feature.user.dto.UserDTOResponse;
import com.college.sportik.feature.user.entity.UserEntity;
import com.college.sportik.feature.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTOResponse registerUser(UserDTOResponse userDTOResponse) {
        if (repository.findByUsername(userDTOResponse.getUsername()) == null) {
            repository.save(new UserEntity(
                    userDTOResponse.getId(),
                    userDTOResponse.getUsername(),
                    userDTOResponse.getFirstName(),
                    userDTOResponse.getLastName(),
                    userDTOResponse.getRole(),
                    userDTOResponse.getPassword()
            ));
            return repository.findByUsername(userDTOResponse.getUsername());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
    }

    @Override
    public UserDTOResponse authUser(UserDTOReceive userDTOReceive) {
        UserDTOResponse user = repository.findByUsername(userDTOReceive.getUsername());
        if (user != null && user.getPassword().equals(userDTOReceive.getPassword())) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Invalid username or password");
        }
    }

    @Override
    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User with id " + id + " deleted";
    }
}
