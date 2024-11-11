package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class casilla extends JButton {
       
	private static boolean turnoJugadorUno = true;
	private static boolean ganar;
	private static String simbolo;
	
	public casilla() {
		
		this.setFont(new Font("Arial", Font.BOLD, 80));
		this.setBackground(Color.WHITE);
	}
	public static void logicaJuego(casilla[][] casillas, casilla c) {
	
	pintarCasilla(c);
	compruebaLiena(casillas);
	compruebaColumnas(casillas);

	}
	private static void compruebaColumnas(casilla[][] casillas) {
         for(int j=0; j<casillas.length; j++) {
			
			ganar = true;
			simbolo = casillas [0][j].getText();
			
			if(!simbolo.equals("")) {
				for(int i=1; i<casillas[0].length; i++) {
					if(!simbolo.equals(casillas[i][j].getText()))ganar=false;
				}
				
				if(ganar) ganar(simbolo);
			}
			
         }
	}
	
	private static void compruebaLiena(casilla[][] casillas) {
		
		for(int i=0; i<casillas.length; i++) {
			
			ganar = true;
			simbolo = casillas [i][0].getText();
			
			if(!simbolo.equals("")) {
				for(int j=0; j<casillas[0].length; j++) {
					if(!simbolo.equals(casillas[i][j].getText()))ganar=false;
				}
				if(ganar) ganar(simbolo);
			}
		}
		
		
	}
	private static void ganar(String s) {
		
		JOptionPane.showMessageDialog(null,"Ha ganado eljugador" + s);
		System.exit(0);
		
	}
	private static void pintarCasilla(casilla c) {
		
		if(turnoJugadorUno) {
			c.setText("X");
			turnoJugadorUno = false;
			c.setEnabled(false);
		}else {
			c.setText("O");
			turnoJugadorUno = true;
			c.setEnabled(false);
		}
		
	}

}
