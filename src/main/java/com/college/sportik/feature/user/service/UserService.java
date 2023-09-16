package com.college.sportik.feature.user.service;

import com.college.sportik.feature.user.dto.UserDTOReceive;
import com.college.sportik.feature.user.dto.UserDTOResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTOResponse registerUser(UserDTOResponse userDTOResponse);

    UserDTOResponse authUser(UserDTOReceive userDTOReceive);

    String deleteUser(Long id);
}
