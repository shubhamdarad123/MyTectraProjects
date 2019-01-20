package com.mytechra.spring.playground.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Price {

	private List<UnitCharge> charges = new ArrayList<>();

	public static class UnitCharge {

		private int amount;

		private String type;

		private String desc;
		
		public UnitCharge() {
			
		}
		
		public UnitCharge(int amount, String type, String desc) {
			super();
			this.amount = amount;
			this.type = type;
			this.desc = desc;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}

	public void addUnitCharges(UnitCharge charge) {
		this.charges.add(charge);
	}

	public List<UnitCharge> getUnitCharges() {
		return charges;
	}

	public int totalPrice() {
		return charges.stream().collect(Collectors.summingInt(charge -> charge.getAmount()));
	}
}
