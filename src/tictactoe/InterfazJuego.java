package tictactoe;

import java.awt.GridLayout;
import javax.swing.*;

public class InterfazJuego {
	private JFrame marco;
	private JPanel panel;
	
	private casilla [][] casillas;
	
	public InterfazJuego() {
		marco = new JFrame();
		panel = new JPanel(new GridLayout(3,3));
		
		casillas = new casilla [3][3];
		
		rellenaCasillas();
		montarInterfaz();
	}
		private void montarInterfaz() {
		        
			 insertarCasillasAlPanel();
		     
			 marco.add(panel);
			 marco.setSize(500,500);
			 marco.setTitle("Tic tac toe");
			 marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 marco.setLocationRelativeTo(null);
	}
		private void insertarCasillasAlPanel() {
			for (casilla[] arrayCasillas: casillas) {
				for (casilla c:arrayCasillas) {
					panel.add(c);
				}
			}
			
		}
		private void rellenaCasillas() {
			
			for (int i=0; i<casillas.length; i++) {
			    for(int j=0; j<casillas[0].length; j++) {
			    	
			    	casillas [i][j] = new casilla();
			    	casillas [i][j].addActionListener(e->casilla.logicaJuego(casillas, (casilla)e.getSource()));
			    }
			}
	}
       public void abrir() {
    	   marco.setVisible(true);
       }
}
