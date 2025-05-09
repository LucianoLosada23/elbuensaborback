package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SubCategoryProductChildren;

@Repository
public interface SubCategoryProductChildrenRepository extends JpaRepository<SubCategoryProductChildren, Integer> {
}
