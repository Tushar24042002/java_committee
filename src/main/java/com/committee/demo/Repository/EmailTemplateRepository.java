package com.committee.demo.Repository;

import com.committee.demo.Entity.EmailTemplate.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate,Long> {
}
