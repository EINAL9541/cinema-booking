package cinemaProject;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import module.DBHundler;
import module.MovieList;

public class StaffMoviePage {
	private Label lname1,lgenre1,lsummary1,lname2,lgenre2,lsummary2,lname3,lgenre3,lsummary3,t1,t2,t3,lstaffName,llogout,lshowTime1,lshowTime2,lshowTime3;
	private Text tname1,tname2,tname3,tgenre1,tgenre2,tgenre3,tsummary1,tsummary2,tsummary3;
	private  ComboBox<String> cbtime1;
	private  ComboBox<String> cbtime2;
	private  ComboBox<String> cbtime3;
	private Button b1,b2,b3;
	private ImageView imgv1,imgv2,imgv3;
	private BorderPane moviePane;
	private GridPane movie1Pane,movie2Pane,movie3Pane;
	private FlowPane f1,f2,f3;
	private Stage stage2,st;
	private VBox middlePane;
	private HBox topPane;
	private static String theater,showTime;
	private static int name;
	ArrayList<MovieList> mv = new ArrayList<MovieList>();
	private static ArrayList al = new ArrayList<String>();
	
	public void setImage() {
		try {
			FileInputStream fs1 = new FileInputStream(mv.get(0).getmImage());
			Image img1 = new Image(fs1);
			imgv1 = new ImageView(img1);
			imgv1.setFitHeight(153);
			imgv1.setFitWidth(234);
			
			FileInputStream fs2 = new FileInputStream(mv.get(1).getmImage());
			Image img2 = new Image(fs2);
			imgv2 = new ImageView(img2);
			imgv2.setFitHeight(153);
			imgv2.setFitWidth(234);
			
			FileInputStream fs3 = new FileInputStream(mv.get(2).getmImage());
			Image img3 = new Image(fs3);
			imgv3 = new ImageView(img3);	
			imgv3.setFitHeight(153);
			imgv3.setFitWidth(234);
		}catch(Exception e)
		{
			
		}
	}
	
	public void  createNodes()
	{
		lname1 = new Label("Title");
		lgenre1 = new Label("Genre");
		lsummary1 = new Label("Summary");
		lname2 = new Label("Title");
		lgenre2 = new Label("Genre");
		lsummary2 = new Label("Summary");
		lname3 = new Label("Title");
		lgenre3 = new Label("Genre");
		lsummary3 = new Label("Summary");
		t1 = new Label("Theater 1");
		t2 = new Label("Theater 2");
		t3 = new Label("Theater 3");
		llogout = new Label("Logout");
		lshowTime1 = new Label("Show TIme");
		lshowTime2 = new Label("Show TIme");
		lshowTime3 = new Label("Show TIme");
		lstaffName = new Label(LogInPage.getStaffName());
		llogout.setOnMouseClicked(e->{
			stage2.hide();
			LogInPage.getSt().show();
		});
		
		
		mv = DBHundler.getAllMovie();
		tname1 = new Text(mv.get(0).getmTitle());
		tgenre1 = new Text(mv.get(0).getmGenre());
		tsummary1 = new Text(mv.get(0).getmSummary());
		tsummary1.setWrappingWidth(700);
		tname2 = new Text(mv.get(1).getmTitle());
		tgenre2 = new Text(mv.get(1).getmGenre());
		tsummary2 = new Text(mv.get(1).getmSummary());
		tsummary2.setWrappingWidth(700);
		tname3 = new Text(mv.get(2).getmTitle());
		tgenre3 = new Text(mv.get(2).getmGenre());
		tsummary3 = new Text(mv.get(2).getmSummary());
		tsummary3.setWrappingWidth(700);
		
		ArrayList al = new ArrayList<String>();
		al.add("1:00");
		al.add("5:00");
		cbtime1 = new ComboBox<String>(FXCollections.observableArrayList(al));
		
		cbtime1.setOnAction(e->{
			if(cbtime1.getValue().equals(al.get(0)))
			{
				stage2.hide();
				theater = t1.getText();
				showTime = (String) al.get(0);
				name = 0;
				
				new Seat();
				
			}
			else {
				stage2.hide();
				theater = t1.getText();
				showTime = (String) al.get(1);
				name=0;
				new Seat();
			}
			
		});
		cbtime2 = new ComboBox<String>(FXCollections.observableArrayList(al));
		cbtime2.setOnAction(e->{
			if(cbtime2.getValue().equals(al.get(0)))
			{
				stage2.hide();
				theater = t2.getText();
				showTime = (String) al.get(0);
				name=1;
				new Seat();
				
			}
			else {
				stage2.hide();
				theater = t2.getText();
				showTime = (String) al.get(1);
				name=1;
				new Seat();
			}
			
		});
		
		cbtime3 = new ComboBox<String>(FXCollections.observableArrayList(al));
		cbtime3.setOnAction(e->{
			if(cbtime3.getValue().equals(al.get(0)))
			{
				stage2.hide();
				theater = t3.getText();
				showTime = (String) al.get(0);
				name=2;
				new Seat();
				
			}
			else {
				stage2.hide();
				theater = t3.getText();
				showTime = (String) al.get(1);
				name=2;
				new Seat();
			}
			
		});
		
	}
	
