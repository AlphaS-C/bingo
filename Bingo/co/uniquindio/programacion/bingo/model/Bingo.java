package co.uniquindio.programacion.bingo.model;

import java.util.ArrayList;

/**
 * @version 1.0
 * 
 * Esta es la clase principal del mundo
 * 
 */

public class Bingo {
	private ArrayList<int[][]> tableros;
	private static final int TAM = 5;
	private int tablerosVendidos = 0;

	/**
	 * M�todo constructor de la clase Bingo
	 *
	 */
	public Bingo() {
		tableros = new ArrayList();
	}

	public void crearTableros() {
		int tableroBingo[][] = null;
		for (int c = 0; c < 5; c++) {
			String tableroCadena = "";
			int numeroGenerado = 0;
			tableroBingo = new int[TAM][TAM];
			for (int i = 0; i < TAM; i++) {

				for (int j = 0; j < TAM; j++) {

					numeroGenerado = validarNumero(i);
					
					while (verificarRepetido(tableroBingo, numeroGenerado) == true) 
					{
						numeroGenerado = validarNumero(i);
					}
					
					tableroBingo[j][i] = numeroGenerado;
					/*if (verificarRepetido(tableroBingo, numeroGenerado) == false)
					{
						tableroBingo[j][i] = numeroGenerado; //pone el numero en el vector	
					}
					
					else
					{
						tableroBingo[j][i] = 1;	
					}
					*/
					
					// poner 0 en el centro
					if (j == 2 && i == 2)
					{
						tableroBingo[j][i] = 0;
					
					}
					
				}
			}
			tableros.add(tableroBingo);
		}
	}

	public static boolean verificarRepetido(int tablero[][], int buscado)
	{
		boolean repetido = false;
		for (int i = 0; i < tablero.length; i++)
		{
			for (int j = 0; j < tablero.length; j++)
			{
				if (tablero[i][j] == buscado)
				{
					repetido = true;
				}
			}
		}
		
		return repetido;
	}
	
	
	public static int validarNumero(int columna)
	{
		int numeroAleatorio = 0;
		int min=1; int max=15;
		for (int i = 0; i < columna + 1;i++) {
			numeroAleatorio = generarNumero(min, max);
			min += 15;
			max += 15;
		} 
		return numeroAleatorio;
		
	}
	
	public static int generarNumero (int min, int max)
	{
		int numero = (int) (Math.random() * (max - min)) + min;
		return numero;
	}
	
	public ArrayList<String> addCedulas (String cedula) // añade cedulas a un array
	{
		ArrayList<String> cedulas = new ArrayList<String>();
		cedulas.add(cedula);
		return cedulas;
	}
	
	public int sumarVendidos()
	{
		tablerosVendidos += 1;
		return tablerosVendidos;
	}
	
	
	public String toStringTablero(int tableroBingo[][]) {
		String res = "";
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				res = res + tableroBingo[i][j] + "    ";
			}
			res = res + "\n";
		}
		return res;

	}

	public ArrayList<int[][]> getTableros() {
		return tableros;
	}

	public int[][] devolverTablero(int i) {
		return tableros.get(i);
	}

	public static int getTam() {
		return TAM;
	}

}