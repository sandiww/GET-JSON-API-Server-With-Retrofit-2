package com.codewith.sandisuryadi.getretrofit.model;

import java.util.List;

public class ResponseDosen{
	private List<SemuadosenItem> semuadosen;
	private boolean error;
	private String message;

	public void setSemuadosen(List<SemuadosenItem> semuadosen){
		this.semuadosen = semuadosen;
	}

	public List<SemuadosenItem> getSemuadosen(){
		return semuadosen;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDosen{" + 
			"semuadosen = '" + semuadosen + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}