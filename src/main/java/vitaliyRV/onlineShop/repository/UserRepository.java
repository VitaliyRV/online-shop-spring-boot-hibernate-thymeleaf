package vitaliyRV.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitaliyRV.onlineShop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
