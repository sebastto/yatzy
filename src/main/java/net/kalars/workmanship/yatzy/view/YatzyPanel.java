package net.kalars.workmanship.yatzy.view;

import javax.swing.*;
import java.awt.*;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.value.ComponentValueModel;
import net.kalars.workmanship.yatzy.beregning.Yatzykombinasjon;
import net.kalars.workmanship.yatzy.presentasjon.YatzyPresentasjonsmodell;

@SuppressWarnings({"serial", "MagicNumber"})
public class YatzyPanel extends JPanel {
    private final JPanel pnlButtons = new JPanel();
    private final JPanel pnlTerninger = new JPanel();
    private final JPanel pnlKombinasjonerOgPoeng = new JPanel();

    private JButton btnKast;
    private JButton btnNyRunde = new JButton();

    private JLabel lblKombinasjoner;
    private JLabel lblPoengsum;
    private JLabel lblTerninger;
    private JLabel lblHoldTerninger;
    private JLabel lblKastTeller;

    private JComboBox<Yatzykombinasjon> cbxKombinasjoner;

    private JFormattedTextField txtPoengsum;
    private JFormattedTextField txtkastTeller;
    private final JFormattedTextField[] txtTerninger = new JFormattedTextField[5];

    private final JCheckBox[] chkHoldTerninger = new JCheckBox[5];

    private final YatzyPresentasjonsmodell yatzyPresentationModel;

    public YatzyPanel(final YatzyPresentasjonsmodell yatzyPresentationModel) {
        this.yatzyPresentationModel = yatzyPresentationModel;
        lagOgBindGui();
        lagLayout();
    }

    @SuppressWarnings("FeatureEnvy")
    private void lagOgBindGui() {
        this.lblKombinasjoner = new JLabel("Velg kombinasjon:");
        this.lblPoengsum = new JLabel("Poengsum:");
        this.lblTerninger = new JLabel("Terninger:");
        this.lblHoldTerninger = new JLabel("Hold:");
        this.lblKastTeller = new JLabel("Kast nummer:");

        //noinspection unchecked
        this.cbxKombinasjoner = BasicComponentFactory.createComboBox(this.yatzyPresentationModel.kombinasjonModel());

        this.txtPoengsum = BasicComponentFactory.createIntegerField(this.yatzyPresentationModel.poengsumModell());
        this.txtkastTeller = BasicComponentFactory.createIntegerField(this.yatzyPresentationModel.kastTellerModel());

        this.btnKast = new JButton(this.yatzyPresentationModel.kastAction());
        this.btnNyRunde = new JButton(this.yatzyPresentationModel.nyRundeAction());

        final ComponentValueModel[] terningModeller = this.yatzyPresentationModel.terningModeller();
        final ComponentValueModel[] holdTerningModeller = this.yatzyPresentationModel.holdTerningModeller();

        for(int i=0; i< this.txtTerninger.length; i++) {
            this.txtTerninger[i] = BasicComponentFactory.createIntegerField(terningModeller[i]);
            this.chkHoldTerninger[i] = BasicComponentFactory.createCheckBox(holdTerningModeller[i], "");
        }
    }

    private void lagLayout() {
        final Dimension dimTerning = new Dimension(30, 25);

        this.setLayout(new GridBagLayout());
        this.pnlButtons.setLayout(new GridBagLayout());
        this.pnlTerninger.setLayout(new GridBagLayout());
        this.pnlKombinasjonerOgPoeng.setLayout(new GridBagLayout());

        this.pnlButtons.add(this.btnKast,
                            new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                                   GridBagConstraints.NONE, new Insets(0, 0, 0, 5),
                                                   0, 0));
        this.pnlButtons.add(this.btnNyRunde,
                            new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                                   GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
                                                   0, 0));

        this.pnlTerninger.add(this.lblTerninger,
                              new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                                     GridBagConstraints.NONE,
                                                     new Insets(0, 0, 0, 5), 0, 0));
        this.pnlTerninger.add(this.lblHoldTerninger,
                              new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
                                                     GridBagConstraints.NONE,
                                                     new Insets(5, 0, 0, 5), 0, 0));

        for(int i=0; i< this.txtTerninger.length; i++) {
            final JFormattedTextField txtTerning = this.txtTerninger[i];
            final JCheckBox chkHoldTerning = this.chkHoldTerninger[i];
            txtTerning.setPreferredSize(dimTerning);
            txtTerning.setHorizontalAlignment(SwingConstants.CENTER);
            this.pnlTerninger.add(txtTerning, new GridBagConstraints(i + 1, 0, 1, 1, 1.0, 0.0,
                                                                     GridBagConstraints.CENTER,
                                                                     GridBagConstraints.HORIZONTAL,
                                                                     new Insets(0, 5, 0, 5), 0, 0));
            this.pnlTerninger.add(chkHoldTerning, new GridBagConstraints(i + 1, 1, 1, 1, 0.0, 0.0,
                                                                         GridBagConstraints.CENTER,
                                                                         GridBagConstraints.NONE,
                                                                         new Insets(5, 5, 0, 5), 0,
                                                                         0));
        }

        this.txtPoengsum.setHorizontalAlignment(SwingConstants.TRAILING);
        this.txtkastTeller.setHorizontalAlignment(SwingConstants.TRAILING);

        this.pnlKombinasjonerOgPoeng.add(this.lblKastTeller,
                                         new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                                                GridBagConstraints.WEST,
                                                                GridBagConstraints.NONE,
                                                                new Insets(0, 0, 0, 5), 0, 0));
        this.pnlKombinasjonerOgPoeng.add(this.txtkastTeller,
                                         new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
                                                                GridBagConstraints.WEST,
                                                                GridBagConstraints.HORIZONTAL,
                                                                new Insets(0, 0, 0, 0), 0, 0));
        this.pnlKombinasjonerOgPoeng.add(this.lblKombinasjoner,
                                         new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                                                GridBagConstraints.WEST,
                                                                GridBagConstraints.NONE,
                                                                new Insets(11, 0, 0, 5), 0, 0));
        this.pnlKombinasjonerOgPoeng.add(this.cbxKombinasjoner,
                                         new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0,
                                                                GridBagConstraints.WEST,
                                                                GridBagConstraints.HORIZONTAL,
                                                                new Insets(11, 0, 0, 0), 0, 0));
        this.pnlKombinasjonerOgPoeng.add(this.lblPoengsum,
                                         new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                                                                GridBagConstraints.WEST,
                                                                GridBagConstraints.NONE,
                                                                new Insets(11, 0, 0, 5), 0, 0));
        this.pnlKombinasjonerOgPoeng.add(this.txtPoengsum,
                                         new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0,
                                                                GridBagConstraints.WEST,
                                                                GridBagConstraints.HORIZONTAL,
                                                                new Insets(11, 0, 0, 0), 0, 0));

        this.add(this.pnlTerninger, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(11, 11, 0, 11), 0, 0));
        this.add(this.pnlKombinasjonerOgPoeng, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(19, 11, 0, 11), 0, 0));
        this.add(this.pnlButtons, new GridBagConstraints(0, 2, 1, 1, 0.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(19, 11, 11, 11), 0, 0));
    }
}