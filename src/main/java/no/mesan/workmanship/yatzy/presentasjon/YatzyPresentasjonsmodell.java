package no.mesan.workmanship.yatzy.presentasjon;

import javax.swing.Action;

import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ComponentValueModel;

public interface YatzyPresentasjonsmodell {
    SelectionInList<Yatzykombinasjon> kombinasjonModel();
    ComponentValueModel[] terningModeller();
    ComponentValueModel[] holdTerningModeller();
    ComponentValueModel kastTellerModel();
    ComponentValueModel poengsumModell();
    Action kastAction();
    Action nyRundeAction();
}
