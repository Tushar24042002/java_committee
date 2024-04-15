package com.committee.demo.Entity.EmailTemplate;

import jakarta.persistence.*;

@Entity
@Table(name = "email_template")
public class EmailTemplate {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_email_template"
    )
    private Long id;

    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
