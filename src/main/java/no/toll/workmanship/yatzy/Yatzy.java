package no.toll.workmanship.yatzy;

import javax.swing.*;

import no.toll.workmanship.yatzy.beregning.Beregner;
import no.toll.workmanship.yatzy.presentasjon.YatzyPresentasjonsmodellImpl;
import no.toll.workmanship.yatzy.view.YatzyPanel;

final class Yatzy {
    Yatzy() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final Exception e) {
            e.printStackTrace();
        }

        final JFrame frame = new JFrame("Yatzy");
        frame.setContentPane(new YatzyPanel(new YatzyPresentasjonsmodellImpl(new Beregner())));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new Yatzy();
    }
}