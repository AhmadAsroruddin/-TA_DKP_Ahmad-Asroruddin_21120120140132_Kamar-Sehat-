import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class kamar {
    private JTextField nama;
    private JButton button1;
    private JPanel mainPanel;
    private JComboBox penyakit;
    private JButton tersedia;
    private JComboBox namaRumahSakit;

    public String [][] availableRoom = {{"Ibnu Sina", "3","Cendana", "Kanker", "100000"},{"Ibnu Sina","4","Melati","Demam berdarah","3000000"},{"Ibnu Sina", "2","Kamboja", "Penyakit Menular","4000000"},{"Ibnu Sina","2","Kayu Putih","Melahirkan","6000000"},
            {"Ibnu Sina","5","Pucuk Merah","Lain-lainnya","500000"}, {"Al-butani", "3","Cendana", "Kanker", "100000"}, {"Al-butani","4","Melati","Demam berdarah","3000000"}, {"Al-butani", "2","Kamboja", "Penyakit Menular","4000000"},
            {"Al-butani","2","Kayu Putih","Melahirkan","6000000"}, {"Al-butani","5","Pucuk Merah","Lain-lainnya","500000"}};
    public Object test = penyakit.getSelectedItem();
    public String get_nama(){
        return nama.getText();
    }

    public kamar() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<=availableRoom.length-1;i++){
                    if(penyakit.getSelectedItem() == availableRoom[i][3] && Integer.parseInt(availableRoom[i][1]) != 0 && namaRumahSakit.getSelectedItem() == availableRoom[i][0] ){
                            int konfirmasi = JOptionPane.showConfirmDialog(null, "Anda telah memesan kamar"+availableRoom[i][3]+" di Rumah Sakit "+availableRoom[i][0]+"Dengan harga "+availableRoom[i][4]+"?");
                            if( konfirmasi == JOptionPane.YES_OPTION){
                                int kamarPilihan = Integer.parseInt(availableRoom[i][1])-1;
                                availableRoom[i][1] = Integer.toString(kamarPilihan);
                                JOptionPane.showMessageDialog(null, "Selamat Pesanan anda telah terkonfirmasi \n Terimakasih bpk/ibu "+get_nama());
                            }
                        break;
                    } else if(!availableRoom[i][0].equals("Ibnu Sina") && penyakit.getSelectedItem() == availableRoom[i][3]){
                        JOptionPane.showMessageDialog(null, "Maaf kami tidak menemukan kamar yang masih kosong");
                        break;
                    }
                }
            }
        });
        nama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt){
                char c = evt.getKeyChar();
                if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
                    nama.setEditable(true);
                } else {
                    nama.setEditable(false);
                }
            }
        });

        tersedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();

                Object[][] rowData = new Object[9][4];

                for(int i =0; i<9;i++){
                   rowData[i][0] = i+1;
                   rowData[i][1] = availableRoom[i][0];
                   rowData[i][2] = availableRoom[i][3];
                   rowData[i][3] = availableRoom[i][1];
                }
                Object columnNames[] = { "Id", "Rumah Sakit", "Jenis Kamar", "Tersedia" };
                JTable table = new JTable(rowData, columnNames);

                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(900, 300);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("kamar");
        frame.setContentPane(new kamar().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
