package cinemaProject;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import module.*;

public class AddMoviePage{
	private Label llabel,limage,lname,lgenre,lduration,lsummary,ldate,lerr1,lerr2,lerr3,lerr4,lerr5,lerr6;
	private TextField timage,tname,tgenre,tduration;
	private String value2;
	private DatePicker dp ;
	private TextArea tsummary;
	private Button baddMovie,bclear,bbrowse;
	private FlowPane fimagePane,buttonPane,mainPane;
	private HBox himagePane,imgvPane;
	private ImageView imgv;
	private GridPane centerPane;
	private BorderPane addMoviePane;
	private VBox summaryPane,verr1,verr2,verr3,verr4,verr5,verr6;
	private Stage st;
	Desktop desktop = Desktop.getDesktop();
	private static int mid;
	
	public void createNodes()
	{
		lerr1 = new Label();
		lerr2 = new Label();
		lerr3 = new Label();
		lerr4 = new Label();
		lerr5 = new Label();
		lerr6 = new Label();
		llabel = new Label("Add New Movie");
		llabel.setPadding(new Insets(10,20,0,20));
		limage = new Label("Image");
		lname = new Label("Movie Name");
		lgenre = new Label("Genre");
		lduration = new Label("Duration");
		lsummary = new Label("Summary");
		ldate = new Label("Date");
		
		timage = new TextField();
		timage.setPromptText("Path Of Selected File");
		tname = new TextField();
		tname.setMaxWidth(150);
		tgenre = new TextField();
		tgenre.setMaxWidth(150);
		tduration = new TextField();
		tduration.setMaxWidth(150);
		
		dp = new DatePicker();
		dp.setMaxWidth(175);
		tsummary = new TextArea();
		
		baddMovie = new Button("Add Movie");
		baddMovie.setMaxWidth(100);
		baddMovie.setOnAction(e->{
			try{
				if(tname.getText().isEmpty())
				{
					lerr1.setText("Fill all the requirements!!!!!");
				}
				else if(timage.getText().isEmpty()) {
					lerr2.setText("Please add the image");
					lerr1.setText("");
				}
				else if(tduration.getText().isEmpty()){
					lerr3.setText("Fill the Duration!");
					lerr2.setText("");
				}
				else if(tgenre.getText().isEmpty()){
					lerr4.setText("Please set the genre");
					lerr3.setText("");
				}
				else if(tsummary.getText().isEmpty()) {
					lerr5.setText("Please write summary");
					lerr4.setText("");
				}
				else {
					lerr1.setText("");
					lerr2.setText("");
					lerr3.setText("");
					lerr4.setText("");
					lerr5.setText("");
					lerr6.setText("");
					
					insert();
				}
				
			}catch(NullPointerException f){
			lerr6.setText("Fill the Date!!!!");
			lerr4.setText("");
			lerr5.setText("");
			}catch(Exception g){
			lerr3.setText("Fill only numbers in Duration!");
			lerr6.setText("");
			lerr4.setText("");
			};
		});
		bclear = new Button("Clear");
		bclear.setMinWidth(90);
		bclear.setOnAction(e->{
			clear();
		});

		bbrowse = new Button("Browse...");
		bbrowse.setOnAction(e->{
			browse();
		});
		
	}	
	public void defineLayout()
	{
		
		
		verr1 = new VBox(1,tname,lerr1);
		verr2 = new VBox(1,timage,lerr2);
		verr3 = new VBox(1,tduration,lerr3);
		verr4 = new VBox(1,tgenre,lerr4);
		verr5 = new VBox(1,tsummary,lerr5);
		verr6 = new VBox(1,dp,lerr6);
		
		//setImage();
		himagePane = new HBox(verr2,bbrowse);
				fimagePane = new FlowPane(limage,himagePane);
				fimagePane.setHgap(50);
				fimagePane.setAlignment(Pos.CENTER_LEFT);
		
		
		centerPane = new GridPane();
		centerPane.setHgap(50);
		centerPane.setVgap(15);
		centerPane.add(lname, 0, 1);
		centerPane.add(lgenre, 1, 1);	
		centerPane.add(verr1, 0, 2);
		centerPane.add(verr4, 1, 2);
		centerPane.add(lduration, 0, 3);
		centerPane.add(ldate, 1, 3);
		centerPane.add(verr3, 0, 4);
		centerPane.add(verr6, 1, 4);
	
		summaryPane = new VBox(20,lsummary,verr5);
		
		
		buttonPane = new FlowPane(10,20,baddMovie,bclear);
		buttonPane.setPadding(new Insets(0, 0, 50, 0));
		buttonPane.setAlignment(Pos.TOP_CENTER);
		buttonPane.setHgap(100);
		mainPane = new FlowPane(fimagePane,centerPane,summaryPane);
		mainPane.setHgap(300);
		mainPane.setVgap(15);
		mainPane.setAlignment(Pos.CENTER_LEFT);
		mainPane.setPadding(new Insets(0, 20, 20, 50));
		
		
		addMoviePane = new BorderPane();
		addMoviePane.setTop(llabel);
		addMoviePane.setCenter(mainPane);
		addMoviePane.setBottom(buttonPane);
		
		URL url = this.getClass().getResource("addMoviePageStyle.css");
		addMoviePane.getStylesheets().add(url.toExternalForm());
		setStyle();
	}

