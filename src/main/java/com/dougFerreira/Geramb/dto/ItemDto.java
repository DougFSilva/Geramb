package com.dougFerreira.Geramb.dto;

import com.dougFerreira.Geramb.models.Item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDto {

	private Long id;
	
	private String cabinet;
	
	private String name;
	
	private Integer quantity;
	
	public ItemDto(Item item) {
		this.id = item.getId();
		this.cabinet = item.getCabinet().getName();
		this.name = item.getName();
		this.quantity = item.getQuantity();
	}
	
}
