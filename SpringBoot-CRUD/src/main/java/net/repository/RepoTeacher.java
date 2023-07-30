package net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.entity.Teacher;

@Repository
public interface RepoTeacher extends JpaRepository<Teacher, Integer> {
    Teacher findByName(String name);
    Teacher findByaddress(String address);
}

