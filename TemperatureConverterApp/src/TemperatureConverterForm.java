import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterForm {
    public JPanel mainPanel;
    private JTextField temperatureInput;
    private JComboBox<String> unitComboBox;
    private JButton convertButton;
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JLabel kelvinLabel;

    public TemperatureConverterForm() {
        unitComboBox.addItem("Celsius");
        unitComboBox.addItem("Fahrenheit");
        unitComboBox.addItem("Kelvin");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemperature = Double.parseDouble(temperatureInput.getText());
                    String selectedUnit = (String) unitComboBox.getSelectedItem();
                    convertAndDisplay(inputTemperature, selectedUnit);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid number for temperature.");
                }
            }
        });
    }

    private void convertAndDisplay(double value, String unit) {
        switch (unit.toLowerCase()) {
            case "celsius":
                double fahrenheitFromCelsius = celsiusToFahrenheit(value);
                double kelvinFromCelsius = celsiusToKelvin(value);
                celsiusLabel.setText(String.format("Celsius: %.2f", value));
                fahrenheitLabel.setText(String.format("Fahrenheit: %.2f", fahrenheitFromCelsius));
                kelvinLabel.setText(String.format("Kelvin: %.2f", kelvinFromCelsius));
                break;
            case "fahrenheit":
                double celsiusFromFahrenheit = fahrenheitToCelsius(value);
                double kelvinFromFahrenheit = fahrenheitToKelvin(value);
                celsiusLabel.setText(String.format("Celsius: %.2f", celsiusFromFahrenheit));
                fahrenheitLabel.setText(String.format("Fahrenheit: %.2f", value));
                kelvinLabel.setText(String.format("Kelvin: %.2f", kelvinFromFahrenheit));
                break;
            case "kelvin":
                double celsiusFromKelvin = kelvinToCelsius(value);
                double fahrenheitFromKelvin = kelvinToFahrenheit(value);
                celsiusLabel.setText(String.format("Celsius: %.2f", celsiusFromKelvin));
                fahrenheitLabel.setText(String.format("Fahrenheit: %.2f", fahrenheitFromKelvin));
                kelvinLabel.setText(String.format("Kelvin: %.2f", value));
                break;
            default:
                JOptionPane.showMessageDialog(mainPanel, "Invalid unit of measurement. Please enter Celsius, Fahrenheit, or Kelvin.");
                break;
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}
