package cinemaProject;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import module.DBHundler;
import module.MovieList;
import module.Price;
import module.Sale;

public class Seat {
	private Label a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,
				  b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,
				  c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,
				  cp1,cp2,cp3,
				  la,lb,lc,lcp,laprice,lbprice,lcprice,lcpprice,
				  lava,lhold,lsold,lcondition,
				  lticket,lticketDate,lmovName,lcinema,lshowdate,lshowtime,lseatNo,lcost,
				  lstaffName,llogOut;
	private Button btnPay,btnReserve;
	private GridPane nseatPane,pricePane;
	private FlowPane cpseatPane,topPane,bottomPane,movieTicketTopPane,ticketBotPane;
	private BorderPane mainPane;
	private VBox seatPane,ticketTopPane,ticketMidPane,ticketPane;
	private static Stage stage;
	private String name,value2,value3,value4,title,therater,showTime,showDate;
	private int value6;
	ArrayList<MovieList> mv = new ArrayList<MovieList>();
	ArrayList<Price> mp = new ArrayList<Price>();
	ArrayList<Sale> ms = new ArrayList<Sale>();
	LocalDate today = LocalDate.now();
	
	public void createNodes() {
		mv = DBHundler.getAllMovie();
		mp = DBHundler.getAllPrice();
		title = mv.get(StaffMoviePage.getName()).getmTitle();
		value2 =  StaffMoviePage.getTheater();
		value3 =  StaffMoviePage.getShowTime();
		therater =	StaffMoviePage.getTheater();
		showTime = StaffMoviePage.getShowTime() ;
		showDate = mv.get( StaffMoviePage.getName()).getDate();
		
		a1 = new Label("A1");
		if(!isSelected(a1))
		{
			a1.setStyle("-fx-background-color:red;");
			a1.setOnMouseClicked(null);
		}else if(!isReserve(a1)){
			a1.setStyle("-fx-background-color:orange;");
			
			a1.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A1");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a1.getText();
					updatePay(a1);
					a1.setStyle("-fx-background-color:red;");
					a1.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a1.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A1");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a1.getText();
				if(!isReserve(a1))
				{
					updatePay(a1);
				}
				else {
					pay();
				}
				a1.setStyle("-fx-background-color:red;");
				a1.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a1.getText();
				reserve();
				a1.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a2 = new Label("A2");
		if(!isSelected(a2))
		{
			a2.setStyle("-fx-background-color:red;");
			a2.setOnMouseClicked(null);
		}else if(!isReserve(a2)){
			a2.setStyle("-fx-background-color:orange;");
			
			a2.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A2");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a2.getText();
					updatePay(a2);
					a2.setStyle("-fx-background-color:red;");
					a2.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a2.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A2");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a2.getText();
				if(!isReserve(a2))
				{
					updatePay(a2);
				}
				else {
					pay();
				}
				a2.setStyle("-fx-background-color:red;");
				a2.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a2.getText();
				reserve();
				a2.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a3 = new Label("A3");
		if(!isSelected(a3))
		{
			a3.setStyle("-fx-background-color:red;");
			a3.setOnMouseClicked(null);
		}else if(!isReserve(a3)){
			a3.setStyle("-fx-background-color:orange;");
			
			a3.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A3");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a3.getText();
					updatePay(a3);
					a3.setStyle("-fx-background-color:red;");
					a3.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a3.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A3");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a1.getText();
				if(!isReserve(a3))
				{
					updatePay(a3);
				}
				else {
					pay();
				}
				a3.setStyle("-fx-background-color:red;");
				a3.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a3.getText();
				reserve();
				a3.setStyle("-fx-background-color:orange;");
			});
		});
		}
		a4 = new Label("A4");
		if(!isSelected(a4))
		{
			a4.setStyle("-fx-background-color:red;");
			a4.setOnMouseClicked(null);
		}else if(!isReserve(a4)){
			a4.setStyle("-fx-background-color:orange;");
			
			a4.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A4");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a4.getText();
					updatePay(a4);
					a4.setStyle("-fx-background-color:red;");
					a4.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a4.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A4");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a4.getText();
				if(!isReserve(a4))
				{
					updatePay(a4);
				}
				else {
					pay();
				}
				a4.setStyle("-fx-background-color:red;");
				a4.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a4.getText();
				reserve();
				a4.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a5 = new Label("A5");
		if(!isSelected(a5))
		{
			a5.setStyle("-fx-background-color:red;");
			a5.setOnMouseClicked(null);
		}else if(!isReserve(a5)){
			a5.setStyle("-fx-background-color:orange;");
			
			a5.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A5");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a5.getText();
					updatePay(a5);
					a5.setStyle("-fx-background-color:red;");
					a5.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a5.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A5");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a5.getText();
				if(!isReserve(a5))
				{
					updatePay(a5);
				}
				else {
					pay();
				}
				a5.setStyle("-fx-background-color:red;");
				a5.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a5.getText();
				reserve();
				a5.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a6 = new Label("A6");
		if(!isSelected(a6))
		{
			a6.setStyle("-fx-background-color:red;");
			a6.setOnMouseClicked(null);
		}else if(!isReserve(a6)){
			a6.setStyle("-fx-background-color:orange;");
			
			a6.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A6");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a6.getText();
					updatePay(a6);
					a6.setStyle("-fx-background-color:red;");
					a6.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a6.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A6");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a6.getText();
				if(!isReserve(a6))
				{
					updatePay(a6);
				}
				else {
					pay();
				}
				a6.setStyle("-fx-background-color:red;");
				a6.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a6.getText();
				reserve();
				a6.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a7 = new Label("A7");
		if(!isSelected(a7))
		{
			a7.setStyle("-fx-background-color:red;");
			a7.setOnMouseClicked(null);
		}else if(!isReserve(a7)){
			a7.setStyle("-fx-background-color:orange;");
			
			a7.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A7");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a7.getText();
					updatePay(a7);
					a7.setStyle("-fx-background-color:red;");
					a7.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a7.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A7");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a7.getText();
				if(!isReserve(a7))
				{
					updatePay(a7);
				}
				else {
					pay();
				}
				a7.setStyle("-fx-background-color:red;");
				a7.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a7.getText();
				reserve();
				a7.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a8 = new Label("A8");
		if(!isSelected(a8))
		{
			a8.setStyle("-fx-background-color:red;");
			a8.setOnMouseClicked(null);
		}else if(!isReserve(a8)){
			a8.setStyle("-fx-background-color:orange;");
			
			a8.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A8");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a8.getText();
					updatePay(a8);
					a8.setStyle("-fx-background-color:red;");
					a8.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a8.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A8");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a8.getText();
				if(!isReserve(a8))
				{
					updatePay(a8);
				}
				else {
					pay();
				}
				a8.setStyle("-fx-background-color:red;");
				a8.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a8.getText();
				reserve();
				a8.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a9 = new Label("A9");
		if(!isSelected(a9))
		{
			a9.setStyle("-fx-background-color:red;");
			a9.setOnMouseClicked(null);
		}else if(!isReserve(a9)){
			a9.setStyle("-fx-background-color:orange;");
			
			a9.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A9");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a9.getText();
					updatePay(a9);
					a9.setStyle("-fx-background-color:red;");
					a9.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a9.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A9");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a9.getText();
				if(!isReserve(a9))
				{
					updatePay(a9);
				}
				else {
					pay();
				}
				a9.setStyle("-fx-background-color:red;");
				a9.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a9.getText();
				reserve();
				a9.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a10 = new Label("A10");
		if(!isSelected(a10))
		{
			a10.setStyle("-fx-background-color:red;");
			a10.setOnMouseClicked(null);
		}else if(!isReserve(a1)){
			a10.setStyle("-fx-background-color:orange;");
			
			a10.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A10");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a10.getText();
					updatePay(a10);
					a10.setStyle("-fx-background-color:red;");
					a10.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a10.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A10");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a10.getText();
				if(!isReserve(a10))
				{
					updatePay(a10);
				}
				else {
					pay();
				}
				a10.setStyle("-fx-background-color:red;");
				a10.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a10.getText();
				reserve();
				a10.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a11 = new Label("A11");
		if(!isSelected(a11))
		{
			a11.setStyle("-fx-background-color:red;");
			a11.setOnMouseClicked(null);
		}else if(!isReserve(a11)){
			a11.setStyle("-fx-background-color:orange;");
			
			a11.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A11");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a11.getText();
					updatePay(a11);
					a11.setStyle("-fx-background-color:red;");
					a11.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a11.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A11");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a11.getText();
				if(!isReserve(a11))
				{
					updatePay(a11);
				}
				else {
					pay();
				}
				a11.setStyle("-fx-background-color:red;");
				a11.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a11.getText();
				reserve();
				a11.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		a12 = new Label("A12");
		if(!isSelected(a12))
		{
			a12.setStyle("-fx-background-color:red;");
			a12.setOnMouseClicked(null);
		}else if(!isReserve(a12)){
			a12.setStyle("-fx-background-color:orange;");
			
			a12.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: A12");
				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 0;
					name = a12.getText();
					updatePay(a12);
					a12.setStyle("-fx-background-color:red;");
					a12.setOnMouseClicked(null);
					
				});
			});	
		}else {
		a12.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: A12");
			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 0;
				name = a12.getText();
				if(!isReserve(a12))
				{
					updatePay(a12);
				}
				else {
					pay();
				}
				a12.setStyle("-fx-background-color:red;");
				a12.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 0;
				name = a12.getText();
				reserve();
				a12.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		b1 = new Label("B1");
		if(!isSelected(b1))
		{
			b1.setStyle("-fx-background-color:red;");
			b1.setOnMouseClicked(null);
		}else if(!isReserve(b1)){
			b1.setStyle("-fx-background-color:orange;");
			
			b1.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B1");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b1.getText();
					updatePay(b1);
					b1.setStyle("-fx-background-color:red;");
					b1.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b1.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B1");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b1.getText();
				if(!isReserve(b1))
				{
					updatePay(b1);
				}
				else {
					pay();
				}
				b1.setStyle("-fx-background-color:red;");
				b1.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b1.getText();
				reserve();
				b1.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		b2 = new Label("B2");
		if(!isSelected(b2))
		{
			b2.setStyle("-fx-background-color:red;");
			b2.setOnMouseClicked(null);
		}else if(!isReserve(b2)){
			b2.setStyle("-fx-background-color:orange;");
			
			b2.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B2");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b2.getText();
					updatePay(b2);
					b2.setStyle("-fx-background-color:red;");
					b2.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b2.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B2");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b2.getText();
				if(!isReserve(b2))
				{
					updatePay(b2);
				}
				else {
					pay();
				}
				b2.setStyle("-fx-background-color:red;");
				b2.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b2.getText();
				reserve();
				b2.setStyle("-fx-background-color:orange;");
			});
		});
		}
		
		b3 = new Label("B3");
		if(!isSelected(b3))
		{
			b3.setStyle("-fx-background-color:red;");
			b3.setOnMouseClicked(null);
		}else if(!isReserve(b3)){
			b3.setStyle("-fx-background-color:orange;");
			
			b3.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B3");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b3.getText();
					updatePay(b3);
					b3.setStyle("-fx-background-color:red;");
					b3.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b3.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B3");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b3.getText();
				if(!isReserve(b3))
				{
					updatePay(b3);
				}
				else {
					pay();
				}
				b3.setStyle("-fx-background-color:red;");
				b3.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b3.getText();
				reserve();
				b3.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b4 = new Label("B4");
		if(!isSelected(b4))
		{
			b4.setStyle("-fx-background-color:red;");
			b4.setOnMouseClicked(null);
		}else if(!isReserve(b4)){
			b4.setStyle("-fx-background-color:orange;");
			
			b4.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B4");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b4.getText();
					updatePay(b4);
					b4.setStyle("-fx-background-color:red;");
					b4.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b4.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B4");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b4.getText();
				if(!isReserve(b4))
				{
					updatePay(b4);
				}
				else {
					pay();
				}
				b4.setStyle("-fx-background-color:red;");
				b4.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b4.getText();
				reserve();
				b4.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b5 = new Label("B5");
		if(!isSelected(b5))
		{
			b5.setStyle("-fx-background-color:red;");
			b5.setOnMouseClicked(null);
		}else if(!isReserve(b5)){
			b5.setStyle("-fx-background-color:orange;");
			
			b5.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B5");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b5.getText();
					updatePay(b5);
					b5.setStyle("-fx-background-color:red;");
					b5.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b5.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B5");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b5.getText();
				if(!isReserve(b5))
				{
					updatePay(b5);
				}
				else {
					pay();
				}
				b5.setStyle("-fx-background-color:red;");
				b5.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b5.getText();
				reserve();
				b5.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b6 = new Label("B6");
		if(!isSelected(b6))
		{
			b6.setStyle("-fx-background-color:red;");
			b6.setOnMouseClicked(null);
		}else if(!isReserve(b6)){
			b6.setStyle("-fx-background-color:orange;");
			
			b6.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B6");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b6.getText();
					updatePay(b6);
					b6.setStyle("-fx-background-color:red;");
					b6.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b6.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B6");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b6.getText();
				if(!isReserve(b6))
				{
					updatePay(b6);
				}
				else {
					pay();
				}
				b6.setStyle("-fx-background-color:red;");
				b6.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b6.getText();
				reserve();
				b6.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b7 = new Label("B7");
		if(!isSelected(b7))
		{
			b7.setStyle("-fx-background-color:red;");
			b7.setOnMouseClicked(null);
		}else if(!isReserve(b7)){
			b7.setStyle("-fx-background-color:orange;");
			
			b7.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B7");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b7.getText();
					updatePay(b7);
					b7.setStyle("-fx-background-color:red;");
					b7.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b7.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B7");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b7.getText();
				if(!isReserve(b7))
				{
					updatePay(b7);
				}
				else {
					pay();
				}
				b7.setStyle("-fx-background-color:red;");
				b7.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b7.getText();
				reserve();
				b7.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b8 = new Label("B8");
		if(!isSelected(b8))
		{
			b8.setStyle("-fx-background-color:red;");
			b8.setOnMouseClicked(null);
		}else if(!isReserve(b8)){
			b8.setStyle("-fx-background-color:orange;");
			
			b8.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B8");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b8.getText();
					updatePay(b8);
					b8.setStyle("-fx-background-color:red;");
					b8.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b8.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B8");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b8.getText();
				if(!isReserve(b8))
				{
					updatePay(b8);
				}
				else {
					pay();
				}
				b8.setStyle("-fx-background-color:red;");
				b8.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b8.getText();
				reserve();
				b8.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b9 = new Label("B9");
		if(!isSelected(b9))
		{
			b9.setStyle("-fx-background-color:red;");
			b9.setOnMouseClicked(null);
		}else if(!isReserve(b9)){
			b9.setStyle("-fx-background-color:orange;");
			
			b9.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B9");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b9.getText();
					updatePay(b9);
					b9.setStyle("-fx-background-color:red;");
					b9.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b9.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B9");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b9.getText();
				if(!isReserve(b9))
				{
					updatePay(b9);
				}
				else {
					pay();
				}
				b9.setStyle("-fx-background-color:red;");
				b9.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b9.getText();
				reserve();
				b9.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b10 = new Label("B10");
		if(!isSelected(b10))
		{
			b10.setStyle("-fx-background-color:red;");
			b10.setOnMouseClicked(null);
		}else if(!isReserve(b10)){
			b10.setStyle("-fx-background-color:orange;");
			
			b10.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B10");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b10.getText();
					updatePay(b10);
					b10.setStyle("-fx-background-color:red;");
					b10.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b10.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B10");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b10.getText();
				if(!isReserve(b10))
				{
					updatePay(b10);
				}
				else {
					pay();
				}
				b10.setStyle("-fx-background-color:red;");
				b10.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b10.getText();
				reserve();
				b10.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b11 = new Label("B11");
		if(!isSelected(b11))
		{
			b11.setStyle("-fx-background-color:red;");
			b11.setOnMouseClicked(null);
		}else if(!isReserve(b11)){
			b11.setStyle("-fx-background-color:orange;");
			
			b11.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B11");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b11.getText();
					updatePay(b11);
					b11.setStyle("-fx-background-color:red;");
					b11.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b11.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B11");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b11.getText();
				if(!isReserve(b11))
				{
					updatePay(b11);
				}
				else {
					pay();
				}
				b11.setStyle("-fx-background-color:red;");
				b11.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b11.getText();
				reserve();
				b11.setStyle("-fx-background-color:orange;");
			});
		});
		}
		b12 = new Label("B12");
		if(!isSelected(b12))
		{
			b12.setStyle("-fx-background-color:red;");
			b12.setOnMouseClicked(null);
		}else if(!isReserve(b12)){
			b12.setStyle("-fx-background-color:orange;");
			
			b12.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: B12");
				lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 1;
					name = b12.getText();
					updatePay(b12);
					b12.setStyle("-fx-background-color:red;");
					b12.setOnMouseClicked(null);
					
				});
			});	
		}else {
		b12.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: B12");
			lcost.setText("Cost\t\t\t\t: "+lbprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 1;
				name = b12.getText();
				if(!isReserve(b12))
				{
					updatePay(b12);
				}
				else {
					pay();
				}
				b12.setStyle("-fx-background-color:red;");
				b12.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 1;
				name = b12.getText();
				reserve();
				b12.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c1 = new Label("C1");
		if(!isSelected(c1))
		{
			c1.setStyle("-fx-background-color:red;");
			c1.setOnMouseClicked(null);
		}else if(!isReserve(c1)){
			c1.setStyle("-fx-background-color:orange;");
			
			c1.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C1");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c1.getText();
					updatePay(c1);
					c1.setStyle("-fx-background-color:red;");
					c1.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c1.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C1");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c1.getText();
				if(!isReserve(c1))
				{
					updatePay(c1);
				}
				else {
					pay();
				}
				c1.setStyle("-fx-background-color:red;");
				c1.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c1.getText();
				reserve();
				c1.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c2 = new Label("C2");
		if(!isSelected(c2))
		{
			c2.setStyle("-fx-background-color:red;");
			c2.setOnMouseClicked(null);
		}else if(!isReserve(c2)){
			c2.setStyle("-fx-background-color:orange;");
			
			c2.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C2");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c2.getText();
					updatePay(c2);
					c2.setStyle("-fx-background-color:red;");
					c2.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c2.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C2");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c2.getText();
				if(!isReserve(c2))
				{
					updatePay(c2);
				}
				else {
					pay();
				}
				c2.setStyle("-fx-background-color:red;");
				c2.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c2.getText();
				reserve();
				c1.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c3 = new Label("C3");
		if(!isSelected(c3))
		{
			c3.setStyle("-fx-background-color:red;");
			c3.setOnMouseClicked(null);
		}else if(!isReserve(c3)){
			c3.setStyle("-fx-background-color:orange;");
			
			c3.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C3");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c3.getText();
					updatePay(c3);
					c3.setStyle("-fx-background-color:red;");
					c3.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c3.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C3");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c3.getText();
				if(!isReserve(c3))
				{
					updatePay(c3);
				}
				else {
					pay();
				}
				c3.setStyle("-fx-background-color:red;");
				c3.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c3.getText();
				reserve();
				c3.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c4 = new Label("C4");
		if(!isSelected(c4))
		{
			c4.setStyle("-fx-background-color:red;");
			c4.setOnMouseClicked(null);
		}else if(!isReserve(c4)){
			c4.setStyle("-fx-background-color:orange;");
			
			c4.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C4");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c4.getText();
					updatePay(c4);
					c4.setStyle("-fx-background-color:red;");
					c4.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c4.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C4");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c4.getText();
				if(!isReserve(c4))
				{
					updatePay(c4);
				}
				else {
					pay();
				}
				c4.setStyle("-fx-background-color:red;");
				c4.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c4.getText();
				reserve();
				c4.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c5 = new Label("C5");
		if(!isSelected(c5))
		{
			c5.setStyle("-fx-background-color:red;");
			c5.setOnMouseClicked(null);
		}else if(!isReserve(c5)){
			c5.setStyle("-fx-background-color:orange;");
			
			c5.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C5");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c5.getText();
					updatePay(c5);
					c5.setStyle("-fx-background-color:red;");
					c5.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c5.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C5");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c5.getText();
				if(!isReserve(c5))
				{
					updatePay(c5);
				}
				else {
					pay();
				}
				c5.setStyle("-fx-background-color:red;");
				c5.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c5.getText();
				reserve();
				c5.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c6 = new Label("C6");
		if(!isSelected(c6))
		{
			c6.setStyle("-fx-background-color:red;");
			c6.setOnMouseClicked(null);
		}else if(!isReserve(c6)){
			c6.setStyle("-fx-background-color:orange;");
			
			c6.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C6");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c6.getText();
					updatePay(c6);
					c6.setStyle("-fx-background-color:red;");
					c6.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c6.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C6");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c6.getText();
				if(!isReserve(c6))
				{
					updatePay(c6);
				}
				else {
					pay();
				}
				c6.setStyle("-fx-background-color:red;");
				c6.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c6.getText();
				reserve();
				c6.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c7 = new Label("C7");
		if(!isSelected(c7))
		{
			c7.setStyle("-fx-background-color:red;");
			c7.setOnMouseClicked(null);
		}else if(!isReserve(c7)){
			c7.setStyle("-fx-background-color:orange;");
			
			c7.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C7");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c7.getText();
					updatePay(c7);
					c7.setStyle("-fx-background-color:red;");
					c7.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c7.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C7");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c7.getText();
				if(!isReserve(c7))
				{
					updatePay(c7);
				}
				else {
					pay();
				}
				c7.setStyle("-fx-background-color:red;");
				c7.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c7.getText();
				reserve();
				c7.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c8 = new Label("C8");
		if(!isSelected(c8))
		{
			c8.setStyle("-fx-background-color:red;");
			c8.setOnMouseClicked(null);
		}else if(!isReserve(c8)){
			c8.setStyle("-fx-background-color:orange;");
			
			c8.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C8");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c8.getText();
					updatePay(c8);
					c8.setStyle("-fx-background-color:red;");
					c8.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c8.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C8");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c8.getText();
				if(!isReserve(c8))
				{
					updatePay(c8);
				}
				else {
					pay();
				}
				c8.setStyle("-fx-background-color:red;");
				c8.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c8.getText();
				reserve();
				c8.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c9 = new Label("C9");
		if(!isSelected(c9))
		{
			c9.setStyle("-fx-background-color:red;");
			c9.setOnMouseClicked(null);
		}else if(!isReserve(c9)){
			c9.setStyle("-fx-background-color:orange;");
			
			c9.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C9");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c9.getText();
					updatePay(c9);
					c9.setStyle("-fx-background-color:red;");
					c9.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c9.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C9");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c9.getText();
				if(!isReserve(c9))
				{
					updatePay(c9);
				}
				else {
					pay();
				}
				c9.setStyle("-fx-background-color:red;");
				c9.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c9.getText();
				reserve();
				c9.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c10 = new Label("C10");
		if(!isSelected(c10))
		{
			c10.setStyle("-fx-background-color:red;");
			c10.setOnMouseClicked(null);
		}else if(!isReserve(c10)){
			c10.setStyle("-fx-background-color:orange;");
			
			c10.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C10");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c10.getText();
					updatePay(c10);
					c10.setStyle("-fx-background-color:red;");
					c10.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c10.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C10");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c10.getText();
				if(!isReserve(c10))
				{
					updatePay(c10);
				}
				else {
					pay();
				}
				c10.setStyle("-fx-background-color:red;");
				c10.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c10.getText();
				reserve();
				c10.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c11 = new Label("C11");
		if(!isSelected(c11))
		{
			c11.setStyle("-fx-background-color:red;");
			c11.setOnMouseClicked(null);
		}else if(!isReserve(c11)){
			c11.setStyle("-fx-background-color:orange;");
			
			c11.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C11");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c11.getText();
					updatePay(c11);
					c11.setStyle("-fx-background-color:red;");
					c11.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c11.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C11");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c11.getText();
				if(!isReserve(c11))
				{
					updatePay(c11);
				}
				else {
					pay();
				}
				c11.setStyle("-fx-background-color:red;");
				c11.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c11.getText();
				reserve();
				c11.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c12 = new Label("C12");
		if(!isSelected(c12))
		{
			c12.setStyle("-fx-background-color:red;");
			c12.setOnMouseClicked(null);
		}else if(!isReserve(c12)){
			c12.setStyle("-fx-background-color:orange;");
			
			c12.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C12");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c12.getText();
					updatePay(c12);
					c12.setStyle("-fx-background-color:red;");
					c12.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c12.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C12");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c12.getText();
				if(!isReserve(c12))
				{
					updatePay(c12);
				}
				else {
					pay();
				}
				c12.setStyle("-fx-background-color:red;");
				c12.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c12.getText();
				reserve();
				c12.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c13 = new Label("C13");
		if(!isSelected(c13))
		{
			c13.setStyle("-fx-background-color:red;");
			c13.setOnMouseClicked(null);
		}else if(!isReserve(c13)){
			c13.setStyle("-fx-background-color:orange;");
			
			c13.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C13");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c13.getText();
					updatePay(c13);
					c13.setStyle("-fx-background-color:red;");
					c13.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c13.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C13");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c13.getText();
				if(!isReserve(c13))
				{
					updatePay(c13);
				}
				else {
					pay();
				}
				c13.setStyle("-fx-background-color:red;");
				c13.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c13.getText();
				reserve();
				c13 .setStyle("-fx-background-color:orange;");
			});
		});
		}
		c14 = new Label("C14");
		if(!isSelected(c14))
		{
			c14.setStyle("-fx-background-color:red;");
			c14.setOnMouseClicked(null);
		}else if(!isReserve(c14)){
			c14.setStyle("-fx-background-color:orange;");
			
			c14.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C14");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c14.getText();
					updatePay(c14);
					c14.setStyle("-fx-background-color:red;");
					c14.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c14.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C14");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c14.getText();
				if(!isReserve(c14))
				{
					updatePay(c14);
				}
				else {
					pay();
				}
				c14.setStyle("-fx-background-color:red;");
				c14.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c14.getText();
				reserve();
				c14.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c15 = new Label("C15");
		if(!isSelected(c15))
		{
			c15.setStyle("-fx-background-color:red;");
			c15.setOnMouseClicked(null);
		}else if(!isReserve(c15)){
			c15.setStyle("-fx-background-color:orange;");
			
			c15.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C15");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c15.getText();
					updatePay(c15);
					c15.setStyle("-fx-background-color:red;");
					c15.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c15.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C15");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c15.getText();
				if(!isReserve(c15))
				{
					updatePay(c15);
				}
				else {
					pay();
				}
				c15.setStyle("-fx-background-color:red;");
				c15.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c15.getText();
				reserve();
				c15.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c16 = new Label("C16");
		if(!isSelected(c16))
		{
			c16.setStyle("-fx-background-color:red;");
			c16.setOnMouseClicked(null);
		}else if(!isReserve(c16)){
			c16.setStyle("-fx-background-color:orange;");
			
			c16.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C16");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c16.getText();
					updatePay(c16);
					c16.setStyle("-fx-background-color:red;");
					c16.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c16.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C16");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c16.getText();
				if(!isReserve(c16))
				{
					updatePay(c16);
				}
				else {
					pay();
				}
				c16.setStyle("-fx-background-color:red;");
				c16.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c16.getText();
				reserve();
				c16.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c17 = new Label("C17");
		if(!isSelected(c17))
		{
			c17.setStyle("-fx-background-color:red;");
			c17.setOnMouseClicked(null);
		}else if(!isReserve(c17)){
			c17.setStyle("-fx-background-color:orange;");
			
			c17.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C17");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c17.getText();
					updatePay(c17);
					c17.setStyle("-fx-background-color:red;");
					c17.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c17.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C17");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c17.getText();
				if(!isReserve(c17))
				{
					updatePay(c17);
				}
				else {
					pay();
				}
				c17.setStyle("-fx-background-color:red;");
				c17.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c17.getText();
				reserve();
				c17.setStyle("-fx-background-color:orange;");
			});
		});
		}
		c18 = new Label("C18");
		if(!isSelected(c18))
		{
			c18.setStyle("-fx-background-color:red;");
			c18.setOnMouseClicked(null);
		}else if(!isReserve(c1)){
			c18.setStyle("-fx-background-color:orange;");
			c18.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: C18");
				lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 2;
					name = c18.getText();
					updatePay(c18);
					c18.setStyle("-fx-background-color:red;");
					c18.setOnMouseClicked(null);
					
				});
			});	
		}else {
		c18.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: C18");
			lcost.setText("Cost\t\t\t\t: "+lcprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 2;
				name = c18.getText();
				if(!isReserve(c18))
				{
					updatePay(c18);
				}
				else {
					pay();
				}
				c18.setStyle("-fx-background-color:red;");
				c18.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 2;
				name = c18.getText();
				reserve();
				c18.setStyle("-fx-background-color:orange;");
			});
		});
		}
		cp1 = new Label("CP1");
		if(!isSelected(cp1))
		{
			cp1.setStyle("-fx-background-color:red;");
			cp1.setOnMouseClicked(null);
		}else if(!isReserve(cp1)){
			cp1.setStyle("-fx-background-color:orange;");
			
			cp1.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: CP1");
				lcost.setText("Cost\t\t\t\t: "+lcpprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 3;
					name = cp1.getText();
					updatePay(cp1);
					cp1.setStyle("-fx-background-color:red;");
					cp1.setOnMouseClicked(null);
					
				});
			});	
		}else {
		cp1.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: CP1");
			lcost.setText("Cost\t\t\t\t: "+lcpprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 3;
				name = cp1.getText();
				if(!isReserve(cp1))
				{
					updatePay(cp1);
				}
				else {
					pay();
				}
				cp1.setStyle("-fx-background-color:red;");
				cp1.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 3;
				name = cp1.getText();
				reserve();
				cp1.setStyle("-fx-background-color:orange;");
			});
		});
		}
		cp2 = new Label("CP2");
		if(!isSelected(cp2))
		{
			cp2.setStyle("-fx-background-color:red;");
			cp2.setOnMouseClicked(null);
		}else if(!isReserve(cp2)){
			cp2.setStyle("-fx-background-color:orange;");
			
			cp2.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: CP2");
				lcost.setText("Cost\t\t\t\t: "+lcpprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 3;
					name = cp2.getText();
					updatePay(cp2);
					cp2.setStyle("-fx-background-color:red;");
					cp2.setOnMouseClicked(null);
					
				});
			});	
		}else {
		cp2.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: CP2");
			lcost.setText("Cost\t\t\t\t: "+lcpprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 3;
				name = cp2.getText();
				if(!isReserve(cp2))
				{
					updatePay(cp2);
				}
				else {
					pay();
				}
				cp2.setStyle("-fx-background-color:red;");
				cp2.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 3;
				name = cp2.getText();
				reserve();
				cp2.setStyle("-fx-background-color:orange;");
			});
		});
		}
		cp3 = new Label("CP3");
		if(!isSelected(cp3))
		{
			cp3.setStyle("-fx-background-color:red;");
			cp3.setOnMouseClicked(null);
		}else if(!isReserve(cp3)){
			cp3.setStyle("-fx-background-color:orange;");
			
			cp3.setOnMouseClicked(e->{
				lseatNo.setText("Seat No\t\t\t: CP3");
				lcost.setText("Cost\t\t\t\t: "+lcpprice.getText());	
				btnPay.setOnAction(f->{
					value6 = 3;
					name = cp3.getText();
					updatePay(cp1);
					cp3.setStyle("-fx-background-color:red;");
					cp3.setOnMouseClicked(null);
					
				});
			});	
		}else {
		cp3.setOnMouseClicked(e->{
			lseatNo.setText("Seat No\t\t\t: CP3");
			lcost.setText("Cost\t\t\t\t: "+lcpprice.getText());	
			btnPay.setOnAction(f->{
				value6 = 3;
				name = cp3.getText();
				if(!isReserve(cp3))
				{
					updatePay(cp3);
				}
				else {
					pay();
				}
				cp3.setStyle("-fx-background-color:red;");
				cp3.setOnMouseClicked(null);
				btnReserve.setOnAction(null);
			});
			btnReserve.setOnAction(f->{
				value6 = 3;
				name = cp3.getText();
				reserve();
				cp3.setStyle("-fx-background-color:orange;");
			});
		});
		}
		llogOut = new Label("back");
		llogOut.setOnMouseClicked(e->{
			stage.hide();
			new StaffMoviePage();
		});
		la = new Label("A seat price");
		lb = new Label("B seat price");
		lc = new Label("C seat price");
		lcp = new Label("CP seat price");
		laprice = new Label(String.valueOf(mp.get(0).getSeatprice()));
		lbprice = new Label(String.valueOf(mp.get(1).getSeatprice()));
		lcprice = new Label(String.valueOf(mp.get(2).getSeatprice()));
		lcpprice = new Label(String.valueOf(mp.get(3).getSeatprice()));
		lava = new Label("Available");
		lhold = new Label("Reserve");
		lsold = new Label("Unavailable");
		lcondition = new Label("Seat condition ---> ");
		
		lticket = new Label("Movie Ticket");
		lticketDate = new Label("Date\t\t\t\t: "+today);
		lmovName = new Label("Movie Name\t\t: "+title);
		lcinema = new Label("Cinema No\t\t: "+ therater);//new StaffMoviePage().getTheater()
		lshowdate = new Label("Show Date\t\t: "+ showDate);//mv.get(new StaffMoviePage().getName()).getDate()
		lshowtime = new Label("Show time\t\t: "+ showTime);//new StaffMoviePage().getShowTime()
		lseatNo = new Label("Seat No\t\t\t: ");
		lcost = new Label("Cost\t\t\t\t: ");
		
		btnPay = new Button("Pay");
		btnReserve = new Button("Reserve");
		
		lstaffName = new Label(LogInPage.getStaffName());
		
	}
	
	public void defineLayout() {
		nseatPane = new GridPane();
		nseatPane.add(a1, 0, 0);
		nseatPane.add(a2, 1, 0);
		nseatPane.add(a3, 2, 0);
		nseatPane.add(a4, 3, 0);
		nseatPane.add(a5, 4, 0);
		nseatPane.add(a6, 5, 0);
		nseatPane.add(a7, 0, 1);
		nseatPane.add(a8, 1, 1);
		nseatPane.add(a9, 2, 1);
		nseatPane.add(a10, 3, 1);
		nseatPane.add(a11, 4, 1);
		nseatPane.add(a12, 5, 1);
		nseatPane.add(b1, 0, 2);
		nseatPane.add(b2, 1, 2);
		nseatPane.add(b3, 2, 2);
		nseatPane.add(b4, 3, 2);
		nseatPane.add(b5, 4, 2);
		nseatPane.add(b6, 5, 2);
		nseatPane.add(b7, 0, 3);
		nseatPane.add(b8, 1, 3);
		nseatPane.add(b9, 2, 3);
		nseatPane.add(b10, 3, 3);
		nseatPane.add(b11, 4, 3);
		nseatPane.add(b12, 5, 3);
		nseatPane.add(c1, 0, 4);
		nseatPane.add(c2, 1, 4);
		nseatPane.add(c3, 2, 4);
		nseatPane.add(c4, 3, 4);
		nseatPane.add(c5, 4, 4);
		nseatPane.add(c6, 5, 4);
		nseatPane.add(c7, 0, 5);
		nseatPane.add(c8, 1, 5);
		nseatPane.add(c9, 2, 5);
		nseatPane.add(c10, 3, 5);
		nseatPane.add(c11, 4, 5);
		nseatPane.add(c12, 5, 5);
		nseatPane.add(c13, 0, 6);
		nseatPane.add(c14, 1, 6);
		nseatPane.add(c15, 2, 6);
		nseatPane.add(c16, 3, 6);
		nseatPane.add(c17, 4, 6);
		nseatPane.add(c18, 5, 6);
		nseatPane.setAlignment(Pos.CENTER);
		nseatPane.setPadding(new Insets(20));
		
		pricePane = new GridPane();
		pricePane.add(la, 0, 0);
		pricePane.add(laprice, 1, 0);
		pricePane.add(lb, 0, 1);
		pricePane.add(lbprice, 1, 1);
		pricePane.add(lc, 0, 2);
		pricePane.add(lcprice, 1, 2);
		pricePane.add(lcp, 0, 3);
		pricePane.add(lcpprice, 1, 3);
		pricePane.setAlignment(Pos.CENTER);
		pricePane.setPadding(new Insets(20));
		pricePane.setVgap(20);
		
		cpseatPane = new FlowPane(cp1,cp2,cp3);
		cpseatPane.setAlignment(Pos.CENTER);
		cpseatPane.setHgap(50);
		
		topPane = new FlowPane(lstaffName,llogOut);
		topPane.setAlignment(Pos.TOP_LEFT);
		topPane.setHgap(900);
		topPane.setPadding(new Insets(10));
		
		seatPane = new VBox(10,nseatPane,cpseatPane);
		
		bottomPane = new FlowPane(lcondition,lava,lhold,lsold);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setHgap(20);
		bottomPane.setPadding(new Insets(20));
		
		movieTicketTopPane = new FlowPane(lticket);
		movieTicketTopPane.setAlignment(Pos.CENTER);
		ticketTopPane = new VBox(movieTicketTopPane,lticketDate);
		ticketTopPane.setPadding(new Insets(10));
		
		ticketMidPane = new VBox(20,lmovName,lcinema,lshowdate,lshowtime,lseatNo,lcost);
		ticketMidPane.setPadding(new Insets(10));
		
		ticketBotPane = new FlowPane(20,20,btnPay,btnReserve);
		ticketBotPane.setPadding(new Insets(20));
		
		ticketPane = new VBox(ticketTopPane,ticketMidPane,ticketBotPane);
		ticketPane.setAlignment(Pos.CENTER);
		ticketPane.setPadding(new Insets(20));
		
		mainPane = new BorderPane();
		mainPane.setCenter(seatPane);
		mainPane.setLeft(pricePane);
		mainPane.setTop(topPane);
		mainPane.setBottom(bottomPane);
		mainPane.setRight(ticketPane);
		
		URL url = this.getClass().getResource("seatPage.css");
		mainPane.getStylesheets().add(url.toExternalForm());
		setStyle();
	}
	
	public void setStyle() {
		a1.getStyleClass().add("aseat");
		a2.getStyleClass().add("aseat");
		a3.getStyleClass().add("aseat");
		a4.getStyleClass().add("aseat");
		a5.getStyleClass().add("aseat");
		a6.getStyleClass().add("aseat");
		a7.getStyleClass().add("aseat");
		a8.getStyleClass().add("aseat");
		a9.getStyleClass().add("aseat");
		a10.getStyleClass().add("aseat");
		a11.getStyleClass().add("aseat");
		a12.getStyleClass().add("aseat");
		b1.getStyleClass().add("bseat");
		b2.getStyleClass().add("bseat");
		b3.getStyleClass().add("bseat");
		b4.getStyleClass().add("bseat");
		b5.getStyleClass().add("bseat");
		b6.getStyleClass().add("bseat");
		b7.getStyleClass().add("bseat");
		b8.getStyleClass().add("bseat");
		b9.getStyleClass().add("bseat");
		b10.getStyleClass().add("bseat");
		b11.getStyleClass().add("bseat");
		b12.getStyleClass().add("bseat");
		c1.getStyleClass().add("cseat");
		c2.getStyleClass().add("cseat");
		c3.getStyleClass().add("cseat");
		c4.getStyleClass().add("cseat");
		c5.getStyleClass().add("cseat");
		c6.getStyleClass().add("cseat");
		c7.getStyleClass().add("cseat");
		c8.getStyleClass().add("cseat");
		c9.getStyleClass().add("cseat");
		c10.getStyleClass().add("cseat");
		c11.getStyleClass().add("cseat");
		c12.getStyleClass().add("cseat");
		c13.getStyleClass().add("cseat");
		c14.getStyleClass().add("cseat");
		c15.getStyleClass().add("cseat");
		c16.getStyleClass().add("cseat");
		c17.getStyleClass().add("cseat");
		c18.getStyleClass().add("cseat");
		cp1.getStyleClass().add("cpseat");
		cp2.getStyleClass().add("cpseat");
		cp3.getStyleClass().add("cpseat");
		
		laprice.getStyleClass().add("aseat");
		lbprice.getStyleClass().add("bseat");
		lcprice.getStyleClass().add("cseat");
		lcpprice.getStyleClass().add("cpseat");
		
		lava.setId("ava");
		lhold.setId("hold");
		lsold.setId("sold");
		
		lticket.setId("movName");
		ticketTopPane.getStyleClass().add("ticket");
		ticketMidPane.getStyleClass().add("ticket");
		ticketBotPane.getStyleClass().add("ticket");
		
		btnPay.getStyleClass().add("btn");
		btnReserve.getStyleClass().add("btn");
		
		topPane.setId("top");
		llogOut.setId("logOut7");
		
		mainPane.setId("main");
	}
	
