package casoUno;

public class Producto {
	private String elstring;
	private static Numero numm = new Numero ();
	private int paproducto;
	private String color;
	public Producto (String colorr) {
		this.paproducto = numm.dar();
		this.elstring = "Este es el producto" + Integer.toString(this.paproducto);
		this.color = colorr;
		
				

	  }
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getElstring() {
		return elstring;
	}
	public void setElstring(String elstring) {
		this.elstring = elstring;
	}
	public int getPaproducto() {
		return paproducto;
	}
	public void setPaproducto(int paproducto) {
		this.paproducto = paproducto;
	}

}
