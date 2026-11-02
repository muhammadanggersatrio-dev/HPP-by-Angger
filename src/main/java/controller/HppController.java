package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HppController {

    @FXML private TextField tfBahan;
    @FXML private TextField tfTenaga;
    @FXML private TextField tfOverhead;
    @FXML private TextField tfUnit;
    @FXML private Label lblTotal;
    @FXML private Label lblHpp;

    @FXML
    private void hitung() {
        try {
            double bahan = Double.parseDouble(tfBahan.getText());
            double tenaga = Double.parseDouble(tfTenaga.getText());
            double overhead = Double.parseDouble(tfOverhead.getText());
            double unit = Double.parseDouble(tfUnit.getText());

            if (unit <= 0) {
                lblTotal.setText("Jumlah unit harus lebih dari 0");
                lblHpp.setText("HPP per Unit: -");
                return;
            }

            double total = bahan + tenaga + overhead;
            double hpp = total / unit;

            lblTotal.setText(String.format("Total Biaya Produksi: Rp %,.2f", total));
            lblHpp.setText(String.format("HPP per Unit: Rp %,.2f", hpp));
        } catch (NumberFormatException e) {
            lblTotal.setText("Isi semua kolom dengan angka yang benar");
            lblHpp.setText("HPP per Unit: -");
        }
    }
}
