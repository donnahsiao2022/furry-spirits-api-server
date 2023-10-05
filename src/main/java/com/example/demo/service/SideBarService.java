package com.example.demo.service;

import com.example.demo.entity.BackStageSideBar;
import com.example.demo.repository.IBackStageSideBarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SideBarService {

    private final IBackStageSideBarRepository backStageSideBarRepository;

    public List<BackStageSideBar> findBackStageSideBar() {

        List<BackStageSideBar> backStageSideBarList = backStageSideBarRepository.findRootBackStageSideBar();

        backStageSideBarList.forEach(backStageSideBar -> {
            backStageSideBar.setChildSideBarList(
                    backStageSideBarRepository.findChildBackStageSideBar(backStageSideBar.getId()));
        });

        return backStageSideBarList;
    }

}
