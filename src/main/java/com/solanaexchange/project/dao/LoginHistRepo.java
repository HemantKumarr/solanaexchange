package com.solanaexchange.project.dao;

import com.solanaexchange.project.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistRepo extends JpaRepository<LoginHistory,String> {
}
