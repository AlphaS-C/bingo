package co.uniquindio.programacion.bingo.view;

import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @created Nov-2006
 * @author  Julián Esteban Gutiérrez Posada
 *
 * Esta clase Dialogo tiene como responsabilidad brindar la funcionalidad a los
 * otros tipos de dialogos.
 */
 
public abstract class Dialogo 
{
	private String tituloDialogo;
	private int    tipoDialogo;
	private String mensaje;


	/**
	 * Método constructor de la clase Dialogo, su responsabilidad es inicializar
	 * los atributos de la clase.
	 *
	 * @param String tituloDialogo, titulo para el dialogo.
	 * @param int    tipoDialogo,   tipo del dialogo (constantes de JOptionPane).
	 * @param String mensaje,       mensaje que se desea imprimir en el dialogo.
	 */
	public Dialogo( String tituloDialogo, int tipoDialogo, String mensaje )
	{
		this.tituloDialogo = tituloDialogo;
		this.tipoDialogo   = tipoDialogo;
		this.mensaje       = mensaje;
	}


	/**
	 * El método mostrarMensaje, tiene como responsabilidad mostrar el mensaje
	 * en el dialogo respectivo.
	 */
	protected void mostrarMensaje()
	{
		JOptionPane.showMessageDialog ( null, mensaje, tituloDialogo,tipoDialogo );
	}


	/**
	 * El método mostrarMensaje, tiene como responsabilidad mostrar el mensaje
	 * en el dialogo respectivo.
	 *
	 * @param int botones, parametro para especificar que botones se desea mostrar.
	 */
	protected int mostrarMensaje( int botones )
	{
		return JOptionPane.showConfirmDialog ( null, mensaje, tituloDialogo, tipoDialogo, botones );
	}


	/* 
	 * Este método no se requiere en Java pues la clase JOptionPane
	 * realiza esta labor automáticamente.	
	 *
	 * public cerrarDialogo()
	 * {
	 * }
	 *
	 */	
}

