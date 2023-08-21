package com.dougFerreira.Geramb.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class StandartException {

	private long timestamp;

	private Integer status;

	private String error;
}
