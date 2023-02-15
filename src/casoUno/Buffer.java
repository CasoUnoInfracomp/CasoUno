package casoUno;


import java.util.ArrayList; 
public class Buffer {
    private ArrayList buff = new ArrayList <Producto>() ;
    private int n ;

    public Buffer (int n) {
       this.n = n ;
       buff = new ArrayList <Producto>(n) ;
    }


    public void almacenar (Producto i) {
    	buff.add (i) ;
    }
    
    
    public Producto retirar (String colorrr) {
    	for(int x = 0; x<buff.size();x++) {
    		if(((Producto) buff.get(x)).getColor().equals(colorrr)) {
    			Producto palreturn = (Producto) buff.get(x);
    			buff.remove(x);
    			return palreturn;
    		}
    	}
    	return null;
        
    }

	public boolean puedoAlmacenar() {
		boolean centinela = true;
		if(buff.size() == n) {
			centinela = false;
		}
		return centinela;
	}
	public boolean puedoRetirar(String colorr) {
		boolean centinela = true;
		if(buff.size() == 0) {
			centinela = false;
		}
		if(centinela)
		{
			for(int x = 0; x<buff.size();x++) {
	    		if(((Producto) buff.get(x)).getColor().equals(colorr)) {
	    			return true;
	    		}
	    	}
		}
		centinela = false;
		return centinela;
	}


}