	public void defineLayout()
	{
		movie1Pane = new GridPane();
		movie1Pane.setVgap(20);
		movie1Pane.setHgap(10);
		movie1Pane.add(lname1, 0, 0);
		movie1Pane.add(tname1, 3, 0);
		movie1Pane.add(lgenre1, 0, 1);
		movie1Pane.add(tgenre1, 3, 1);
		movie1Pane.add(lsummary1, 0, 2);
		movie1Pane.add(tsummary1, 3, 2);
		movie1Pane.add(lshowTime1, 0, 3);
		movie1Pane.add(cbtime1, 3, 3);
		movie1Pane.setPrefSize(800,100);
		
		movie2Pane = new GridPane();
		movie2Pane.setVgap(20);
		movie2Pane.setHgap(10);
		movie2Pane.add(lname2, 0, 0);
		movie2Pane.add(tname2, 3, 0);
		movie2Pane.add(lgenre2, 0, 1);
		movie2Pane.add(tgenre2, 3, 1);
		movie2Pane.add(lsummary2, 0, 2);
		movie2Pane.add(tsummary2, 3, 2);
		movie2Pane.add(lshowTime2, 0, 3);
		movie2Pane.add(cbtime2, 3, 3);
		movie2Pane.setPrefSize(800,100);
		
		movie3Pane = new GridPane();
		movie3Pane.setVgap(20);
		movie3Pane.setHgap(10);
		movie3Pane.add(lname3, 0, 0);
		movie3Pane.add(tname3, 3, 0);
		movie3Pane.add(lgenre3, 0, 1);
		movie3Pane.add(tgenre3, 3, 1);
		movie3Pane.add(lsummary3, 0, 2);
		movie3Pane.add(tsummary3, 3, 2);
		movie3Pane.add(lshowTime3, 0, 3);
		movie3Pane.add(cbtime3, 3, 3);
		movie3Pane.setPrefSize(800,100);
		
		
		setImage();
		f1 = new FlowPane(t1,imgv1,movie1Pane);
		f1.setPrefHeight(100);
		f1.setHgap(40);
		f1.setAlignment(Pos.CENTER);
		f2 = new FlowPane(t2,imgv2,movie2Pane);
		f2.setAlignment(Pos.CENTER);
		f2.setHgap(40);
		f2.setPrefHeight(100);
		f3 = new FlowPane(t3,imgv3,movie3Pane);
		f3.setAlignment(Pos.CENTER);
		f3.setHgap(40);
		f2.setPrefHeight(100);
		
		middlePane = new VBox(50,f1,f2,f3);
		
		topPane = new HBox(950,lstaffName,llogout);
		topPane.setPadding(new Insets(20));
		
		moviePane = new BorderPane();
		moviePane.setCenter(middlePane);
		moviePane.setTop(topPane);
		
		URL url = this.getClass().getResource("moviePageStyle.css");
		moviePane.getStylesheets().add(url.toExternalForm());
		setStyle();
	}
	
	
	public void setStyle()
	{
		lname1.getStyleClass().add("option1");
		lgenre1.getStyleClass().add("option1");
		lsummary1.getStyleClass().add("option1");
		lname2.getStyleClass().add("option1");
		lgenre2.getStyleClass().add("option1");
		lsummary2.getStyleClass().add("option1");
		lname3.getStyleClass().add("option1");
		lgenre3.getStyleClass().add("option1");
		lsummary3.getStyleClass().add("option1");
		lshowTime1.getStyleClass().add("option1");
		lshowTime2.getStyleClass().add("option1");
		lshowTime3.getStyleClass().add("option1");
		
		moviePane.setId("backGround1");
		t1.getStyleClass().add("Theater");
		t2.getStyleClass().add("Theater");
		t3.getStyleClass().add("Theater");
		
		cbtime1.getStyleClass().add("ShowTime");
		cbtime2.getStyleClass().add("ShowTime");
		cbtime3.getStyleClass().add("ShowTime");
		
		
		lstaffName.setId("staffName2");
		llogout.setId("logout4");
		topPane.setId("backGround6");
	}
	
	
	public StaffMoviePage()
	{
		stage2 = new Stage();
		createNodes();
		defineLayout();
		Scene sc = new Scene(moviePane,1366,700);		
		stage2.setScene(sc);
		stage2.setTitle("Register");
		stage2.show();
	}
	
		public static String getTheater() {
		return theater;
	}

	public static void setTheater(String theater) {
		StaffMoviePage.theater = theater;
	}

	public static String getShowTime() {
		return showTime;
	}

	public static void setShowTime(String showTime) {
		StaffMoviePage.showTime = showTime;
	}

	public static int getName() {
		return name;
	}

	public static void setName(int name) {
		StaffMoviePage.name = name;
	}


	
	

}
