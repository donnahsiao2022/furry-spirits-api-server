package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "back_stage_side_bar")
public class BackStageSideBar {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "seq")
    private int seq;

    @Column(name = "is_display")
    private boolean isDisplay;

    @Transient
    private List<BackStageSideBar> childSideBarList;

}
