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
@Table(name = "stockbay_buy")
public class Buy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 105253940174394025L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "supplier_id")
	Supplier supplier;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id")
	Product product;

	String purchase_date;
	String purchase_invoiceNo;
	String purchase_status;

	public Buy() {
		// TODO Auto-generated constructor stub
	}

	public Buy(Supplier supplier, Product product_id, String purchase_date, String purchase_invoiceNo,
			String purchase_status) {
		super();
		this.supplier = supplier;
		this.product = product_id;
		this.purchase_date = purchase_date;
		this.purchase_invoiceNo = purchase_invoiceNo;
		this.purchase_status = purchase_status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getProduct_id() {
		return product;
	}

	public void setProduct_id(Product product_id) {
		this.product = product_id;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getPurchase_invoiceNo() {
		return purchase_invoiceNo;
	}

	public void setPurchase_invoiceNo(String purchase_invoiceNo) {
		this.purchase_invoiceNo = purchase_invoiceNo;
	}

	public String getPurchase_status() {
		return purchase_status;
	}

	public void setPurchase_status(String purchase_status) {
		this.purchase_status = purchase_status;
	}

}
