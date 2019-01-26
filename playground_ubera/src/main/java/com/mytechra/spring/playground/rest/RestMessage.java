package com.mytechra.spring.playground.rest;

public class RestMessage<T> {
	
	public enum Status {ERROR , SUCESSS };
	
	private Status status;
	
	private T response;
	

	public RestMessage(Status status, T response) {
		super();
		this.status = status;
		this.response = response;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
	
	
	

}
