package casoUno;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
        Buffer bufferUno = new Buffer(1000) ;
        Buffer bufferDos = new Buffer(1000) ;

        Scanner myObj = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de procesos de etapa 1");
        int numprocesos = Integer.parseInt(myObj.nextLine());
        
        Scanner myObj1 = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de producidos POR PROCESO");
        int numpros = Integer.parseInt(myObj.nextLine());
        
        
        for(int i = 1; i<numprocesos; i++)
        {
        	ProcesoUno p1Azul = new ProcesoUno (numpros, bufferUno, "AZUL");
            p1Azul.start () ; 
            ProcesoDos p2Azul = new ProcesoDos (numpros, bufferUno, bufferDos, "AZUL");
            p2Azul.start () ;
        	
        }
        ProcesoUno p1Naranja = new ProcesoUno (numpros, bufferUno, "NARANJA");
        p1Naranja.start () ; 
        ProcesoDos p2Naranja = new ProcesoDos (numpros, bufferUno, bufferDos, "NARANJA");
        p2Naranja.start () ;
    }

}
