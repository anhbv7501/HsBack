package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HocSinhDAO;
import com.example.demo.modul.HocSinh;
import com.example.demo.service.HocSinhService;

@Service
public class HocSinhServiceImpl implements HocSinhService{

	@Autowired
	HocSinhDAO hsdao;
	
	@Override
	public List<HocSinh> findAll() {
		return hsdao.findAll();
		
	}

	@Override
	public HocSinh findById(Integer id) {
		return hsdao.findById(id).get();
	}

	@Override
	public HocSinh create(HocSinh hocsinh) {
		
		return hsdao.save(hocsinh);
	}

	@Override
	public HocSinh update(HocSinh hocsinh) {
		
		return hsdao.save(hocsinh);
	}

	@Override
	public void delete(Integer id) {
		 hsdao.deleteById(id);
	}

	@Override
	public Page<HocSinh> getPages(int page, int limit) {
		Pageable pageHS = PageRequest.of(page,limit);
		return hsdao.findAll(PageRequest.of(page, limit));
	}

	@Override
	public Page<HocSinh> getPagesBySearch(String search, int page, int limit) {
		Pageable pageHS = PageRequest.of(page,limit);
		return hsdao.findAllBySearch(search,PageRequest.of(page, limit));
	}

	@Override
	public Page<HocSinh> getPagesByName(String name, int page, int limit) {
		Pageable pageHS = PageRequest.of(page,limit);
		return hsdao.findAllByName(name,PageRequest.of(page, limit));
	}

	@Override
	public Page<HocSinh> getPagesByLop(String lop, int page, int limit) {
		Pageable pageHS = PageRequest.of(page,limit);
		return hsdao.findAllByLop(lop,PageRequest.of(page, limit));
	}

	@Override
	public Page<HocSinh> getPagesByQue(String que, int page, int limit) {
		Pageable pageHS = PageRequest.of(page,limit);
		return hsdao.findAllByQue(que,PageRequest.of(page, limit));
	}

}
