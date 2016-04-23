import javax.swing.JFrame;

public class Memory {

	private static int n_carte;//sempre pari!!!
	/*
	 * Inserimento indirizzo immagini 
	 * NB deve essere = a n_carte/2!! 
	 */
	
	
public static void main(String[] args) {
		new SelectLevel();
	}
	
	public static void run(JFrame frame, int n){
		String url [] = {"src/image01.png", "src/image02.png", "src/image03.png", "src/image04.png", "src/image05.png", "src/image06.png", "src/image07.png", "src/image08.png", "src/image09.png", "src/image10.png", "src/image11.png", "src/image12.png"};
		int inserimenti[] = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		Card cards[];
		String urlFront [];
		String urlBack;
		
		setN_carte(n);
		cards = new Card [getN_carte()];
		urlBack = "src/back01.png";
		urlFront = new String [getN_carte()];
		
		for (int i = 0; i<getN_carte(); i++){
			int rand = (int)(Math.random()*(getN_carte()/2));
			if(inserimenti[rand]==0)
				i--;
			else{
				urlFront [i] = url[rand];
				inserimenti[rand]--;
				cards [i] = new Card(urlFront[i], urlBack, 100, 100, rand);	
			}		
			
		}
		
		//JFrame frame = new JFrame();
		//frame.
		
		switch (getN_carte()) {
		case 6:
			frame.setSize(300, 230);
			break;
		case 8:
			frame.setSize(400, 230);
			break;
		case 12:
			frame.setSize(400, 330);
			break;
		case 24:
			frame.setSize(600, 430);
		default:
			break;
		}
		Campo campo = new Campo(cards, frame);
		frame.add(campo);
		frame.setVisible(true);
		//frame.setSize(100*(int)(cards.length/2),100*(int)(cards.length/3)+30);
		//frame.setSize(310,230);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static int getN_carte() {
		return n_carte;
	}
	public static void setN_carte(int n_carte) {
		Memory.n_carte = n_carte;
	}

}
