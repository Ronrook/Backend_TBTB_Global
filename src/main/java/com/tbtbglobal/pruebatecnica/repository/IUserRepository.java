package com.tbtbglobal.pruebatecnica.repository;

import com.tbtbglobal.pruebatecnica.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
