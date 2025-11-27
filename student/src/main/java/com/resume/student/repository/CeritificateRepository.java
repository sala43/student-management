package com.resume.student.repository;

import com.resume.student.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CeritificateRepository extends JpaRepository<Certificate,Long> {
}
