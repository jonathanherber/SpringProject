package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entities.enums.OrdersStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orders implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone="GMT")
	private Instant moment; 
	
	private Integer ordersStatus;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Users client;
	
	
	public Orders() {
		
	}

	public Orders(Long id, Instant moment, OrdersStatus ordersStatus, Users client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrdersStatus(ordersStatus);
		this.client = client;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrdersStatus getOrdersStatus() {
		return OrdersStatus.valueOf(ordersStatus);
	}

	public void setOrdersStatus(OrdersStatus ordersStatus) {
		if (ordersStatus != null) {
			this.ordersStatus = ordersStatus.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", moment=" + moment + "]";
	}
	
	
}
