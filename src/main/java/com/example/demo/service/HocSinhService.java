package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.modul.HocSinh;

public interface HocSinhService {

	List<HocSinh> findAll();

	HocSinh findById(Integer id);

	HocSinh create(HocSinh hocsinh);

	HocSinh update(HocSinh hocsinh);

	void delete(Integer id);

	Page<HocSinh> getPages(int page, int limit);

	Page<HocSinh> getPagesBySearch(String search, int page, int limit);

	Page<HocSinh> getPagesByName(String name, int page, int limit);

	Page<HocSinh> getPagesByLop(String name, int page, int limit);

	Page<HocSinh> getPagesByQue(String que, int page, int limit);

}
