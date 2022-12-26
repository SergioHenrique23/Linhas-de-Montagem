package ProblemaLinhasDeMontagem;

public class LinhaDuplaComTransicao {
	private LinhaDeMontagem linha_A;
	private LinhaDeMontagem linha_B;
	
	private int [] transicao_AB;
	private int[] transicao_BA;
	
	public LinhaDuplaComTransicao(LinhaDeMontagem linha_A, LinhaDeMontagem linha_B) {// é inicializadado com as duas linhas de montagem
		this.linha_A = linha_A;
		this.linha_B = linha_B;
		
		int [] aux = linha_A.getLinhadeMontagem();
		int tamanho = aux.length;
		
		transicao_AB = new int[tamanho -1];
		transicao_BA = new int[tamanho-1];
		
	}
	public void t_AB(int indice, int valor) { // deve-se adcionar o valor das transicoes 
		this.transicao_AB[indice -1] = valor;
	}
	public void t_BA(int indice, int valor) {
		this.transicao_BA[indice -1] = valor;
	}
	
	public LinhaDeMontagem getLinha_A() {
		return this.linha_A;
	}
	public LinhaDeMontagem getLinha_B() {
		return this.linha_B;
	}
	public int[][] transicoes(){
		int tamanho = transicao_BA.length;
		int[][] matriz = new int[2][tamanho];
		for(int i = 0; i<tamanho; i++) {
			matriz[0][i] = this.transicao_AB[i];
			matriz[1][i] = this.transicao_BA[i];
		}
		return matriz;
	}

}
