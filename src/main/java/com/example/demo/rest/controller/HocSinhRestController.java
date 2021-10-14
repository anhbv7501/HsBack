package com.example.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modul.HocSinh;
import com.example.demo.service.HocSinhService;

import ch.qos.logback.core.net.SyslogOutputStream;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/hocsinh")
public class HocSinhRestController {

	@Autowired
	HocSinhService hsService;

	@GetMapping("/getAll")
	public List<HocSinh> getAll() {
		return hsService.findAll();
	}

	@GetMapping("{id}")
	public HocSinh getOne(@PathVariable("id") Integer id) {
		return hsService.findById(id);
	}

	@PostMapping()
	public HocSinh create(@RequestBody HocSinh hocsinh) {
		System.out.println(hocsinh);
		return hsService.create(hocsinh);
	}

	@PutMapping("{id}")
	public HocSinh update(@PathVariable("id") Integer id, @RequestBody HocSinh hocsinh) {
		return hsService.update(hocsinh);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		hsService.delete(id);
	}

	@GetMapping("/page")
	public Page<HocSinh> getPage(@RequestParam(name = "pg", defaultValue = "0") int page,
			@RequestParam(name = "lm") int limit) {

		if (page < 0)
			page = 1;
		Page<HocSinh> pageHS = hsService.getPages(page - 1, limit);
		if (pageHS.getTotalPages() < page) {
			pageHS = hsService.getPages(pageHS.getTotalPages() - 1, limit);
		}

		return pageHS;
	}

	@GetMapping("/testpage")
	public Page<HocSinh> getPage(@RequestParam(name = "pg", defaultValue = "0") int page,
			@RequestParam(name = "lm") int limit, 
			@RequestParam(name = "search", required = false) String search) {
		Page<HocSinh> pageHS =null;
		if(search == null) {
		if (page < 0)
			page = 1;
		pageHS = hsService.getPages(page - 1, limit);
		if (pageHS.getTotalPages() < page) {
			pageHS = hsService.getPages(pageHS.getTotalPages() - 1, limit);
		}
		}else {
			 pageHS = hsService.getPagesBySearch(search,page,limit);
			
			if(pageHS.getTotalPages() < page) {
				pageHS = hsService.getPagesBySearch(search,pageHS.getTotalPages(),limit);
			}
		}

		return pageHS;
	}
	@GetMapping("/search")
	public Page<HocSinh> getPage(@RequestParam(name = "pg", defaultValue = "0") int page,
								 @RequestParam(name = "lm") int limit,
								 @RequestParam(name = "name", required = false) String name,
								 @RequestParam(name="lop",required = false) String lop,
								 @RequestParam(name="que",required = false) String que){
		Page<HocSinh> pageHS = null;
		if (page < 0) page = 1;
		if(name != null) {
		pageHS = hsService.getPagesByName (name,page - 1, limit);
		
		if (pageHS.getTotalPages() < page) 
			pageHS = hsService.getPagesByName(name,pageHS.getTotalPages() - 1, limit);
		
		}else if(lop != null){
			 pageHS = hsService.getPagesByLop(lop,page-1,limit);
			
			if(pageHS.getTotalPages() < page) 
				pageHS = hsService.getPagesByLop(name,pageHS.getTotalPages() - 1,limit);
		}else if(que != null) {
			pageHS = hsService.getPagesByQue(que,page-1,limit);
			if(pageHS.getTotalPages() < page) 
				pageHS = hsService.getPagesByQue(que,pageHS.getTotalPages() - 1,limit);
		}else {
			pageHS = hsService.getPages(page - 1, limit);
			if (pageHS.getTotalPages() < page) {
				pageHS = hsService.getPages(pageHS.getTotalPages() - 1, limit);
			}
		}

		return pageHS;
	}

}
