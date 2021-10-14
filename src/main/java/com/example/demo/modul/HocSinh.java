package com.example.demo.modul;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="HocSinh")
public class HocSinh {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HocsinhID")
	Integer id;
	
	@Column(name="Ten")
	String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="NgaySinh")
	Date ngaySinh;
	
	@Column(name="QueQuan")
	String queQuan;
	
	@ManyToOne
	@JoinColumn(name="LopID")
	Lop lop;
	
	
	
}
