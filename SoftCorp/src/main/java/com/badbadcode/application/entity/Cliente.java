package com.badbadcode.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id_cliente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido_p")
	private String apellido_p;
	@Column(name = "apellido_m")
	private String apellido_m;
	@Column(name = "email")
	private String email;
	@Column(name = "empresa")
	private String empresa;
	@Column(name = "titulo_trabajo")
	private String titulo;
	@Column(name = "ciudad")
	private String ciudad;
	
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido_p() {
		return apellido_p;
	}
	public String getApellido_m() {
		return apellido_m;
	}
	public String getEmail() {
		return email;
	}
	public String getEmpresa() {
		return empresa;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido_p(String apellido_p) {
		this.apellido_p = apellido_p;
	}
	public void setApellido_m(String apellido_m) {
		this.apellido_m = apellido_m;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
