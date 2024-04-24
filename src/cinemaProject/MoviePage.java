package cinemaProject;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import module.*;

public class MoviePage {
	private Label lname1,lgenre1,lsummary1,lname2,lgenre2,lsummary2,lname3,lgenre3,lsummary3;
	private Text tname1,tname2,tname3,tgenre1,tgenre2,tgenre3,tsummary1,tsummary2,tsummary3;
	private static Button bchange1,bchange2,bchange3;
	private ImageView imgv1,imgv2,imgv3;
	private BorderPane moviePane;
	private GridPane movie1Pane,movie2Pane,movie3Pane;
	private FlowPane f1,f2,f3;
	ArrayList<MovieList> mv = new ArrayList<MovieList>();
	
	
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
		
		bchange1 = new Button("Change");
		bchange2 = new Button("Change");
		bchange3 = new Button("Change");
		
		
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
		movie1Pane.add(bchange1, 3, 3);
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
		movie2Pane.add(bchange2, 3, 3);
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
		movie3Pane.add(bchange3, 3, 3);
		movie3Pane.setPrefSize(800,100);
		
		
		setImage();
		f1 = new FlowPane(imgv1,movie1Pane);
		f1.setPrefHeight(100);
		f1.setHgap(40);
		f1.setAlignment(Pos.CENTER);
		f2 = new FlowPane(imgv2,movie2Pane);
		f2.setAlignment(Pos.CENTER);
		f2.setHgap(40);
		f2.setPrefHeight(100);
		f3 = new FlowPane(imgv3,movie3Pane);
		f3.setAlignment(Pos.CENTER);
		f3.setHgap(40);
		f2.setPrefHeight(100);
		
		moviePane = new BorderPane();
		
		moviePane.setTop(f1);
		moviePane.setCenter(f2);
		moviePane.setBottom(f3);
		
		
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
		moviePane.setId("backGround1");
		bchange1.getStyleClass().add("button1");
		bchange2.getStyleClass().add("button1");
		bchange3.getStyleClass().add("button1");
		
	}

	public BorderPane getMoviePane() {
		createNodes();
		defineLayout();
		return moviePane;
		
		
	}

	public void setMoviePane(BorderPane moviePane) {
		this.moviePane = moviePane;
	}

	public static Button getBchange1() {
		return bchange1;
	}

	public static void setBchange1(Button bchange1) {
		MoviePage.bchange1 = bchange1;
	}

	public static Button getBchange2() {
		return bchange2;
	}

	public static void setBchange2(Button bchange2) {
		MoviePage.bchange2 = bchange2;
	}

	public static Button getBchange3() {
		return bchange3;
	}

	public static void setBchange3(Button bchange3) {
		MoviePage.bchange3 = bchange3;
	}	
}
