import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class tabel {
    public JPanel mainPanel;
    public JTable table1;

    public tabel(){
        DefaultTableModel model = new DefaultTableModel();
        table1.setModel(model);

        kamar aksesKamar = new kamar();
        model.addColumn("No");
        model.addColumn("Rumah Sakit");
        model.addColumn("Jenis Kamar");
        model.addColumn("Tersedia");
        model.addColumn("Tersedia");

        model.addRow(new Object[]{"Id", "Rumah Sakit","Jenis Kamar","Tersedia"});
        for(int i=0; i<=9;i++){
            model.addRow(new Object[]{i+1, aksesKamar.availableRoom[i][0], aksesKamar.availableRoom[i][3], aksesKamar.availableRoom[i][1], aksesKamar.test});
        }

    }

}
