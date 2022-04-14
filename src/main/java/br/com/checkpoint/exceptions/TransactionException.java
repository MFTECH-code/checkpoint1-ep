package br.com.checkpoint.exceptions;

public class TransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TransactionException() {
		super("An error ocurred during transaction...");
	}
	
	public TransactionException(String msg) {
		super(msg);
	}

}
