package com.college.sportik.feature.user.repository;

import com.college.sportik.feature.user.dto.UserDTOResponse;
import com.college.sportik.feature.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserDTOResponse findByUsername(String username);
}
