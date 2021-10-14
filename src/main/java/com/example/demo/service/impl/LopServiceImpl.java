package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LopDAO;
import com.example.demo.modul.Lop;
import com.example.demo.service.LopService;
@Service
public class LopServiceImpl implements LopService {

	@Autowired
	LopDAO ldao;
	
	@Override
	public List<Lop> findAll() {
		
		return ldao.findAll();
	}

}
