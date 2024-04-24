package cinemaProject;

import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import module.*;

import java.io.*;

public class LogInPage extends Application {
	
	private Label lname,lpassword,lcinemaName,lrole,lerr;
	private TextField tname;
	private PasswordField ppassword;
	private RadioButton radmin,rstaff;
	private Button btnLogin;
	private ToggleGroup tgRole;
	private static int adminId=-1,staffId=-1;
	private static String adminName,staffName;
	private static Stage st;
	private GridPane loginPane;
	private BorderPane mainPane;
	private TilePane rolePane;
	private FlowPane buttonPane,headerPane;
	private VBox middlePane;
	
	public void createNodes() {
		lname = new Label("User Name");
		lcinemaName = new Label("Watch Me");
		lpassword =  new Label("Password");
		lrole = new Label("Role");
		btnLogin = new Button("LogIn");
		btnLogin.setOnAction(e->{
			if(radmin.isSelected()) {
				
				adminLogIn();
				
				
			}
			else if(rstaff.isSelected()){
				staffLogIn();
				lname.setText("");
				lpassword.setText("");
			}
			else {
				lerr.setText("Plese choose user type!!");
			}
		});
		lerr = new Label();
		
		tname = new TextField();
		ppassword = new PasswordField();
		
		tgRole = new ToggleGroup();
		radmin = new RadioButton("Admin");
		radmin.setToggleGroup(tgRole);
		rstaff = new RadioButton("Staff");
		rstaff.setToggleGroup(tgRole);
		
	}
	
	public void defineLayout() {
		rolePane = new TilePane(20, 20, radmin, rstaff);
		loginPane = new GridPane();
		buttonPane = new FlowPane(btnLogin);
		mainPane = new BorderPane();
		headerPane = new FlowPane(lcinemaName);
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("Image/watchme.png");
			Image img=new Image(fis);
			ImageView imgView=new ImageView(img);
			imgView.setFitHeight(100);
			imgView.setFitWidth(150);
			middlePane = new VBox(headerPane, imgView);
			middlePane.setAlignment(Pos.CENTER);
		} catch (FileNotFoundException e) {
			
		}		

		loginPane.add(lname, 0, 0);
		loginPane.add(tname, 1, 0);
		
		loginPane.add(lpassword, 0, 1);
		loginPane.add(ppassword, 1, 1);
		
		loginPane.add(lrole, 0, 2);
		loginPane.add(rolePane, 1, 2);
		
		loginPane.add(lerr, 1, 3);
		
		loginPane.setVgap(20);
		loginPane.setHgap(20);
		loginPane.setAlignment(Pos.CENTER);
		
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(20));
		
		headerPane.setAlignment(Pos.CENTER);
		headerPane.setPadding(new Insets(20));
		
		
		mainPane.setTop(middlePane);
//		mainPane.setTop(cLogo);
		mainPane.setCenter(loginPane);
		mainPane.setBottom(buttonPane);
		
		URL url = this.getClass().getResource("loginPageStyle.css");
		mainPane.getStylesheets().add(url.toExternalForm());
		setStyle();
		
	}
	
	public void setStyle() {
		lcinemaName.setId("cinemaName");
		mainPane.setId("main");
		btnLogin.setId("btn");
		lname.getStyleClass().add("labelLogIn");
		lpassword.getStyleClass().add("labelLogIn");
		lrole.getStyleClass().add("labelLogIn");
		radmin.getStyleClass().add("labelLogIn");
		rstaff.getStyleClass().add("labelLogIn");
		lerr.setId("err");
	}
	
	public void adminLogIn()
	{
		String n=tname.getText();
		String p=ppassword.getText();
		adminName=n;
		adminId=DBHundler.adminLogIn(n, p);
		if(adminId!=-1)
		{
			lname.setText("");
			lpassword.setText("");
			lerr.setText("");
			radmin.setSelected(false);
			st.hide();
			new AdminPage();
		}
		else {
			lerr.setText("Wrong username or password!!");
		}
	}
	
	public void staffLogIn()
	{
		String n=tname.getText();
		String p=ppassword.getText();
		staffName=n;
		staffId=DBHundler.staffLogIn(n, p);
		if(staffId!=-1)
		{
			lerr.setText("");
			rstaff.setSelected(false);
			st.hide();;
			new StaffMoviePage();
		}
		else {
			lerr.setText("Wrong username or password!!");
		}
	}
	
	public static int getAdminId() {
		return adminId;
	}

	public static void setAdminId(int adminId) {
		LogInPage.adminId = adminId;
	}

	public static String getAdminName() {
		return adminName;
	}

	public static void setAdminName(String adminName) {
		LogInPage.adminName = adminName;
	}
	
	public static int getStaffId() {
		return staffId;
	}

	public static void setStaffId(int staffId) {
		LogInPage.staffId = staffId;
	}

	public static String getStaffName() {
		return staffName;
	}

	public static void setStaffName(String staffName) {
		LogInPage.staffName = staffName;
	}

	@Override
	public void start(Stage stage) throws Exception {
		createNodes();
		defineLayout();
		setStyle();
		Scene sc=new Scene(mainPane,620,500);
		stage.setScene(sc);
		stage.setTitle("LogIn  Page");
		stage.show();
		st=stage;
	}
	
	

	public static void main(String[] args) {
		Application.launch(args);

	}

	public static Stage getSt() {
		return st;
	}

	public static void setSt(Stage st) {
		LogInPage.st = st;
	}
	
	

}
