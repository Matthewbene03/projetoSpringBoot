package com.matthews.projetoCourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.matthews.projetoCourse.entidades.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
