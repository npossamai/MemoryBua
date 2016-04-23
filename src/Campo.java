import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.Timer;

public class Campo extends JPanel {
	int pippo = 0;
	int errori = 0;
	int positionCardClicked [] = {-1, -1};
	int IDCardClicked [] = {-1, -1};
	int trovati = 0;
	boolean end = false, check [];
	
	//Card cards;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	//ImageIcon carte [];
	Point2D clickPosition;
	int ID [];
	JPanel panel = new JPanel();
	JLabel labelFront [], labelBack[], voidLabel[];
	
	//JLabel image [];
	
	public Campo(Card[] cards, JFrame frame) {
		super();
		
		//JPanel jPanel = new JPanel();
		//Timer timer = new Timer(0, new A)
		
		JProgressBar progressBar = new JProgressBar(-1,cards.length+cards.length/2);
		
		Timer timer = new Timer();
		TimeIncrement ti = new TimeIncrement(progressBar, frame, timer);
		timer.schedule(ti, 0, 1000);
		//ti.scheduledExecutionTime()
		if(progressBar.getValue()==progressBar.getMaximum())
			timer.cancel();
		//timer.
		
		frame.setLayout(new BorderLayout());
		frame.add(progressBar, BorderLayout.SOUTH);
		//paintComponents(cards[0].imageFront);
		
		check = new boolean[cards.length];
		for(int i = 0; i<check.length; i++)
			check[i] = false;
		switch (cards.length) {
		case 6:
			setLayout(new GridLayout(2, 3, 10, 10));
			//setSize(300, 200);
			break;
		case 8:
			setLayout(new GridLayout(2, 4, 10, 10));
			break;
		case 12:
			setLayout(new GridLayout(3, 4, 10, 10));
			break;
		case 24:
			setLayout(new GridLayout(4, 6, 10, 10));
			break;
		default:
			throw new IllegalArgumentException("Numero di carte non supportato!");
		}
		
		
		
		ID = new int [cards.length];
		labelFront = new JLabel[cards.length];
		labelBack = new JLabel[cards.length];
		voidLabel = new JLabel [cards.length];
		for(int i = 0; i<cards.length; i++){
			labelBack [i] = new JLabel(cards[i].imageBack);
			labelFront [i] = new JLabel(cards[i].imageFront);
			voidLabel [i] = new JLabel();
			ID [i] = (cards[i].getID());
			cards[i].coperta = true;
			
			add(labelBack[i]);
		}
		setVisible(true);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public boolean operation (){
				
				if(pippo%2 == 0){
					
					//System.out.println(positionCardClicked[0]);
					if(positionCardClicked[1] != positionCardClicked[0]){
						IDCardClicked[0] = cards[positionCardClicked[0]].ID;
						if(IDCardClicked[0]==IDCardClicked[1]){
							System.out.println("COPPIA TROVATA");
							check[positionCardClicked[1]] = true;
							check[positionCardClicked[0]] = true;
							for(int i=0; i<labelBack.length; i++)
								if(cards[i].getID()==IDCardClicked[0]){
									labelBack[i] = voidLabel[i];//labelFront[i];
									cards[i].trovata = true;
									progressBar.setValue(progressBar.getValue()-1);
									//int j = -1;
									//int pos=0;
									trovati++;
									System.out.println(trovati);
									if (trovati == cards.length){
										//System.out.println("GIOCO FINITO");
										end = true;
									}
								}
								
						}
						else errori++;	
							
						
						removeAll();
						
						for(int i = 0; i<labelBack.length; i++){
							
							if(i != positionCardClicked[1] && i!= positionCardClicked[0]){
								add(labelBack[i]);
								cards[i].coperta = true;
							}
							else{
								add(labelFront[i]);
								//System.out.println((labelFront[i].getIcon()).toString());
								cards[i].coperta = false;
							}	
							repaint();
						}
					}
					else pippo++;
						
					
				}
				else if(cards[positionCardClicked[pippo%2]].trovata==true){
					pippo++;
					return false;
				}
				else if (cards[positionCardClicked[pippo%2]].coperta == true){
					//System.out.println(positionCardClicked[1]);
					IDCardClicked[1] = cards[positionCardClicked[1]].getID();
					
					removeAll();
					
					for(int i = 0; i<labelBack.length; i++){
						
						if(i != positionCardClicked[pippo%2]){
							add(labelBack[i]);
							cards[i].coperta = true;
							//cards[i].coperta = true;
						}
						else{
							add(labelFront[i]);
							//System.out.println((labelFront[i].getIcon()).toString());
							cards[i].coperta = false;
						}	
						repaint();
					}
				}
				else if(cards[positionCardClicked[pippo++%2]].coperta == false)
					copri();
					
				else {
					//copri();
					if(positionCardClicked[0]==positionCardClicked[1]/*||cards[positionCardClicked[pippo++%2]].coperta == false*/){
						pippo++;
						copri();
						//positionCardClicked[0]=-1;
					}
						
					else copri();
				}
				return check[positionCardClicked[pippo%2]];
			}
			
			public void copri(){
				removeAll();
				//repaint();
				for (int i = 0; i<labelBack.length; i++){
					add(labelBack[i]);
					cards[i].coperta = true;
				}
				repaint();	
			}
			
			public void seiCarte(MouseEvent e){
				if (e.getX()<100 && e.getY()<100){
					positionCardClicked[pippo%2]=0;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()<100){
					positionCardClicked[pippo%2]=1;
				}
				else if(e.getX()>200 && e.getY()<100){
					positionCardClicked[pippo%2]=2;
				}
				else if(e.getX()<100 && e.getY()>100){
					positionCardClicked[pippo%2]=3;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>100){
					positionCardClicked[pippo%2]=4;
				}
				else if(e.getX() > 200 && e.getY()>100){
					positionCardClicked[pippo%2]=5;
				}
			}
			
			public void dodiciCarte(MouseEvent e){
				if (e.getX()<100 && e.getY()<100){
					positionCardClicked[pippo%2]=0;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()<100){
					positionCardClicked[pippo%2]=1;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()<100){
					positionCardClicked[pippo%2]=2;
				}
				else if(e.getX()>300 && e.getY()<100){
					positionCardClicked[pippo%2]=3;
				}
				else if(e.getX()<100 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=4;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=5;
				}
				else if(e.getX() > 200 && e.getX() <300 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=6;
				}
				else if(e.getX() > 300 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=7;
				}
				if (e.getX()<100 && e.getY()>200){
					positionCardClicked[pippo%2]=8;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>200){
					positionCardClicked[pippo%2]=9;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()>200){
					positionCardClicked[pippo%2]=10;
				}
				else if(e.getX()>300 && e.getY()>200){
					positionCardClicked[pippo%2]=11;
				}
			}
			
			public void ventiquattroCarte(MouseEvent e){
				if (e.getX()<100 && e.getY()<100){
					positionCardClicked[pippo%2]=0;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()<100){
					positionCardClicked[pippo%2]=1;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()<100){
					positionCardClicked[pippo%2]=2;
				}
				else if(e.getX()>300 && e.getX() <400 && e.getY()<100){
					positionCardClicked[pippo%2]=3;
				}
				else if(e.getX()>400 && e.getX() <500 && e.getY()<100){
					positionCardClicked[pippo%2]=4;
				}
				else if(e.getX()>500 && e.getY()<100){
					positionCardClicked[pippo%2]=5;
				}
				else if (e.getX()<100 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=6;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=7;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=8;
				}
				else if(e.getX()>300 && e.getX() <400 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=9;
				}
				else if(e.getX()>400 && e.getX() <500 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=10;
				}
				else if(e.getX()>500 && e.getY()>100 && e.getY()<200){
					positionCardClicked[pippo%2]=11;
				}
				else if (e.getX()<100 && e.getY()>200 && e.getY()<300){
					positionCardClicked[pippo%2]=12;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>200 && e.getY()<300){
					positionCardClicked[pippo%2]=13;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()>200 && e.getY()<300){
					positionCardClicked[pippo%2]=14;
				}
				else if(e.getX()>300 && e.getX() <400 && e.getY()>200 && e.getY()<300){
					positionCardClicked[pippo%2]=15;
				}
				else if(e.getX()>400 && e.getX() <500 && e.getY()>200 && e.getY()<300){
					positionCardClicked[pippo%2]=16;
				}
				else if(e.getX()>500 && e.getY()>200 && e.getY()<300){
					positionCardClicked[pippo%2]=17;
				}
				else if (e.getX()<100 && e.getY()>300){
					positionCardClicked[pippo%2]=18;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>300){
					positionCardClicked[pippo%2]=19;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()>300){
					positionCardClicked[pippo%2]=20;
				}
				else if(e.getX()>300 && e.getX() <400 && e.getY()>300){
					positionCardClicked[pippo%2]=21;
				}
				else if(e.getX()>400 && e.getX() <500 && e.getY()>300){
					positionCardClicked[pippo%2]=22;
				}
				else if(e.getX()>500 && e.getY()>300){
					positionCardClicked[pippo%2]=23;
				}
			}
			
			public void ottoCarte(MouseEvent e){
				if (e.getX()<100 && e.getY()<100){
					positionCardClicked[pippo%2]=0;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()<100){
					positionCardClicked[pippo%2]=1;
				}
				else if(e.getX()>200 && e.getX() <300 && e.getY()<100){
					positionCardClicked[pippo%2]=2;
				}
				else if(e.getX()>300 && e.getY()<100){
					positionCardClicked[pippo%2]=3;
				}
				else if(e.getX()<100 && e.getY()>100){
					positionCardClicked[pippo%2]=4;
				}
				else if(e.getX()>100 && e.getX() <200 && e.getY()>100){
					positionCardClicked[pippo%2]=5;
				}
				else if(e.getX() > 200 && e.getX() <300 && e.getY()>100){
					positionCardClicked[pippo%2]=6;
				}
				else if(e.getX() > 300 && e.getY()>100){
					positionCardClicked[pippo%2]=7;
				}
			}
			
			public void mouseClicked(MouseEvent e) {
				//Timer t = new Timer(arg0, arg1)
				pippo++;
				
				//System.out.println(errori);
				switch (cards.length) {
				case 6:
					seiCarte(e);
					if(cards[positionCardClicked[pippo%2]].trovata)
						pippo--;
					else if(!check[positionCardClicked[pippo%2]]){
						operation();
						frame.setSize(310, 230);
						frame.setSize(300, 230);
					}
					break;
				case 8:
					ottoCarte(e);
					if(cards[positionCardClicked[pippo%2]].trovata)
						pippo--;
					else if(!check[positionCardClicked[pippo%2]]){
						operation();
						frame.setSize(410, 230);
						frame.setSize(400, 230);
					}
					break;
				case 12:
					dodiciCarte(e);
					if(cards[positionCardClicked[pippo%2]].trovata)
						pippo--;
					else if(!check[positionCardClicked[pippo%2]]){
						operation();
						frame.setSize(410, 330);
						frame.setSize(400, 330);
					}
					break;
				case 24:
					ventiquattroCarte(e);
					if(cards[positionCardClicked[pippo%2]].trovata)
						pippo--;
					else if(!check[positionCardClicked[pippo%2]]){
						operation();
						frame.setSize(610, 430);
						frame.setSize(600, 430);
					}
					break;
				default:
					break;
				}
				if(end){
					repaint();
					//JOptionPane.showMessageDialog(null, "GIOCO FINITO");
					timer.cancel();
					int a = JOptionPane.showConfirmDialog(null, "GIOCO FINITO!\n\nUn altra partita?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					frame.dispose();
					
					if(a==0)
						new SelectLevel();
					
					//JOptionPane.showInputDialog(frame, JOptionPane.YES_NO_OPTION,"", pippo, null, cards, "UN ALTRA PARITA?");
					
					//new Memory().run();
				}
				else if(progressBar.getValue()>=progressBar.getMaximum()){
					repaint();
					JOptionPane.showMessageDialog(null, "HAI PERSO! troppi tentativi");
					frame.dispose();
				}
			}
		});
	}
}

