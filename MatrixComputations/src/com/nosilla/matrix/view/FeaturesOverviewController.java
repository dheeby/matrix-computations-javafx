package com.nosilla.matrix.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import com.nosilla.matrix.MainApp;
import com.nosilla.matrix.model.Operation;

public class FeaturesOverviewController {
	@FXML
	private TableView<Operation> binaryOpTable;
	@FXML
	private TableView<Operation> basicUnaryOpTable;
	@FXML
	private TableView<Operation> advancedUnaryOpTable;
	@FXML
	private TableColumn<Operation, String> binOpColumn;
	@FXML
	private TableColumn<Operation, String> basicUnaryOpColumn;
	@FXML
	private TableColumn<Operation, String> advancedUnaryOpColumn;
	
	@FXML
	private TextFlow opDescription;
	
	private MainApp mainApp;
	
	public FeaturesOverviewController() {
	}
	
	private void setOperationDescription(Operation operation) {
		if (operation != null) {
			Text text = new Text(operation.getDescription());
			opDescription.getChildren().clear();
			opDescription.getChildren().add(text);
		} else {
			opDescription.getChildren().clear();
		}
	}
	
	@FXML
	private void initialize() {
		binOpColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		basicUnaryOpColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		advancedUnaryOpColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
		setOperationDescription(null);
		
		binaryOpTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> setOperationDescription(newValue));
		
		basicUnaryOpTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> setOperationDescription(newValue));
		
		advancedUnaryOpTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> setOperationDescription(newValue));
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		binaryOpTable.setItems(mainApp.getBinaryOpData());
		basicUnaryOpTable.setItems(mainApp.getBasicUnaryOpData());
		advancedUnaryOpTable.setItems(mainApp.getAdvancedUnaryOpData());
	}
}
