package casoUno;

public class ProcesoDos extends Thread{
	  private int aConsumir;
	  private int aAlmacenar;
	  private int almacenados = 0;
	  private int consumidos = 0;
	  private Buffer theBufferIn;
	  private Buffer theBufferOut;
	  private Producto i;
	  //private int myId;
	  private String color;
	  
	  public ProcesoDos (int ii, Buffer bufferin, Buffer bufferout, String colorr) {
		this.aConsumir = ii;
		this.aAlmacenar = ii;
		this.theBufferIn = bufferin;
		this.theBufferOut = bufferout;
		this.color = colorr;
		this.i = null;
		//myId = id;
	  }
	  
	  public void run() {
		  while(almacenados<aAlmacenar) {
		  retirar();
		  procesar();
		  almacenar();
		  try {
	            // Esperamos entre 0 y 4 segundos 
	            sleep((int) (Math.random() * 500));
	        } catch (InterruptedException e) { }
		  }
	  }
	  public synchronized void almacenar() {
		  
		  
			  if(color.equals("AZUL")) {
			      	while (!theBufferOut.puedoAlmacenar()) { 
			          	try {
			                 wait() ;
			          	} 
			          catch (InterruptedException e) {
			          	
			          }
			      	}
			        theBufferOut.almacenar(i) ;
			        almacenados++;
			        i=null;
					//System.out.println("ALMACENO ALGO");
			        notify () ;
			      }
			      else {
			      	while (!theBufferOut.puedoAlmacenar()) 
			      	{
			      		Thread.yield();
			      	}
			      	//System.out.println("ALMACENO ALGO");
			      	theBufferOut.almacenar(i) ;
			        almacenados++;
			        i=null;
			        notify () ;
			      }
		  
	}


	private synchronized void procesar() {
		String transformador = i.getElstring() + "PASE POR EL PROCESO DOS: "+color;
		i.setElstring(transformador);
		System.out.println(i.getElstring());
		
	}

	public synchronized void retirar()
	  {
		if(color.equals("AZUL")) {
        	while (!theBufferIn.puedoRetirar("AZUL")) { 
            	try {
                    wait();
             	} 
             catch (InterruptedException e) {
             	
             }
        	}
            i = theBufferIn.retirar("AZUL") ;
            //consumidos++;
            notify () ;
        }
        else {
        	while (!theBufferIn.puedoRetirar("NARANJA")) 
        	{
        		Thread.yield();
        	}
        	i = theBufferIn.retirar("NARANJA") ;
        	//consumidos++;
            notify () ;
        }
		

	  }
	

}
