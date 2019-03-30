import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.stage.StageStyle;

public class Main extends Application{

	Usuario usuario;
	Scene sc2;
	Label price = new Label();

	public static void main(String[] args){
		launch(args);

	}

	public void start(Stage primaryStage){

		
		primaryStage.setTitle("Bus Driver");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);


		VBox pb = new VBox();
		VBox casillas = new VBox();

		Label label = new Label("Write your Name");
		TextField text = new TextField();

		MenuItem tb1 = new MenuItem("Normal");
		tb1.setId("Normal");
		MenuItem tb2 = new MenuItem("Gel");
		tb2.setId("Gel");
		MenuItem tb3 = new MenuItem("Platino");
		tb3.setId("Platino");

		MenuButton menubutton = new MenuButton("Tipo de boleto" , null , tb1,tb2,tb3);

		Label label2 = new Label("Asientos a elegir"); 

		Button button = new Button("Vender ");
		button.setWrapText(true);

		pb.getChildren().add(label);
		pb.getChildren().add(text);
		pb.getChildren().add(menubutton);
		pb.getChildren().add(button);


		casillas.getChildren().add(label2);

		Scene sc = new Scene(pb);
		primaryStage.setScene(sc);

		Label precio = new Label("");


		 sc2 = new Scene(casillas);
		 				
						tb1.setOnAction( event->{
						
								precio.setText("Monto a pagar por boleto normal: $1500" );
							
						});
						
						tb2.setOnAction(event->{
							
								precio.setText("Monto a pagar por boleto gel: $2000" );
							
						});
						
						tb3.setOnAction(event->{
								precio.setText("Monto a pagar por boleto platino: $2500" );
							
						});

						

		button.addEventHandler(MouseEvent.MOUSE_CLICKED ,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				usuario= new Usuario(text.getText());
				casillas.getChildren().add(new Label("Bienvenido:  "+usuario.getName()));

				GridPane grid = new GridPane();

				Button[] seats = new Button[8];
				 for( int i=0; i<seats.length; i++ ) {
	        		seats[i] = new Button("Seat " + (i+1));
	        		seats[i].setId("" + i);
	        		seats[i].addEventHandler(MouseEvent.MOUSE_CLICKED, new colorButton());
	        		
	        	}
	        	grid.add(seats[0], 0, 0);
	        	grid.add(seats[1], 1, 0);
	        	grid.add(seats[2], 0, 2);
	        	grid.add(seats[3], 1, 2);
	        	grid.add(seats[4], 0, 3);
	        	grid.add(seats[5], 1, 3);
	        	grid.add(seats[6], 0, 4);
	        	grid.add(seats[7], 1, 4);


	        	Button goBack = new Button("Go to home menu");


 				goBack.addEventHandler(MouseEvent.MOUSE_CLICKED ,new EventHandler<MouseEvent>(){;
		 			public void handle(MouseEvent e){
						primaryStage.setScene(sc);
					}
 				});
 				

	        	casillas.getChildren().add(grid);
				primaryStage.setScene(sc2);
 				casillas.getChildren().add(precio);
	        	casillas.getChildren().add(goBack);

			}
		});


		
		primaryStage.show();


	}
	


	public class colorButton implements EventHandler<MouseEvent>{
		public void handle(MouseEvent e){
			Control c= (Control)e.getSource();
			c.setStyle("-fx-background-color: red;");
			price.setText("Monto a pagar: " );						
	 
		}

	}	
	

		

}