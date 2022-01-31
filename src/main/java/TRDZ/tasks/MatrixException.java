package TRDZ.tasks;

public class MatrixException extends Exception {
	private int x;
	private int y;
	private String result;

	public MatrixException(String message, int x, int y,String result) {
		super(message);
		this.x=x;
		this.y=y;
		this.result=result;
		}

	public int get_X() {	return x;}
	public int get_y() {	return y;}
	public String get_Result() {return result;}

	}
