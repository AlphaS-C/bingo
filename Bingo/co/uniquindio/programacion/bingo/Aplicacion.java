package co.uniquindio.programacion.bingo;
import co.uniquindio.programacion.bingo.view.VentanaBingo;

/**
 * @version 1.0

 * @author  Sonia Jaramillo Valbuena

 * Esta clase es la encargada de iniciar el sistema
 * 
 */

public class Aplicacion {

/**
 * Método principal
 * @param args argumentos enviados por el sistema operativo
 */

public static void main(String[] args) {
		VentanaBingo miVentanaBingo;
		miVentanaBingo=new VentanaBingo();
        miVentanaBingo.setVisible(true);
        miVentanaBingo.setLocationRelativeTo(null);
	}

}
