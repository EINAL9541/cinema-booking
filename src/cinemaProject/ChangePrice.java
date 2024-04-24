package cinemaProject;

import java.net.URL;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import module.*;

public class ChangePrice{
	private Label la,lb,lc,lcp;
	private TextField ta,tb,tc,tcp;
	private Button bupdate,bclear;
	private GridPane pricePane;
	private FlowPane buttonPane;
	private BorderPane mainPane;
	private ArrayList<Price> cp = new ArrayList<Price>();
	
	public void createIndexs()
	{
		cp = DBHundler.getAllPrice();
		la = new Label("A seat Price");
		lb = new Label("B seat Price");
		lc = new Label("C seat Price");
		lcp = new Label("Couple seat Price");
		
		ta = new TextField();
		ta.setPromptText(Integer.toString(cp.get(0).getSeatprice()));
		tb = new TextField();
		tb.setPromptText(Integer.toString(cp.get(1).getSeatprice()));
		tc = new TextField();
		tc.setPromptText(Integer.toString(cp.get(2).getSeatprice()));
		tcp = new TextField();
		tcp.setPromptText(Integer.toString(cp.get(3).getSeatprice()));
		
		bupdate = new Button("Update");
		bupdate.setPrefWidth(100);
		bupdate.setOnAction(e->{
			update();
		});
		bclear = new Button("Clear");
		bclear.setPrefWidth(100);
		bclear.setOnAction(e->{
			clear();
		});
		
	}
	
	public void defineLayout()
	{
		pricePane = new GridPane();
		pricePane.setAlignment(Pos.CENTER);
		pricePane.setHgap(100);
		pricePane.setVgap(60);
		pricePane.add(la, 0, 0);
		pricePane.add(ta, 1, 0);
		
		pricePane.add(lb, 0, 1);
		pricePane.add(tb, 1, 1);
		
		pricePane.add(lc, 0, 2);
		pricePane.add(tc, 1, 2);
		
		pricePane.add(lcp, 0, 3);
		pricePane.add(tcp, 1, 3);
		
		buttonPane = new FlowPane(bupdate,bclear);
		buttonPane.setAlignment(Pos.TOP_CENTER);
		buttonPane.setPadding(new Insets(0, 0, 80, 0));
		buttonPane.setHgap(80);
		
		mainPane = new BorderPane();
		mainPane.setCenter(pricePane);
		mainPane.setBottom(buttonPane);
		URL url = this.getClass().getResource("changePriceStyle.css");
		mainPane.getStylesheets().add(url.toExternalForm());
		setStyle();
	}
	
	public void setStyle()
	{
		mainPane.setId("priceBackGround");
		la.getStyleClass().add("PriceLabel");
		lb.getStyleClass().add("PriceLabel");
		lc.getStyleClass().add("PriceLabel");
		lcp.getStyleClass().add("PriceLabel");
		ta.setId("PriceTextta");
		tb.setId("PriceTexttb");
		tc.setId("PriceTexttc");
		tcp.setId("PriceTexttcp");
		bupdate.setId("PriceUpdate");
		bclear.setId("PriceClear");
	}

	public void clear()
	{
		ta.setText("");
		tb.setText("");
		tc.setText("");
		tcp.setText("");

	}
	
	public void update()
	{
		Integer value1 = Integer.valueOf(ta.getText());
		Integer value2 = Integer.valueOf(tb.getText());
		Integer value3 = Integer.valueOf(tc.getText());
		Integer value4 = Integer.valueOf(tcp.getText());
		
		DBHundler.updatePrice(0, value1);
		DBHundler.updatePrice(1, value2);
		DBHundler.updatePrice(2, value3);
		DBHundler.updatePrice(3, value4);
		cp = DBHundler.getAllPrice();
		ta.setText("");
		tb.setText("");
		tc.setText("");
		tcp.setText("");
		
		ta.setPromptText(Integer.toString(cp.get(0).getSeatprice()));
		tb.setPromptText(Integer.toString(cp.get(1).getSeatprice()));
		tc.setPromptText(Integer.toString(cp.get(2).getSeatprice()));
		tcp.setPromptText(Integer.toString(cp.get(3).getSeatprice()));
	}
	
	public BorderPane getMainPane() {
		createIndexs();
		defineLayout();
		return mainPane;
	}

	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}
	
	
}
