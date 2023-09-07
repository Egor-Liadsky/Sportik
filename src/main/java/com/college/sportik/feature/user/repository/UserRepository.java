package com.college.sportik.feature.user.repository;

import com.college.sportik.feature.user.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public
interface UserRepository extends CrudRepository<UserEntity, Long> {

}
