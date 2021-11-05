package Vue;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import Constantes.ConstantesInterfaces;

public class CelluleRenderer extends JLabel implements TableCellRenderer,ConstantesInterfaces {
	private static final long serialVersionUID = 7614980041275818704L;
	
	public CelluleRenderer () {
		super();
		setOpaque (true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		this.setForeground(GRIS_CLAIR);
		}

	public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne,boolean aLeFocus, int ligne, int colonne) {
		
		if (valeur == null)
			return null;
		String valeurString = ((String) valeur);
		if(ligne%2 == 0)
			this.setBackground(GRIS_CLAIR);
		
		if(ligne%2 == 1)
			this.setBackground(GRIS_FONCE);
		
		this.setFont(US_12);
		this.setForeground(BLANC);
		this.setOpaque(true);
		this.setText(valeurString);
		this.setToolTipText(valeurString);
		this.setBorder(BorderFactory.createLineBorder(GRIS_FONCE));
			
		return this;
	}
}

