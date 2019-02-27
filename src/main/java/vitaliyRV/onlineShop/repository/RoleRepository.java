package vitaliyRV.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitaliyRV.onlineShop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
