package ProblemaLinhasDeMontagem;

public class LinhaDeMontagem {
	private int[] linhadeMontagem;
	private int entrada;
	private int saida;
	
	public LinhaDeMontagem(int tamanho, int entrada, int saida) { // é inicializada com o tamanho da linha e os valores de entrada e saida
		this.linhadeMontagem = new int[tamanho];
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public void valorestacao(int indice, int valor) { // deve-se adcionar o valor de tempo de cada estacao
		this.linhadeMontagem[indice -1] = valor;
	}
	public int[] getLinhadeMontagem() {
		return this.linhadeMontagem;
	}
	public int getEntrada() {
		return this.entrada;
	}
	public int getSaida() {
		return this.saida;
	}
}
