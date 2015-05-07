package sc.exceptions;

public class InternalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2227403039611981056L;
	
	public InternalException(String msg){
		super(msg);
	}
	public InternalException(String msg, Throwable e){
		super(msg,e);
	}


}
