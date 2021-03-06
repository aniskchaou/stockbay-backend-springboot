package dev.delta.stockbay.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stockbay_sell")
public class Sell implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4497992680923909136L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id")
	Client customer_id;

	String sale_date;
	String sale_status;
	String sale_invoiceNo;

	public Sell() {
		// TODO Auto-generated constructor stub
	}

	public Sell(Client customer_id, String sale_date, String sale_status, String sale_invoiceNo) {
		super();
		this.customer_id = customer_id;
		this.sale_date = sale_date;
		this.sale_status = sale_status;
		this.sale_invoiceNo = sale_invoiceNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Client customer_id) {
		this.customer_id = customer_id;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public String getSale_status() {
		return sale_status;
	}

	public void setSale_status(String sale_status) {
		this.sale_status = sale_status;
	}

	public String getSale_invoiceNo() {
		return sale_invoiceNo;
	}

	public void setSale_invoiceNo(String sale_invoiceNo) {
		this.sale_invoiceNo = sale_invoiceNo;
	}

}
