package db;

// Class informa a mensagem de exce��o da conex�o .
public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DbException(String msg) {
		super(msg);
	}
	
}
