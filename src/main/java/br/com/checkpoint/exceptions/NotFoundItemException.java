package br.com.checkpoint.exceptions;

public class NotFoundItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotFoundItemException() {
		super("Item not found in database...");
	}
	
	public NotFoundItemException(String msg) {
		super(msg);
	}

}
