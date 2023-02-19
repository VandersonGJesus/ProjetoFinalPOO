package SuperTrunfo;

import java.util.Collections; 
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Baralho extends LinkedList<Carta> {
  private String tema;

	public Baralho(String tema) {
		this.setTema(tema);
	}
  
  public void carregar() {
    //criar logica para os arquivos em json
  }
  
  public void embaralhar() {
		Collections.shuffle(this);
	}
  
  public void distribuir(JogadorAbstrato[] jogadores) {
		int jogador = 0; 
		
		Iterator<Carta> iterador = this.iterator();
		
		while ( iterador.hasNext() ) {
			
			if (jogadores[jogador].getMonte() == null)
				jogadores[jogador].setMonte( new Baralho(this.tema) );
			
			jogadores[jogador].getMonte().add(iterador.next());
			iterador.remove();

			jogador = (jogador + 1) % jogadores.length;  
		}
  
    public Carta pegarDoTopo() {
		   if ( this.peekLast() != null )
			   return this.pollLast();
		
		  System.out.println("O monte não tem mais cartas!");
		     return null;
	}
  
  public void listarCartas() {
		System.out.println(this);
	}

	public String getTema() {
		return tema;
	}

	private void setTema(String tema) {
		this.tema = tema;
	}
}
