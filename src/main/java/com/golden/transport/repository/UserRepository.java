package com.golden.transport.repository;

import com.golden.transport.domain.UsersG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UsersG, Long> {


}
