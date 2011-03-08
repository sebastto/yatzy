package no.mesan.workmanship.yatzy.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import no.mesan.workmanship.yatzy.presentasjon.YatzyPresentasjonsmodell;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.value.ComponentValueModel;

@SuppressWarnings("serial")
public class YatzyPanel extends JPanel {
	private JPanel pnlButtons = new JPanel();
	private JPanel pnlTerninger = new JPanel();
	private JPanel pnlKombinasjonerOgPoeng = new JPanel();
	
	private JButton btnKast;
	private JButton btnNyRunde = new JButton();
	
	private JLabel lblKombinasjoner;
	private JLabel lblPoengsum;
	private JLabel lblTerninger;
	private JLabel lblHoldTerninger;
	private JLabel lblKastTeller;
	
	private JComboBox cbxKombinasjoner;
	
	private JFormattedTextField txtPoengsum;
	private JFormattedTextField txtkastTeller;
	private JFormattedTextField[] txtTerninger = new JFormattedTextField[5];
	
	private JCheckBox[] chkHoldTerninger = new JCheckBox[5];

	private final YatzyPresentasjonsmodell yatzyPresentationModel;
	
	public YatzyPanel(final YatzyPresentasjonsmodell yatzyPresentationModel) {
		this.yatzyPresentationModel = yatzyPresentationModel;
		lagOgBindGui();
		lagLayout();
	}

	private void lagOgBindGui() {
		lblKombinasjoner = new JLabel("Velg kombinasjon:");
		lblPoengsum = new JLabel("Poengsum:");
		lblTerninger = new JLabel("Terninger:");
		lblHoldTerninger = new JLabel("Hold:");
		lblKastTeller = new JLabel("Kast nummer:");
		
		cbxKombinasjoner = BasicComponentFactory.createComboBox(yatzyPresentationModel.kombinasjonModel());
		
		txtPoengsum = BasicComponentFactory.createIntegerField(yatzyPresentationModel.poengsumModell());
		txtkastTeller = BasicComponentFactory.createIntegerField(yatzyPresentationModel.kastTellerModel());

		btnKast = new JButton(yatzyPresentationModel.kastAction());
		btnNyRunde = new JButton(yatzyPresentationModel.nyRundeAction());
		
		final ComponentValueModel[] terningModeller = yatzyPresentationModel.terningModeller();
		final ComponentValueModel[] holdTerningModeller = yatzyPresentationModel.holdTerningModeller();
		
		for(int i=0; i<txtTerninger.length; i++) {
			txtTerninger[i] = BasicComponentFactory.createIntegerField(terningModeller[i]);
			chkHoldTerninger[i] = BasicComponentFactory.createCheckBox(holdTerningModeller[i], "");
		}
	}
	
	private void lagLayout() {
		final Dimension dimTerning = new Dimension(30, 25);
		
		this.setLayout(new GridBagLayout());
		pnlButtons.setLayout(new GridBagLayout());
		pnlTerninger.setLayout(new GridBagLayout());
		pnlKombinasjonerOgPoeng.setLayout(new GridBagLayout());
		
		pnlButtons.add(btnKast, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
		pnlButtons.add(btnNyRunde, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		
		pnlTerninger.add(lblTerninger, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
		pnlTerninger.add(lblHoldTerninger, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 5), 0, 0));
		
		for(int i=0; i<txtTerninger.length; i++) {
			final JFormattedTextField txtTerning = txtTerninger[i];
			final JCheckBox chkHoldTerning = chkHoldTerninger[i];
			txtTerning.setPreferredSize(dimTerning);
			txtTerning.setHorizontalAlignment(SwingConstants.CENTER);
			pnlTerninger.add(txtTerning, new GridBagConstraints(i+1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 0, 5), 0, 0));
			pnlTerninger.add(chkHoldTerning, new GridBagConstraints(i+1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 0, 5), 0, 0));
		}
		
		txtPoengsum.setHorizontalAlignment(SwingConstants.TRAILING);
		txtkastTeller.setHorizontalAlignment(SwingConstants.TRAILING);
		
		pnlKombinasjonerOgPoeng.add(lblKastTeller, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
		pnlKombinasjonerOgPoeng.add(txtkastTeller, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		pnlKombinasjonerOgPoeng.add(lblKombinasjoner, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(11, 0, 0, 5), 0, 0));
		pnlKombinasjonerOgPoeng.add(cbxKombinasjoner, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(11, 0, 0, 0), 0, 0));
		pnlKombinasjonerOgPoeng.add(lblPoengsum, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(11, 0, 0, 5), 0, 0));
		pnlKombinasjonerOgPoeng.add(txtPoengsum, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(11, 0, 0, 0), 0, 0));
		
		this.add(pnlTerninger, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(11, 11, 0, 11), 0, 0));
		this.add(pnlKombinasjonerOgPoeng, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(19, 11, 0, 11), 0, 0));
		this.add(pnlButtons, new GridBagConstraints(0, 2, 1, 1, 0.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(19, 11, 11, 11), 0, 0));
	}
}
