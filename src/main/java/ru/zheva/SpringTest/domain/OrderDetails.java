package ru.zheva.SpringTest.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders_details")
public class OrderDetails {
	private static final String SEQ_NAME = "order_details_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private BigDecimal amount;
	private BigDecimal price;

}
