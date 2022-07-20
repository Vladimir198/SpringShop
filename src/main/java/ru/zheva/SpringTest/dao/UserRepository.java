package ru.zheva.SpringTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zheva.SpringTest.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findFirstByName(String name);

}
