package cl.duoc.esports.controller;

import cl.duoc.esports.model.Casual;
import cl.duoc.esports.model.Competitivo;
import cl.duoc.esports.model.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class JugadorController {
    @FXML
    public Label labelEsportM;
    @FXML
    public Label labelRegistro;
    @FXML
    public Label labelNikname;
    @FXML
    public Label labelVideojuego;
    @FXML
    public Label labelNivel;
    @FXML
    public Label labelTipoJ;
    @FXML
    public Button buttonRegistro;
    @FXML
    public Button buttonEliminar;
    @FXML
    public ComboBox<String> comboBoxVideojuego;
    @FXML
    public ComboBox<String> comboBoxTipoJ;
    @FXML
    public TextField textFieldNickname;
    @FXML
    public TextField textFieldNivel;
    @FXML
    public TableView<Jugador> tableViewRegistros;
    @FXML
    public TableColumn<Jugador, String> tableColumnNickname;
    @FXML
    public TableColumn<Jugador, String>  tableColumnVideojuego;
    @FXML
    public TableColumn<Jugador, Integer>  tableColumnNivel;
    @FXML
    public TableColumn<Jugador, Integer> tableColumnPuntos;
    @FXML
    public TextField textFieldVP;
    @FXML
    public Label labelVP;
    @FXML
    public Label labelMensaje;

    ArrayList<Jugador> jugadores = new ArrayList<>();

    public void cargarTabla(){
        tableColumnNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        tableColumnVideojuego.setCellValueFactory(new PropertyValueFactory<>("videojuego"));
        tableColumnNivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
        tableColumnPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        ObservableList<Jugador> data = FXCollections.observableArrayList(jugadores);
        tableViewRegistros.setItems(data);
    }
    @FXML
    public void initialize(){
        comboBoxVideojuego.getItems().addAll("Valorant","Fortnite","League of Legends");
        comboBoxTipoJ.getItems().addAll("Competitivo", "Casual");
        comboBoxTipoJ.setOnAction(evento->{
            String comcas= comboBoxTipoJ.getValue();
            if(comcas.equals("Competitivo")){
                textFieldVP.setDisable(false);
                textFieldVP.setPromptText("Ingrese cantidad de victorias");
                labelVP.setText("Cantidad de victorias");
            }else{
                textFieldVP.setDisable(false);
                textFieldVP.setPromptText("Ingrese cantidad de partidas");
                labelVP.setText("Cantidad de partidas");
            }
        });
    }
    @FXML
    public void agregarJugador() {
        try {
            Jugador j;
            String nickname = textFieldNickname.getText();
            int nivel = Integer.parseInt(textFieldNivel.getText());
            int puntitos=Integer.parseInt(textFieldVP.getText());


            String videojuego = comboBoxVideojuego.getValue();
            String tipo = comboBoxVideojuego.getValue();
            if (tipo.equals("Competitivo")) {
                int victorias = Integer.parseInt(textFieldVP.getText());

                j = new Competitivo(nickname, videojuego, nivel,puntitos, victorias);
            } else {
                int partidas = Integer.parseInt(textFieldVP.getText());
                j = new Casual(nickname, videojuego, nivel,puntitos, partidas);
            }
            jugadores.add(j);
            cargarTabla();
            mostrarMensaje("Jugador agregado");


        } catch (NumberFormatException ex) {
            labelMensaje.setText("Debe ingresar números para campos numéricos.");
        }
        catch(Exception ex) {
            labelMensaje.setText(ex.getMessage());
        }
        }
        @FXML
        public void eliminarJugador(){
            try {
                Jugador j = tableViewRegistros.getSelectionModel().getSelectedItem();
                if(j==null){
                    labelMensaje.setText("Debe seleccionar un jugador de la tabla");
                    return;
                }
                jugadores.remove(j);
                cargarTabla();
                mostrarMensaje("Jugdor eliminado!");

            } catch (Exception ex) {
                labelMensaje.setText(ex.getMessage());
            }
        }
        public void mostrarMensaje(String mensaje){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setContentText(mensaje);
            alerta.show();
    }
}
