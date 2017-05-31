import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Weather extends JFrame {
    private JTextField fieldKota, c1, c2, c3, c4;
    private Font fontKota, fontContent;
    private String desc;
    private JButton search;

    public Weather() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        this.setTitle("Weather");
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFont(new JLabel().getFont());

        fontKota = this.getFont().deriveFont(20f);
        fontContent = this.getFont().deriveFont(16f);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder());

        fieldKota = new JTextField("Masukkan Nama Kota Disini");
        fieldKota.setEditable(true);
        fieldKota.setFont(fontKota);
        fieldKota.setHorizontalAlignment(SwingConstants.CENTER);
        fieldKota.setPreferredSize(new Dimension(400, 50));
        fieldKota.setMaximumSize(new Dimension(400, 50));

        panel.add(fieldKota);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());

        JTextField temperature, detail, humidity, pressure;

        temperature = new JTextField("Suhu");
        temperature.setEditable(false);
        temperature.setFont(fontContent);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        temperature.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(temperature, gridBagConstraints);
        temperature.setBorder(BorderFactory.createEmptyBorder());

        detail = new JTextField("Keterangan");
        detail.setEditable(false);
        detail.setFont(fontContent);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        detail.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(detail, gridBagConstraints);
        detail.setBorder(BorderFactory.createEmptyBorder());

        humidity = new JTextField("Kelembapan");
        humidity.setEditable(false);
        humidity.setFont(fontContent);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        humidity.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(humidity, gridBagConstraints);
        humidity.setBorder(BorderFactory.createEmptyBorder());

        pressure = new JTextField("Tekanan");
        pressure.setEditable(false);
        pressure.setFont(fontContent);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        pressure.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(pressure, gridBagConstraints);
        pressure.setBorder(BorderFactory.createEmptyBorder());

        JTextField titikdua1, titikdua2, titikdua3, titikdua4;

        titikdua1 = new JTextField(":");
        titikdua1.setEditable(false);
        titikdua1.setFont(fontContent);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        titikdua1.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(titikdua1, gridBagConstraints);
        titikdua1.setBorder(BorderFactory.createEmptyBorder());

        titikdua2 = new JTextField(":");
        titikdua2.setEditable(false);
        titikdua2.setFont(fontContent);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        titikdua2.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(titikdua2, gridBagConstraints);
        titikdua2.setBorder(BorderFactory.createEmptyBorder());

        titikdua3 = new JTextField(":");
        titikdua3.setEditable(false);
        titikdua3.setFont(fontContent);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        titikdua3.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(titikdua3, gridBagConstraints);
        titikdua3.setBorder(BorderFactory.createEmptyBorder());

        titikdua4 = new JTextField(":");
        titikdua4.setEditable(false);
        titikdua4.setFont(fontContent);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        titikdua4.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(titikdua4, gridBagConstraints);
        titikdua4.setBorder(BorderFactory.createEmptyBorder());

        c1 = new JTextField();
        c1.setEditable(false);
        c1.setFont(fontContent);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        c1.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(c1, gridBagConstraints);
        c1.setBorder(BorderFactory.createEmptyBorder());

        c2 = new JTextField();
        c2.setEditable(false);
        c2.setFont(fontContent);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        c2.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(c2, gridBagConstraints);
        c2.setBorder(BorderFactory.createEmptyBorder());

        c3 = new JTextField();
        c3.setEditable(false);
        c3.setFont(fontContent);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        c3.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(c3, gridBagConstraints);
        c3.setBorder(BorderFactory.createEmptyBorder());

        c4 = new JTextField();
        c4.setEditable(false);
        c4.setFont(fontContent);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        c4.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(c4, gridBagConstraints);
        c4.setBorder(BorderFactory.createEmptyBorder());

        search = new JButton("Search");
        search.setFont(fontContent);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        search.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(search, gridBagConstraints);
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setActionCommand("searchWeather");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String link = "http://api.openweathermap.org/data/2.5/weather?q=" + fieldKota.getText() + "&appid=b7ba0b30cc4aee57ba67dd21c5f04eb9";


                JSONParser parser = new JSONParser();
                try {
                    URL url = new URL(link);
                    InputStream inputStream = url.openStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

                    JSONObject a = (JSONObject) parser.parse(in);
                    JSONObject obj = (JSONObject) a;

                    JSONArray b = (JSONArray) obj.get("weather");
                    for (Object i : b) {
                        JSONObject o = (JSONObject) i ;
                        desc = (String) o.get("description");
                    }
                    c2.setText(desc);

                    JSONObject c = (JSONObject) obj.get("main");
                    Double temp = (Double) c.get("temp") - 273.15;
                    String celcius = temp + " Celcius";
                    c1.setText(celcius);

                    Long humid = (Long) c.get("humidity");
                    String hum = humid + " %";
                    c3.setText(hum);

                    Long press = (Long) c.get("pressure");
                    String pres = press + " hPa";
                    c4.setText(pres);

                    in.close();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        panel.add(content);

        this.setMinimumSize(this.getPreferredSize());

        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Weather app = new Weather();
    }
}