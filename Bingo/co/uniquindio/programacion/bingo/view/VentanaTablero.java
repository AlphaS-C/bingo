package co.uniquindio.programacion.bingo.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;


/**
 * @version 1.0
 
 * @author  Sonia Jaramillo Valbuena
 * Esta clase es la encargada de mostrar la factura
 * 
 */

public class VentanaTablero extends JFrame implements WindowListener, ActionListener
{
  //Se declaran los atributos
	private JButton btnTablero[][];
	private JButton btnRegresar;
	private VentanaBingo miVentanaBingo;
	private  JPanel panelSuperior;
	private JLabel lblTitulo;
	private JPanel panelCentro;
	private  JPanel panelInferior;
	
	
/**
 * Método constructor de la clase VentanaFactura
 * @param miInfo String con la informacion que se imprime en pantalla referente a la factura
 * @param numero número de factura
 * @param miVentanaAgregarPlato
 */	
	
	public VentanaTablero (VentanaBingo miVentanaBingo, int numTablero)
	{   

   getContentPane();
   miVentanaBingo.setVisible(false);
   getContentPane().setLayout(new BorderLayout(0, 0));
   this.miVentanaBingo=miVentanaBingo;
   int tam = miVentanaBingo.getTamanioTablero();
   int tablero [][]= miVentanaBingo.devolverTablero(numTablero);
   btnTablero = new JButton[tam][tam];
   crearPanelSuperior();
   crearPanelCentro (tam, tablero);
   crearPanelInferior();
   
   addWindowListener(this);
	    
	    	repaint();
		setTitle("Tablero");
		setSize(500,700);
		setVisible (true);
					
	}
	
	public void crearPanelSuperior ()
	{
		
		  panelSuperior = new JPanel();
		 getContentPane().add(panelSuperior, BorderLayout.NORTH);
		lblTitulo = new JLabel("Tablero");
		 panelSuperior.add(lblTitulo);
		 
		
	}
	
	public void crearPanelCentro(int tam, int tablero[][])
	{
		
		  panelCentro = new JPanel();
		   getContentPane().add(panelCentro, BorderLayout.CENTER);
		   panelCentro.setLayout(new GridLayout(tam, tam, 0, 0));
		   for(int i=0; i<tam; i++)
			{  
			 for (int j=0; j<tam; j++)
				{		btnTablero[i][j]=new JButton();
					    //btnTablero[i][j].setBounds(1+i*66,j*66+130,60,60);
					 
					    btnTablero[i][j].setText(""+tablero[i][j]);
					    btnTablero[i][j].setVisible(true);
					    panelCentro.add(btnTablero[i][j]);
				}
			}	
	}
	
	public void crearPanelInferior ()
	{
		
		  panelInferior = new JPanel();
		 getContentPane().add(panelInferior, BorderLayout.SOUTH);
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(this);
		 panelInferior.add(btnRegresar);
		 
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRegresar)
		{
			dispose();
			miVentanaBingo.setVisible(true);
			
		}
	}
	
/**
 * Acciones a seguir si se cierra la ventana
 */
	public void windowClosing(WindowEvent arg0) {
		miVentanaBingo.setVisible(true);
	}
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		miVentanaBingo.setVisible(true);
	}
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
