package com.dkinc.leaderBoards.repositories;

import com.dkinc.leaderBoards.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepos extends JpaRepository<Company, Long> {

    List<Company> findByNameAndOwnerName(String name, String ownerName);
    List<Company> findById(Integer id);
    List<Company> findByCountWorkers(String countWorkers);
    List<Company> findByName(String name);
}
