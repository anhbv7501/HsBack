package com.example.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modul.Lop;
import com.example.demo.service.LopService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/lop")
public class LopRestController {

	@Autowired
	LopService lopService;
	
	@GetMapping("/getAll")
	public List<Lop> getAll(){
		return lopService.findAll();
	}
}
