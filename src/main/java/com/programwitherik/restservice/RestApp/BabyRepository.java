package com.programwitherik.restservice.RestApp;

import com.programwitherik.restservice.RestApp.Domain.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BabyRepository extends JpaRepository<Baby, Integer> {
    /**
     * Search by age, which means there would be multiple results.
     * The method name must be findByXxxxx, so that the system would search by specific column.
     * NOTE: if no specific, the original find method finds by primary key, which in this case is id.
     * @return
     */
    public List<Baby> findByAge(int age);
}
