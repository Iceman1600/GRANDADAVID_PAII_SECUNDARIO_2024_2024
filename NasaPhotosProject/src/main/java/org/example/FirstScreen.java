package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FirstScreen extends JFrame {
    private JComboBox<String> filterComboBox;
    private JTextField filterTextField;
    private JTextArea resultArea;
    private JButton imageViewButton; // Botón para abrir SecondScreen
    private List<Photos> allPhotos;
    private Controller controller;

    public FirstScreen() {
        controller = new Controller();
        setupUI();
    }

    private void setupUI() {
        setTitle("Mars Rover Photo Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el ComboBox con los nombres de los métodos de filtrado
        String[] filterOptions = {"Filtrar por Rover", "Filtrar por ID", "Filtrar por Sol", "Filtrar por Camera", "Filtrar por Fecha", "Filtrar por Imagen"};
        filterComboBox = new JComboBox<>(filterOptions);
        filterComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilter();
            }
        });

        // Crear el área de resultados
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Crear el JTextField para el parámetro de filtro
        filterTextField = new JTextField();
        filterTextField.setPreferredSize(new Dimension(200, 25));
        filterTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFilter();
            }
        });

        // Panel para contener el ComboBox y el TextField
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        filterPanel.add(filterComboBox);
        filterPanel.add(filterTextField);

        // Botón para abrir SecondScreen
        imageViewButton = new JButton("Image Viewer");
        imageViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSecondScreen();
            }
        });

        // Panel para el botón Image Viewer
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(imageViewButton);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(filterPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar el panel principal a la ventana
        add(mainPanel);

        // Cargar las fotos al iniciar
        loadPhotos();
    }

    private void loadPhotos() {
        ApiConnect apiConnect = new ApiConnect();
        try {
            apiConnect.fetchMarsPhotos();
            allPhotos = apiConnect.getPhotoList();
            updateResultArea(allPhotos); // Mostrar todas las fotos al inicio
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyFilter() {
        String selectedFilter = (String) filterComboBox.getSelectedItem();
        String filterText = filterTextField.getText().trim();

        List<Photos> filteredPhotos = allPhotos;

        switch (selectedFilter) {
            case "Filtrar por Rover":
                filteredPhotos = controller.filterByRoverName(allPhotos, filterText);
                break;
            case "Filtrar por ID":
                try {
                    int id = Integer.parseInt(filterText);
                    filteredPhotos = controller.filterById(allPhotos, id);
                } catch (NumberFormatException e) {
                    // Handle if filterText is not a valid integer
                    filteredPhotos = controller.filterById(allPhotos, -1); // Provide a default filter (e.g., -1)
                }
                break;
            case "Filtrar por Sol":
                try {
                    int sol = Integer.parseInt(filterText);
                    filteredPhotos = controller.filterBySol(allPhotos, sol);
                } catch (NumberFormatException e) {
                    // Handle if filterText is not a valid integer
                    filteredPhotos = controller.filterBySol(allPhotos, -1); // Provide a default filter (e.g., -1)
                }
                break;
            case "Filtrar por Camera":
                filteredPhotos = controller.filterByCameraName(allPhotos, filterText);
                break;
            case "Filtrar por Fecha":
                filteredPhotos = controller.filterByEarthDate(allPhotos, filterText);
                break;
            case "Filtrar por Imagen":
                filteredPhotos = controller.filterByImgSrc(allPhotos, filterText);
                break;
        }

        updateResultArea(filteredPhotos);
    }

    private void updateResultArea(List<Photos> photos) {
        resultArea.setText("");
        for (Photos photo : photos) {
            resultArea.append(photo.toString() + "\n\n");
        }
    }

    // Método para abrir SecondScreen
    private void openSecondScreen() {
        SecondScreen secondScreen = new SecondScreen();
        secondScreen.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FirstScreen firstScreen = new FirstScreen();
            firstScreen.setVisible(true);
        });
    }
}
