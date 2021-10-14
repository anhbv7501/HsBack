package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modul.HocSinh;

public interface HocSinhDAO extends JpaRepository<HocSinh, Integer>{

	
	@Query("SELECT DISTINCT hs FROM HocSinh hs WHERE (hs.name LIKE %:search%) OR (hs.lop.ten LIKE %:search%) OR (hs.queQuan LIKE %:search%)")
	Page<HocSinh> findAllBySearch(@Param("search") String search,Pageable page);
	
	@Query("SELECT DISTINCT hs FROM HocSinh hs WHERE (hs.name LIKE %:name%)")
	Page<HocSinh> findAllByName(@Param("name")String name, Pageable page);

	@Query("SELECT DISTINCT hs FROM HocSinh hs WHERE (hs.lop.ten LIKE %:lop%)")
	Page<HocSinh> findAllByLop(@Param("lop")String lop, Pageable page);

	@Query("SELECT DISTINCT hs FROM HocSinh hs WHERE (hs.queQuan LIKE %:que%)")
	Page<HocSinh> findAllByQue(@Param("que")String que, Pageable page);

//	@Override
//	Page<HocSinh> findAll(Pageable page);
}
