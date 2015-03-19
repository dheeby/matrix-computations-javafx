package com.nosilla.matrix;

import java.io.IOException;

import com.nosilla.matrix.model.Operation;
import com.nosilla.matrix.view.FeaturesOverviewController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private String appTitle = "Matrix Computations";
	private Stage primaryStage;
	private BorderPane entranceSceneLayout;
	private ObservableList<Operation> binaryOpData = FXCollections.observableArrayList();
	private ObservableList<Operation> basicUnaryOpData = FXCollections.observableArrayList();
	private ObservableList<Operation> advancedUnaryOpData = FXCollections.observableArrayList();
	
	public MainApp() {
		binaryOpData.add(new Operation("Add", "Adds two matrices."));
		binaryOpData.add(new Operation("Subtract", "Subtracts two matrices."));
		binaryOpData.add(new Operation("Multiply", "Multiplies two matrices."));
		binaryOpData.add(new Operation("Dot Product", "Dot product of two matrices."));
		binaryOpData.add(new Operation("Cross Product", "Cross product of two matrices."));
		basicUnaryOpData.add(new Operation("Row Swap", "Swaps rows in a matrix."));
		basicUnaryOpData.add(new Operation("Row Scalar", "Multiplies a row by a scalar."));
		basicUnaryOpData.add(new Operation("Row Add", "Adds one row to another."));
		advancedUnaryOpData.add(new Operation("Echelon Form", "Computes the echelon form of a matrix."));
		advancedUnaryOpData.add(new Operation("RREF", "Computes the row reduced echelon form of a matrix."));
	}
	
	public ObservableList<Operation> getBinaryOpData() {
		return binaryOpData;
	}
	
	public ObservableList<Operation> getBasicUnaryOpData() {
		return basicUnaryOpData;
	}
	
	public ObservableList<Operation> getAdvancedUnaryOpData() {
		return advancedUnaryOpData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(appTitle);
		
		initEntranceSceneLayout();
		
		showFeaturesOverview();
	}
	
	public void initEntranceSceneLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/EntranceSceneLayout.fxml"));
			entranceSceneLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(entranceSceneLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showFeaturesOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/FeaturesOverview.fxml"));
			AnchorPane featuresOverview = (AnchorPane) loader.load();
			
			entranceSceneLayout.setCenter(featuresOverview);
			
			FeaturesOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
