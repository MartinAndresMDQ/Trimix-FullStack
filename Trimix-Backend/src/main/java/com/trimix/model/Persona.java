package com.trimix.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("perId")
	private Long perId;

	@Column(name = "perFechaNacimiento", columnDefinition = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("perFechaNacimiento")
	private Date perFechaNacimiento;

	@Column(name = "perApellido")
	@JsonProperty("perApellido")
	private String perApellido;

	@Column(name = "perNombre")
	@JsonProperty("perNombre")
	private String perNombre;

	@Column(name = "perNumeroDocumento")
	@JsonProperty("perNumeroDocumento")
	private Long perNumeroDocumento;

	@Column(name = "perTipoDocumento")
	@JsonProperty("perTipoDocumento")
	private String perTipoDocumento;

	public Persona() {
		super();
	}

	public Persona(@JsonProperty("perId") Long perId, @JsonProperty("perFechaNacimiento") Date perFechaNacimiento,
			@JsonProperty("perApellido") String perApellido, @JsonProperty("perNombre") String perNombre,
			@JsonProperty("perNumeroDocumento") Long perNumeroDocumento,
			@JsonProperty("perTipoDocumento") String perTipoDocumento) {
		super();
		this.perId = perId;
		this.perFechaNacimiento = perFechaNacimiento;
		this.perApellido = perApellido;
		this.perNombre = perNombre;
		this.perNumeroDocumento = perNumeroDocumento;
		this.perTipoDocumento = perTipoDocumento;
	}

	@JsonIgnore
	public Long getPerId() {
		return perId;
	}

	@JsonIgnore
	public void setPerId(Long perId) {
		this.perId = perId;
	}

	@JsonIgnore
	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	@JsonIgnore
	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	@JsonIgnore
	public String getPerApellido() {
		return perApellido;
	}

	@JsonIgnore
	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	@JsonIgnore
	public String getPerNombre() {
		return perNombre;
	}

	@JsonIgnore
	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	@JsonIgnore
	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}

	@JsonIgnore
	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}

	@JsonIgnore
	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}

	@JsonIgnore
	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}

	@Override
	public String toString() {
		return "Persona [perId=" + perId + ", perFechaNacimiento=" + perFechaNacimiento + ", perApellido=" + perApellido
				+ ", perNombre=" + perNombre + ", perNumeroDocumento=" + perNumeroDocumento + ", perTipoDocumento="
				+ perTipoDocumento + "]";
	}

}
