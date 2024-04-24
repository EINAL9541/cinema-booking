package cinemaProject;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import module.*;


public class Sales {
	
	private TableView<Sale> tvSale;
	private BarChart income;
	private VBox mainPane;
	private Label label1;
	private HBox labelBox;
	ArrayList<DayIncome> ms = new ArrayList<DayIncome>();
	ArrayList<Sale> mss = new ArrayList<Sale>();
	
	public void lineChart()
	{
		ms = DBHundler.getIncome();
		CategoryAxis xa = new CategoryAxis();
		xa.setLabel("Date");
		
		NumberAxis ya = new NumberAxis();
		ya.setLabel("Income");
		
		income = new BarChart(xa,ya);
		
		XYChart.Series<String, Integer> date=new Series<>();
		date.setName("Date");
		
		date.getData().add(new XYChart.Data(ms.get(ms.size()-10).getDay(),ms.get(ms.size()-10).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-9).getDay(),ms.get(ms.size()-9).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-8).getDay(),ms.get(ms.size()-8).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-7).getDay(),ms.get(ms.size()-7).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-6).getDay(),ms.get(ms.size()-6).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-5).getDay(),ms.get(ms.size()-5).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-4).getDay(),ms.get(ms.size()-4).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-3).getDay(),ms.get(ms.size()-3).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-2).getDay(),ms.get(ms.size()-2).getIncome()));
		date.getData().add(new XYChart.Data(ms.get(ms.size()-1).getDay(),ms.get(ms.size()-1).getIncome()));
		
		income.getData().addAll(date);
		income.setMaxWidth(500);
		
	}
	
	public void addTable()
	{
		tvSale = new TableView<Sale>();
		
		TableColumn<Sale, Integer> idCol = new TableColumn<Sale, Integer>("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("sid"));
		idCol.setSortable(true);
		idCol.setPrefWidth(100);
		
		TableColumn<Sale, String> seatCol = new TableColumn<Sale, String>("Seat Name");
		seatCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("sname"));
		seatCol.setPrefWidth(100);
		
		TableColumn<Sale, String> theraterCol = new TableColumn<Sale, String>("Therater");
		theraterCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("stherater"));
		theraterCol.setPrefWidth(100);
		
		TableColumn<Sale, String> showCol = new TableColumn<Sale, String>("Show Time");
		showCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("sshowtime"));
		showCol.setPrefWidth(100);
		
		TableColumn<Sale, String> dateCol = new TableColumn<Sale, String>("Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("sdate"));
		dateCol.setSortable(true);
		dateCol.setPrefWidth(100);
		
		TableColumn<Sale, String> reserveCol = new TableColumn<Sale, String>("Reserve");
		reserveCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("sreserve"));
		reserveCol.setPrefWidth(100);
		
		TableColumn<Sale, String> nameCol = new TableColumn<Sale, String>("Movie Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("smname"));
		nameCol.setPrefWidth(100);
		
		TableColumn<Sale, String> showDateCol = new TableColumn<Sale, String>("Show Date");
		showDateCol.setCellValueFactory(new PropertyValueFactory<Sale, String>("sshowTime"));
		showDateCol.setPrefWidth(100);
		
		TableColumn<Sale, Integer> priceCol = new TableColumn<Sale, Integer>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("sprice"));
		priceCol.setPrefWidth(100);
		
		tvSale.getColumns().add(idCol);
		tvSale.getColumns().add(seatCol);
		tvSale.getColumns().add(theraterCol);
		tvSale.getColumns().add(showCol);
		tvSale.getColumns().add(dateCol);
		tvSale.getColumns().add(reserveCol);
		tvSale.getColumns().add(nameCol);
		tvSale.getColumns().add(showDateCol);
		tvSale.getColumns().add(priceCol);
		
		mss = DBHundler.getAllSaleTable();
		tvSale.getItems().addAll(mss);
		
	}
	
	public void defineLayout()
	{
		label1 = new Label("Daily Income");
		
		labelBox = new HBox(50,label1,income);
		
		
		mainPane = new VBox(20,labelBox,tvSale);
		mainPane.setAlignment(Pos.CENTER);
		URL url = this.getClass().getResource("saleStyle.css");
		mainPane.getStylesheets().add(url.toExternalForm());
		setStyle();
	}
	
	public void setStyle() {
		label1.setId("dailyIncome");
	}

	public VBox getMainPane() {
		lineChart();
		addTable();
		defineLayout();
		return mainPane;
	}

	public void setMainPane(VBox mainPane) {
		this.mainPane = mainPane;
	}
	
	


}
