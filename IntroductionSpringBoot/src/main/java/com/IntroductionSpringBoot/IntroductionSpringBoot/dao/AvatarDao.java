package com.IntroductionSpringBoot.IntroductionSpringBoot.dao;

import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface AvatarDao extends JpaRepository<Avatar,Integer> {
    Avatar findById(int id);

//    void delete(int id);
}

