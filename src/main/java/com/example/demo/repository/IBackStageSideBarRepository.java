package com.example.demo.repository;

import com.example.demo.entity.BackStageSideBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBackStageSideBarRepository extends JpaRepository<BackStageSideBar, Integer> {

    @Query("from BackStageSideBar where parentId = 0 and isDisplay = true order by seq")
    List<BackStageSideBar> findRootBackStageSideBar();

    @Query("from BackStageSideBar where parentId = :parentId and isDisplay = true order by seq")
    List<BackStageSideBar> findChildBackStageSideBar(@Param("parentId") int parentId);
}
