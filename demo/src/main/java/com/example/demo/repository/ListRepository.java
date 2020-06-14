package com.example.demo.repository;

import com.example.demo.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Long> {


}
