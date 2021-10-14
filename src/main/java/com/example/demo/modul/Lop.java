package com.example.demo.modul;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Lop")
public class Lop {

	@Id
	@Column(name="LopID")
	Integer id;
	
	@Column(name="TenLop")
	String ten;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lop")
	List<HocSinh> hocsinh;
	
}
