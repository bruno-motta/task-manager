package io.github.brunomotta.teamtask.repository;

import io.github.brunomotta.teamtask.entity.Users;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmail(String email);

    Page findAllByNameIsContainingIgnoreCase(String name, Pageable pageable);


}
