package com.sp.sb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sp.sb.model.User;

public interface UserService extends JpaRepository<User,Long>{

}
