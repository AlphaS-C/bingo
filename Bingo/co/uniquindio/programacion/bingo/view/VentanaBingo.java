package co.uniquindio.programacion.bingo.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import co.uniquindio.programacion.bingo.model.Bingo;

/**
 * @version 1.0
 * @author  Sonia Jaramillo Valbuena
 * Esta clase es la encargada de manejar la interaccion con el usuario
 * 
 */

public class VentanaBingo extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private Bingo miBingo;

	//Se crean los elementos del men�
	private JMenuBar barraMenuPrincipal;
	/*Estos son los tres men�s que salen en la barra de menu*/
	private JMenu subMenuTablero;
	private JMenu subMenuAyuda;
	private JMenuItem jMenuItemCreaTableros;
	private JMenuItem jMenuItemMuestraTablero;
	private JMenuItem jMenuItemVende;
	private JMenuItem jMenuItemRegala;
	private JMenuItem jMenuItemAyuda;

	private JLabel titulo;
	
/**
 * M�todo constructor de la clase Bingo
 *
 */
public VentanaBingo()
	{
	getContentPane();
	setLayout(null);
	titulo=new JLabel ("Bingo");
	barraMenuPrincipal=new JMenuBar ();
	/*Estos son los tres men�s que salen en la barra de menu*/

	subMenuTablero=new JMenu ();
	subMenuAyuda=new JMenu ();
	jMenuItemCreaTableros=new JMenuItem ();
	jMenuItemMuestraTablero=new JMenuItem ();
	jMenuItemVende=new JMenuItem ();
	jMenuItemRegala = new JMenuItem ();
	jMenuItemAyuda=new JMenuItem ();
	subMenuTablero.setText("Tablero");
	subMenuAyuda.setText("Ayuda");
	jMenuItemCreaTableros.setText("Crear todos los tableros");
	jMenuItemMuestraTablero.setText("Muestra Tablero");
	jMenuItemVende.setText("Vender un tablero");
	jMenuItemRegala.setText("Regala un tablero");
	jMenuItemAyuda.setText("fdsfdsf");
	barraMenuPrincipal.add(subMenuTablero);
	barraMenuPrincipal.add(subMenuAyuda);
	subMenuTablero.add(jMenuItemCreaTableros);
	subMenuTablero.add(jMenuItemMuestraTablero);
	subMenuTablero.add(jMenuItemVende);
	subMenuTablero.add(jMenuItemRegala);
	subMenuAyuda.add(jMenuItemAyuda);
	setJMenuBar(barraMenuPrincipal);
	titulo.setBounds(80,30,350,30);
	miBingo=new Bingo();
	titulo.setVisible(false);
	add(titulo);
	jMenuItemVende.addActionListener(this);
    jMenuItemCreaTableros.addActionListener(this);
    jMenuItemMuestraTablero.addActionListener(this);
    jMenuItemAyuda.addActionListener(this);
    jMenuItemRegala.addActionListener(this);
	setTitle("Bingo Uniquindiano");
	setSize(500,500);
	}



/**
 * Permite configurar las acciones a realizar si ocurre un evento
 */
public void actionPerformed(ActionEvent e)
{

	if(e.getSource()==jMenuItemCreaTableros)
	{
		miBingo.crearTableros();
		Dialogo miD= new DialogoDeAdvertencia("Se han creado los tableros");
		miD.mostrarMensaje();
	}
	
	
	if(e.getSource()==jMenuItemMuestraTablero)
	{
	     int numTablero= Biblioteca.leerEntero("Digite el numero de tablero");
	     VentanaTablero miVentanaTablero= new VentanaTablero(this, numTablero-1);
	     miVentanaTablero.setVisible(true);
	}
	
	
	if(e.getSource() == jMenuItemVende) // Accion de vender tableros
	{
		boolean comprado = true;
		String cedula = Biblioteca.leerString("Digite su numero de cedula");
		miBingo.addCedulas(cedula);
		miBingo.calcularTableroActual(1); //suma 1 debido a que solo se puede comprar de 1 en uno
		miBingo.addTablerosComprados(comprado, miBingo.calcularTableroActual(0),1);
		Dialogo miD= new DialogoDeAdvertencia("Compra exitosa");
		miD.mostrarMensaje();
	}
	
	
	if(e.getSource() == jMenuItemRegala) // Accion de regalar tableros
	{
		boolean comprado = false;
		int tablerosRegalados = Biblioteca.leerEntero("Ingrese el numero de tableros a regalar");
		miBingo.calcularTableroActual(tablerosRegalados); //añade el total de tableros regalados
		miBingo.addTablerosComprados(comprado, miBingo.calcularTableroActual(0),tablerosRegalados);
		Dialogo miD= new DialogoDeAdvertencia("Se han regalado " + tablerosRegalados + " tableros");
		miD.mostrarMensaje();
	}

		
}


 /**
  * M�todo accesor
  * @return Restaurante Devuelve la informaci�n del restaurante
  */
 public int getTamanioTablero()
  {
	  return miBingo.getTam();
  }

 public int[][] devolverTablero (int i)
 {
	 return miBingo.devolverTablero(i);
 }

/**
 * M�todo accesor
 * @return JButton[][] devuelve la informaci�n del array de botones
 */

	}
