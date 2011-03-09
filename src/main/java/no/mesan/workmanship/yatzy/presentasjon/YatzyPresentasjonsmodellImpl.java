package no.mesan.workmanship.yatzy.presentasjon;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;

import no.mesan.workmanship.yatzy.beregning.YatzyBeregner;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ComponentValueModel;
import com.jgoodies.binding.value.ValueHolder;

public class YatzyPresentasjonsmodellImpl implements YatzyPresentasjonsmodell {
	private final YatzyBeregner yatzyBeregner;
	
	private SelectionInList<Yatzykombinasjon> kombinasjonerModel;
	private ComponentValueModel[] terningModeller;
	private ComponentValueModel[] holdTerningModeller;
	private ComponentValueModel valgtKombinsajonModel;
	private ComponentValueModel poengsumModell;
	private ComponentValueModel kastTellerModell;
	private Action kastAction;
	private Action nyRundeAction;
	
	public YatzyPresentasjonsmodellImpl(final YatzyBeregner yatzyBeregner) {
		this.yatzyBeregner = yatzyBeregner;
		initModell();
		initActions();
		nyRunde();
	}

	private void initModell() {
		valgtKombinsajonModel = new ComponentValueModel(new ValueHolder());
		kombinasjonerModel = new SelectionInList<Yatzykombinasjon>(Yatzykombinasjon.values());
		kombinasjonerModel.setSelectionHolder(valgtKombinsajonModel);
		valgtKombinsajonModel.setValue(Yatzykombinasjon.ENERE);
		terningModeller = new ComponentValueModel[5];
		holdTerningModeller = new ComponentValueModel[5];
		
		for(int i=0; i<5; i++) {
			terningModeller[i] = new ComponentValueModel(new ValueHolder(randKast()));
			terningModeller[i].setEditable(false);
			holdTerningModeller[i] = new ComponentValueModel(new ValueHolder(Boolean.FALSE));
		}
		
		poengsumModell = new ComponentValueModel(new ValueHolder(0));
		poengsumModell.setEditable(false);
		kastTellerModell = new ComponentValueModel(new ValueHolder(0));
		kastTellerModell.setEditable(false);
	}

	@SuppressWarnings("serial")
	private void initActions() {
		kastAction = new AbstractAction("Kast") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				kastTerninger();
			}
		};
		
		nyRundeAction = new AbstractAction("Ny runde") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nyRunde();
			}
		};
		
		kombinasjonerModel.addPropertyChangeListener("selection", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				beregnProengsum();
			}
		});
	}

	@Override
	public ComponentValueModel kastTellerModel() {
		return kastTellerModell;
	}

	@Override
	public ComponentValueModel[] holdTerningModeller() {
		return holdTerningModeller;
	}

	@Override
	public Action kastAction() {
		return kastAction;
	}

	@Override
	public SelectionInList<Yatzykombinasjon> kombinasjonModel() {
		return kombinasjonerModel;
	}

	@Override
	public Action nyRundeAction() {
		return nyRundeAction;
	}

	@Override
	public ComponentValueModel[] terningModeller() {
		return terningModeller;
	}
	
	@Override
	public ComponentValueModel poengsumModell() {
		return poengsumModell;
	}
	
	private void kastTerninger() {
		kastAktiveTerninger();
		beregnProengsum();
		
		if(hentAntallKast() == 2) {
			kastAction.setEnabled(false);
			nyRundeAction.setEnabled(true);
		}
		
		kastTellerModell.setEnabled(true);
		valgtKombinsajonModel.setEnabled(true);
		poengsumModell.setEnabled(true);
		
		laasHoldteTerninger();
		inkrementerKastTeller();
	}
	
	private void nyRunde() {
		nullstillHoldmodeller();
		nullstillTerninger();
		nullstillKastTeller();
		nullstillPoengsum();
		
		kastAction.setEnabled(true);
		nyRundeAction.setEnabled(false);		
		kastTellerModell.setEnabled(false);
		valgtKombinsajonModel.setEnabled(false);
		poengsumModell.setEnabled(false);
	}

	private void beregnProengsum() {
		final Integer[] terninger = hentTerninger();
		final Yatzykombinasjon valgtKombinasjon = kombinasjonerModel.getSelection();
		final Integer nyPoengsum = yatzyBeregner.beregnPoengsum(valgtKombinasjon, terninger);
		poengsumModell.setValue(nyPoengsum);
	}
	
	private Integer randKast() {
		return Integer.valueOf((int)Math.ceil(Math.random() * 6));
	}

	private Integer[] hentTerninger() {
		final Integer[] terninger = new Integer[5];
		for(int i=0; i<terninger.length; i++) {
			terninger[i] = (Integer)terningModeller[i].getValue();
		}
		return terninger;
	}

	private void laasHoldteTerninger() {
		for(final ComponentValueModel holdModell : holdTerningModeller) {
			holdModell.setEnabled(!holdModell.getValue().equals(Boolean.TRUE));
		}
	}

	private void nullstillPoengsum() {
		poengsumModell.setValue(0);
	}

	private void kastAktiveTerninger() {
		for(int i=0; i<5; i++) {
			if(holdTerningModeller[i].getValue().equals(Boolean.FALSE)) {
				terningModeller[i].setValue(randKast());
			}
		}
	}
	
	private void nullstillTerninger() {
		for(final ComponentValueModel terningModel : terningModeller) {
			terningModel.setValue(null);
		}
	}

	private void nullstillHoldmodeller() {
		for(final ComponentValueModel holdModell : holdTerningModeller) {
			holdModell.setValue(Boolean.FALSE);
			holdModell.setEnabled(false);
		}
	}

	private void nullstillKastTeller() {
		kastTellerModell.setValue(0);
	}
	
	private void inkrementerKastTeller() {
		kastTellerModell.setValue((Integer)kastTellerModell.getValue() + 1);
	}
	
	private Integer hentAntallKast() {
		return (Integer)kastTellerModell.getValue();
	}
}