//	public void checkA(Label la)
//	{
//		if(!isSelected(la))
//		{
//			la.setStyle("-fx-background-color:red;");
//			la.setOnMouseClicked(null);
//		}else {
//			
//			if(!isReserve(la)){
//				la.setStyle("-fx-background-color:orange;");
//				
//				la.setOnMouseClicked(e->{
//					lseatNo.setText("Seat No\t\t\t: "+la.getText());
//					lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//					btnPay.setOnAction(f->{
//						value6 = 0;
//						name = la.getText();
//						updatePay(la);
//						la.setStyle("-fx-background-color:red;");
//						la.setOnMouseClicked(null);
//						
//					});
//				});	
//				
//			}else {
//			
//		la.setOnMouseClicked(e->{
//			lseatNo.setText("Seat No\t\t\t: "+la.getText());
//			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//			btnPay.setOnAction(f->{
//				value6 = 0;
//				name = la.getText();
//				if(!isReserve(la))
//				{
//					updatePay(la);
//				}
//				else {
//					pay();
//				}
//				la.setStyle("-fx-background-color:red;");
//				la.setOnMouseClicked(null);
//				btnReserve.setOnAction(null);
//			});
//			btnReserve.setOnAction(f->{
//				value6 = 0;
//				name = la.getText();
//				reserve();
//				la.setStyle("-fx-background-color:orange;");
//			});
//		});
//		}
//		}
//	}
//	
//	public void checkB(Label lb)
//	{
//		if(!isSelected(lb))
//		{
//			lb.setStyle("-fx-background-color:red;");
//			lb.setOnMouseClicked(null);
//		}else {
//			
//			if(!isReserve(lb)){
//				lb.setStyle("-fx-background-color:orange;");
//				
//				lb.setOnMouseClicked(e->{
//					lseatNo.setText("Seat No\t\t\t: "+lb.getText());
//					lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//					btnPay.setOnAction(f->{
//						value6 = 1;
//						name = lb.getText();
//						updatePay(lb);
//						lb.setStyle("-fx-background-color:red;");
//						lb.setOnMouseClicked(null);
//						
//					});
//				});	
//				
//			}else {
//			
//		lb.setOnMouseClicked(e->{
//			lseatNo.setText("Seat No\t\t\t: "+lb.getText());
//			lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//			btnPay.setOnAction(f->{
//				value6 = 1;
//				name = lb.getText();
//				if(!isReserve(lb))
//				{
//					updatePay(lb);
//				}
//				else {
//					pay();
//				}
//				lb.setStyle("-fx-background-color:red;");
//				lb.setOnMouseClicked(null);
//				btnReserve.setOnAction(null);
//			});
//			btnReserve.setOnAction(f->{
//				value6 = 1;
//				name = lb.getText();
//				reserve();
//				lb.setStyle("-fx-background-color:orange;");
//			});
//		});
//		}
//		}
//	}
//	
//	public void checkC(Label lc)
//	{
//		if(!isSelected(lc))
//		{
//			lc.setStyle("-fx-background-color:red;");
//			lc.setOnMouseClicked(null);
//		}else {
//			
//			if(!isReserve(lc)){
//				lc.setStyle("-fx-background-color:orange;");
//				
//				lc.setOnMouseClicked(e->{
//					lseatNo.setText("Seat No\t\t\t: "+lc.getText());
//					lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//					btnPay.setOnAction(f->{
//						value6 = 2;
//						name = lc.getText();
//						updatePay(lc);
//						lc.setStyle("-fx-background-color:red;");
//						lc.setOnMouseClicked(null);
//						
//					});
//				});	
//				
//			}else {
//			
//				lc.setOnMouseClicked(e->{
//				lseatNo.setText("Seat No\t\t\t: "+lc.getText());
//				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//				btnPay.setOnAction(f->{
//					value6 = 2;
//					name = lc.getText();
//					if(!isReserve(lc))
//					{
//						updatePay(lc);
//					}
//					else {
//						pay();
//					}
//				lc.setStyle("-fx-background-color:red;");
//				lc.setOnMouseClicked(null);
//				btnReserve.setOnAction(null);
//			});
//			btnReserve.setOnAction(f->{
//				value6 = 2;
//				name = lc.getText();
//				reserve();
//				lc.setStyle("-fx-background-color:orange;");
//			});
//		});
//		}
//		}
//	}
//	
//	public void checkCP(Label lcp)
//	{
//		if(!isSelected(lcp))
//		{
//			lcp.setStyle("-fx-background-color:red;");
//			lcp.setOnMouseClicked(null);
//		}else {
//			
//			if(!isReserve(lcp)){
//				lcp.setStyle("-fx-background-color:orange;");
//				
//				lcp.setOnMouseClicked(e->{
//					lseatNo.setText("Seat No\t\t\t: "+lcp.getText());
//					lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//					btnPay.setOnAction(f->{
//						value6 = 3;
//						name = lcp.getText();
//						updatePay(lc);
//						lcp.setStyle("-fx-background-color:red;");
//						lcp.setOnMouseClicked(null);
//						
//					});
//				});	
//				
//			}else {
//			
//				lc.setOnMouseClicked(e->{
//				lseatNo.setText("Seat No\t\t\t: "+lcp.getText());
//				lcost.setText("Cost\t\t\t\t: "+laprice.getText());	
//				btnPay.setOnAction(f->{
//					value6 = 3;
//					name = lcp.getText();
//					if(!isReserve(lcp))
//					{
//						updatePay(lcp);
//					}
//					else {
//						pay();
//					}
//				lcp.setStyle("-fx-background-color:red;");
//				lcp.setOnMouseClicked(null);
//				btnReserve.setOnAction(null);
//			});
//			btnReserve.setOnAction(f->{
//				value6 = 3;
//				name = lcp.getText();
//				reserve();
//				lcp.setStyle("-fx-background-color:orange;");
//			});
//		});
//		}
//		}
//	}
//	
	
	
	public void pay()
	{	
		value4 = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DBHundler.insertSale(name, value2,value3 , value4,"no",showDate, title, value6);
	}
	
	public void updatePay(Label l)
	{
		ms = DBHundler.getAllSale();
		int sid = returnReserve(l);
		
		
		DBHundler.updateSeat(sid, "no");
					
	}
	
	public void reserve()
	{
		value4 = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		DBHundler.insertSale(name, value2,value3 , value4,"reserve",showDate, title, value6);
	}
	
	public boolean isSelected(Label l)
	{
		ms = DBHundler.getAllSale();	
		
		for(Sale s: ms )
		{
			if(s.getStherater().equalsIgnoreCase(therater) && s.getSshowtime().equalsIgnoreCase(showTime)&& s.getSmname().equalsIgnoreCase(title) && s.getSname().equalsIgnoreCase(l.getText()) && s.getSreserve().equalsIgnoreCase("no") && s.getSshowTime().equalsIgnoreCase(showDate))
			{
				return false;
			}
		}
		return true;
	}

	public boolean isReserve(Label l)
	{
		ms = DBHundler.getAllSale();	
		
		for(Sale s: ms )
		{
			if(s.getStherater().equalsIgnoreCase(therater) && s.getSshowtime().equalsIgnoreCase(showTime)&& s.getSmname().equalsIgnoreCase(title) && s.getSname().equalsIgnoreCase(l.getText()) && s.getSreserve().equalsIgnoreCase("reserve") && s.getSshowTime().equalsIgnoreCase(showDate))
			{
				return false;
			}
		}
		return true;
	}
	
	public int returnReserve(Label l) {
		int sid = 0;
		ms = DBHundler.getAllSale();	
		
		for(Sale s: ms )
		{
			if(s.getStherater().equalsIgnoreCase(therater) && s.getSshowtime().equalsIgnoreCase(showTime )&& s.getSmname().equalsIgnoreCase(title) && s.getSname().equalsIgnoreCase(l.getText()) && s.getSreserve().equalsIgnoreCase("reserve") && s.getSshowTime().equalsIgnoreCase(showDate))
			{
				sid = s.getSid();
			}
		}
		return sid;
	}


	public static Stage getStage() {	
		return stage;
	}

	public static void setStage(Stage stage) {
		Seat.stage = stage;
	}

		
	public Seat()
	{
		stage = new Stage();
		createNodes();
		defineLayout();
		Scene sc= new Scene(mainPane,1366,700);
		stage.setScene(sc);
		stage.setTitle("Seat Page");
		stage.show();
	}

//	@Override
//	public void start(Stage stage1) throws Exception {
//		createNodes();
//		defineLayout();
//		Scene sc= new Scene(mainPane,1366,700);
//		stage1.setScene(sc);
//		stage1.setTitle("Seat Page");
//		stage1.show();
//		stage = stage1;
//	}
//	
//	public static void main(String args[])
//	{
//		
//
//		Application.launch(args);
//	}
	
	
	
	
	

}
