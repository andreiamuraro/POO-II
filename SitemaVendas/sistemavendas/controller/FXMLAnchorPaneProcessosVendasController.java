package sistemavendas.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemavendas.model.dao.ItemDeVendaDAO;
import sistemavendas.model.dao.ProdutoDAO;
import sistemavendas.model.dao.VendaDAO;
import sistemavendas.model.database.Database;
import sistemavendas.model.database.DatabaseFactory;
import sistemavendas.model.domain.ItemDeVenda;
import sistemavendas.model.domain.Produto;
import sistemavendas.model.domain.Venda;

public class FXMLAnchorPaneProcessosVendasController implements Initializable {

    @FXML
    private TableView<Venda> tableViewVendas;
    @FXML
    private TableColumn<Venda, Integer> tableColumnVendaCodigo;
    @FXML
    private TableColumn<Venda, LocalDate> tableColumnVendaData;
    @FXML
    private TableColumn<Venda, Venda> tableColumnVendaCliente;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelVendaCodigo;
    @FXML
    private Label labelVendaData;
    @FXML
    private Label labelVendaValor;
    @FXML
    private Label labelVendaPago;
    @FXML
    private Label labelVendaCliente;

    private List<Venda> listVendas;
    private ObservableList<Venda> observableListVendas;

    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final VendaDAO vendaDAO = new VendaDAO();
    private final ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendaDAO.setConnection(connection);
        carregarTableViewVendas();

        selecionarItemTableViewVendas(null);

        tableViewVendas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewVendas(newValue));

    }

    public void selecionarItemTableViewVendas(Venda venda) {
        if (venda != null) {
            labelVendaCodigo.setText(String.valueOf(venda.getCdVenda()));
            labelVendaData.setText(String.valueOf(venda.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            labelVendaValor.setText(String.format("%.2f", venda.getValor()));
            labelVendaPago.setText(String.valueOf(venda.getPago()));
            labelVendaCliente.setText(venda.getCliente().toString());
        } else {
            labelVendaCodigo.setText("");
            labelVendaData.setText("");
            labelVendaValor.setText("");
            labelVendaPago.setText("");
            labelVendaCliente.setText("");
        }
    }

    public void carregarTableViewVendas() {
        tableColumnVendaCodigo.setCellValueFactory(new PropertyValueFactory<>("cdVenda"));
        tableColumnVendaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnVendaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        listVendas = vendaDAO.listar();

        observableListVendas = FXCollections.observableArrayList(listVendas);
        tableViewVendas.setItems(observableListVendas);
    }

    @FXML
    public void handleButtonRemover() throws IOException, SQLException {
        Venda venda = tableViewVendas.getSelectionModel().getSelectedItem();
        if (venda != null) {
            connection.setAutoCommit(false);
            vendaDAO.setConnection(connection);
            itemDeVendaDAO.setConnection(connection);
            produtoDAO.setConnection(connection);
            for (ItemDeVenda listItemDeVenda : venda.getItensDeVenda()) {
                Produto produto = listItemDeVenda.getProduto();
                produto.setQuantidade(produto.getQuantidade() + listItemDeVenda.getQuantidade());
                produtoDAO.alterar(produto);
                itemDeVendaDAO.remover(listItemDeVenda);
            }
            vendaDAO.remover(venda);
            connection.commit();
            carregarTableViewVendas();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma venda na Tabela!");
            alert.show();
        }
    }
}