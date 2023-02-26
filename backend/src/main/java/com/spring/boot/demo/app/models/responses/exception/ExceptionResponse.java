package com.spring.boot.demo.app.models.responses.exception;

import com.spring.boot.demo.app.models.responses.IResponse;

import java.util.Date;

public class ExceptionResponse implements IResponse
{
	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details)
	{
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp()
	{
		return timestamp;
	}

	public String getMessage()
	{
		return message;
	}

	public String getDetails()
	{
		return details;
	}

}
