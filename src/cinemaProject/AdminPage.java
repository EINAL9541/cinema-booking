package cinemaProject;

import java.io.*;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminPage {
	private Label lStaffMember,lSales,lChangeMovie,lChangePrice,lCinemaName,lLogout;
	private BorderPane mainPane;
	private VBox labelPane;
	private HBox logoPane,logoutPane;
	private Stage stage;
	
	public void createNodes() {
		lStaffMember = new Label("Staff Member Management");
		lStaffMember.setPrefWidth(230);
		lStaffMember.setOnMouseClicked(e->{
			mainPane.setCenter(null);
			mainPane.setCenter(new StaffMemberManagement().getMainPane());
		});
		
		lSales = new Label("Sales");
		lSales.setPrefWidth(230);
		lSales.setOnMouseClicked(e->{
			mainPane.setCenter(null);
			mainPane.setCenter(new Sales().getMainPane());
		});
		
		lChangeMovie = new Label("Change Movie");
		lChangeMovie.setPrefWidth(230);
		lChangeMovie.setOnMouseClicked(e->{
			mainPane.setCenter(null);
			mainPane.setCenter(new MoviePage().getMoviePane());
			
			MoviePage.getBchange1().setOnAction(g->{
				mainPane.setCenter(null);
				mainPane.setCenter(new AddMoviePage().getAddMoviePane());
				AddMoviePage.setMid(0);
			});
			
			MoviePage.getBchange2().setOnAction(g->{
				mainPane.setCenter(null);
				mainPane.setCenter(new AddMoviePage().getAddMoviePane());
				AddMoviePage.setMid(1);
			});
			
			MoviePage.getBchange3().setOnAction(g->{
				mainPane.setCenter(null);
				mainPane.setCenter(new AddMoviePage().getAddMoviePane());	
				AddMoviePage.setMid(2);
			});
			
		});
		
		lChangePrice = new Label("Change Price");
		lChangePrice.setPrefWidth(230);
		lChangePrice.setOnMouseClicked(e->{
			mainPane.setCenter(null);
			mainPane.setCenter(new ChangePrice().getMainPane());
		});
		
		lCinemaName = new Label("WatchMe");
		
		lLogout = new Label("Logout");
		lLogout.setOnMouseClicked(e->{
			stage.hide();
			LogInPage.getSt().show();
		});
	}
	
	public void defineLayout() {
		mainPane = new BorderPane();
		labelPane = new VBox(20, lStaffMember, lSales, lChangeMovie, lChangePrice);
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("Image/watchme.png");
			Image img=new Image(fis);
			ImageView imgView=new ImageView(img);
			imgView.setFitHeight(50);
			imgView.setFitWidth(80);
			logoPane  = new HBox(20, imgView, lCinemaName);
			logoutPane = new HBox(900,logoPane,lLogout);
			logoutPane.setPadding(new Insets(20));
			
			
		} catch (FileNotFoundException e) {
			
		}
		
		labelPane.setPadding(new Insets(20));
		labelPane.setAlignment(Pos.TOP_CENTER);
		
		mainPane.setLeft(labelPane);
		mainPane.setTop(logoutPane);
		mainPane.setCenter(new StaffMemberManagement().getMainPane());
		
	}
	
	public void setStyle() {
		lCinemaName.setId("cinemaName");
		lStaffMember.getStyleClass().add("option");
		lSales.getStyleClass().add("option");
		lChangeMovie.getStyleClass().add("option");
		lChangePrice.getStyleClass().add("option");
		logoutPane.setId("logoBg");
		labelPane.setId("leftPaneBg");
		lLogout.setId("logout1");
	}
	

//	public void start(Stage stage) throws Exception {
//		createNodes();
//		defineLayout();
//		Scene sc = new Scene(mainPane, 1366, 700);
//		URL url = this.getClass().getResource("adminPageStyle.css");
//		sc.getStylesheets().add(url.toExternalForm());
//		setStyle();
//		stage.setScene(sc);
//		stage.setTitle("Admin Page");
//		stage.show();
//	}

	public AdminPage()
	{
		stage = new Stage();
		createNodes();
		defineLayout();
		Scene sc = new Scene(mainPane, 1366, 700);
		URL url = this.getClass().getResource("adminPageStyle.css");
		sc.getStylesheets().add(url.toExternalForm());
		setStyle();
		stage.setScene(sc);
		stage.setTitle("Admin Page");
		stage.show();

	}


}
