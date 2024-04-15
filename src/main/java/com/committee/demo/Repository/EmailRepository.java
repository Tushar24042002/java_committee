package com.committee.demo.Repository;
import com.committee.demo.Entity.Email.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
