package cinemaProject;

import java.net.URL;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import module.*;

public class StaffMemberManagement{
	private TableView<StaffMember> tvStaff;
	private ArrayList<StaffMember> alt;
	
	private Label lname,lphoneNumber,lpassword,lsalary;
	private TextField tname,tphoneNumber,tpassword,tsalary,tdelet;
	private Button bregister,bdelet,bshowall,bupdate;
	private GridPane registerPane;
	private HBox hPane;
	private FlowPane fPane;
	private BorderPane mainPane;
	
	public void createNodes()
	{
		lname = new Label("Staff Name");
		lphoneNumber = new Label("Phone Number");
		lpassword = new Label("Password");
		lsalary = new Label("Salary");
		
		tname = new TextField();
		tphoneNumber = new TextField();
		tpassword = new TextField();
		tsalary = new TextField();
		tdelet = new TextField();
		tdelet.setPromptText("Enter ID for delete");
		
		bregister = new Button("Register");
		bregister.setPrefWidth(70);
		bdelet = new Button("Delete Staff");
		bdelet.setPrefWidth(120);
		bshowall = new Button("Show All");
		bshowall.setPrefWidth(120);
		bupdate = new Button("Update");
		bupdate.setPrefWidth(120);
		
	}
	
	public void addTable()
	{
		tvStaff = new TableView<StaffMember>();
		TableColumn<StaffMember, Integer> idCol = new TableColumn<StaffMember, Integer>("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<StaffMember, Integer>("sid"));
		idCol.setPrefWidth(100);
		
		TableColumn<StaffMember, String> nameCol = new TableColumn<StaffMember, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("sname"));
		nameCol.setPrefWidth(100);
		
		TableColumn<StaffMember, String> phNumberCol = new TableColumn<StaffMember, String>("Phone Number");
		phNumberCol.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("sphonenumber"));
		phNumberCol.setPrefWidth(100);
		
		TableColumn<StaffMember, String> passwordCol = new TableColumn<StaffMember, String>("Password");
		passwordCol.setCellValueFactory(new PropertyValueFactory<StaffMember, String>("spassword"));
		passwordCol.setPrefWidth(100);
		
		TableColumn<StaffMember, Integer> salaryCol = new TableColumn<StaffMember, Integer>("Salary");
		salaryCol.setCellValueFactory(new PropertyValueFactory<StaffMember, Integer>("ssalary"));
		salaryCol.setPrefWidth(100);
		 
		tvStaff.getColumns().add(idCol);
		tvStaff.getColumns().add(nameCol);
		tvStaff.getColumns().add(phNumberCol);
		tvStaff.getColumns().add(passwordCol);
		tvStaff.getColumns().add(salaryCol);
	}
	
	public void setAction()
	{
		bregister.setOnAction(e->{
			Integer value1 = Integer.valueOf(tsalary.getText());
			DBHundler.insertStaff(tname.getText(), tphoneNumber.getText(), tpassword.getText(), value1);
			tname.setText("");
			tphoneNumber.setText("");
			tpassword.setText("");
			tsalary.setText("");
			tname.requestFocus();
		});
		
		bupdate.setOnAction(e->{
			alt = DBHundler.getAllStaff();
			tvStaff.getItems().clear();
			tvStaff.getItems().addAll(alt);
			
		});
		
		bshowall.setOnAction(e->{
			alt = DBHundler.getAllStaff();
			tvStaff.getItems().clear();
			tvStaff.getItems().addAll(alt);
			
		});
		
		bdelet.setOnAction(e->{
			  Integer value = Integer.valueOf(tdelet.getText());
			  DBHundler.deleteStaff(value);
		});
	}
	
	public void defineLayout()
	{
		addTable();
		registerPane = new GridPane();
		registerPane.setVgap(10);
		registerPane.setHgap(50);
		
		registerPane.add(lname, 0, 0);
		registerPane.add(tname, 1, 0);
		
		registerPane.add(lphoneNumber, 0, 1);
		registerPane.add(tphoneNumber, 1, 1);
		
		registerPane.add(lpassword, 0, 2);
		registerPane.add(tpassword, 1, 2);
		
		registerPane.add(lsalary, 0, 3);
		registerPane.add(tsalary, 1, 3);
		
		registerPane.add(bregister, 2, 4);
		registerPane.setAlignment(Pos.TOP_CENTER);
		registerPane.setPadding(new Insets(105, 0, 0, 0));
		hPane = new HBox(35,tdelet,bdelet,bshowall,bupdate);
		tvStaff.setPrefSize(650, 500);
		fPane = new FlowPane(hPane,tvStaff);
		fPane.setAlignment(Pos.BOTTOM_CENTER);
		fPane.setVgap(20);
		fPane.setPadding(new Insets(0, 10, 0, 10));
		
		mainPane = new BorderPane();
		mainPane.setRight(registerPane);
		mainPane.setCenter(fPane);
		URL url = this.getClass().getResource("staffStyle.css");
		mainPane.getStylesheets().add(url.toExternalForm());
		setStyle();
	}
	
	public void setStyle()
	{
		mainPane.setId("backGround");
		lname.setId("lname");
		lphoneNumber.setId("lphoneNumber");
		lpassword.setId("lpassword");
		lsalary.setId("lsalary");	
	}
	
	public BorderPane getMainPane() {
		createNodes();
		defineLayout();
		setAction();
		return mainPane;
	}

	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}


}