	public void setDate()
	{
			createNodes();
			dp.setDayCellFactory(picker -> new DateCell() {
			public void updateItem(LocalDate date, boolean empty)
			{
				super.updateItem(date, empty);
				LocalDate today = LocalDate.now();
				setDisable(empty || date.compareTo(today)<0);
					
			}});
	}
	
	public void  clear()
	{
		timage.setText("");
		tname.setText("");
		tduration.setText("");
		tgenre.setText("");
		tsummary.setText("");
		dp.setValue(null);
		imgv.setVisible(false);
	}
	
	public void browse()
	{
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Dialog Box");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		File f = chooser.showOpenDialog(st);
		if(f != null) {
			try {
				FileInputStream fs;
				timage.setText(f.getAbsolutePath());
				fs = new FileInputStream(timage.getText());
				Image img = new Image(fs);
				imgv = new ImageView(img);
				imgv.setFitHeight(153);
				imgv.setFitWidth(234);
				imgv.setPreserveRatio(false);
				imgvPane = new HBox(imgv);
				imgvPane.setAlignment(Pos.TOP_LEFT);
				imgvPane.setPadding(new Insets(20, 200, 0, 0));
				addMoviePane.setRight(imgvPane);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	public void insert()
	{
		Integer value1 = Integer.parseInt(tduration.getText());
		value2 = dp.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DBHundler.updateMovie(mid, tname.getText(),tgenre.getText(), tsummary.getText(),timage.getText(), value1,value2);
		
		timage.setText("");
		tduration.setText("");
		tgenre.setText("");
		tsummary.setText("");
		dp.setValue(null);
		imgv.setVisible(false);
		tname.setText("");
	}

	
	public void setStyle()
	{
		llabel.setId("label1");
		addMoviePane.setId("backGround2");
		
		lname.getStyleClass().add("gold1");
		lgenre.getStyleClass().add("gold1");
		limage.getStyleClass().add("gold1");
		ldate.getStyleClass().add("gold1");
		lsummary.getStyleClass().add("gold1");
		lduration.getStyleClass().add("gold1");
		
		baddMovie.setId("button2");
		bclear.setId("button3");
		lerr1.getStyleClass().add("lerr");
		lerr2.getStyleClass().add("lerr");
		lerr3.getStyleClass().add("lerr");
		lerr4.getStyleClass().add("lerr");
		lerr5.getStyleClass().add("lerr");
		lerr6.getStyleClass().add("lerr");
		
	}
	
	public BorderPane getAddMoviePane() {
		createNodes();
		setDate();
		defineLayout();
		return addMoviePane;
	}
	
	public void setAddMoviePane(BorderPane addMoviePane) {
		this.addMoviePane = addMoviePane;
	}
	public static int getMid() {
		return mid;
	}
	public static void setMid(int mid) {
		AddMoviePage.mid = mid;
	}
	
	

}
