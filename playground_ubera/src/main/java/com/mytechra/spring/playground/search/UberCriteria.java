package com.mytechra.spring.playground.search;

import java.util.Arrays;

public class UberCriteria {
	
	private String key;
	
	private String value;
	
	private UberCriteria() {
	}
	
	public static UberCriteria build(final String str) {
		Opertation opCode = Arrays.stream(Opertation.values())
		.filter(op -> str.contains(op.opCode))
		.findFirst()
		.get();
		
		String[] values = str.split(opCode.opCode);
		UberCriteria criteria = new UberCriteria();
		criteria.key = values[0];
		criteria.value = values[1];
		criteria.op = opCode;
		return criteria;
	}
	
	public enum Opertation {
		EQ(":eq:"),NEQ(":neq:");
	
		private String opCode;
		
		private Opertation(String opCode) {
			this.opCode = opCode;
		}
		
		public String getOpCode() {
			return opCode;
		}
		
	}
	
	private Opertation op;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Opertation getOp() {
		return op;
	}

	public void setOp(Opertation op) {
		this.op = op;
	}

	@Override
	public String toString() {
		return "UberCriteria [key=" + key + ", value=" + value + ", op=" + op + "]";
	}
	
	
	

}
