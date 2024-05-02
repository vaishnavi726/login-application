package com.angular.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	public User findByUserName(String userName);
	

}
