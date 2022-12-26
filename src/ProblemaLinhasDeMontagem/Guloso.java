package ProblemaLinhasDeMontagem;

public class Guloso {
	private LinhaDuplaComTransicao linhas;
	private int[] resposta;
	private int tamanho;
	private int valor_final;
	
	public Guloso (LinhaDuplaComTransicao linhas) {
		this.linhas = linhas;
		
		this.tamanho = linhas.getLinha_A().getLinhadeMontagem().length;
		
		this.resposta = new int[tamanho];
		this.valor_final = 0;
	}

	private void execucao(int estacao, int entradaA, int entradaB, int[] linhaA, int[] linhaB, int[][]transicoes, int saida_A, int saida_B) {
		if(estacao < tamanho) {
			if(estacao == 1 ) {// faz a primeira chamada de estcao
				
				int tempoA = entradaA + linhaA[0]; // soma o tempo indo pela mesma linha A
				int tempoB = entradaB + linhaB[0];// soma o tempo indo pela linha B
				if(tempoA <= tempoB) {// verifica a menor, se for menor ou igual preenche a tabela de memoria A; 
					resposta[estacao-1] = 1;
					valor_final = entradaA + linhaA[0];
				} else {
					resposta[estacao-1] = 2;
					valor_final = entradaB + linhaB[0];
				}
				
				execucao(estacao+1, entradaA, entradaB, linhaA, linhaB, transicoes, saida_A, saida_B);
			}else {
				if(resposta[estacao-2] == 1) {
					int tempoA = linhaA[estacao-1]; // soma o tempo indo pela mesma linha A
					int tempoB = transicoes[0][estacao-2] + linhaB[estacao-1];// soma o tempo indo pela linha B
					if(tempoA <= tempoB) {// preenche a resposta verificando o menor
						resposta[estacao-1] = 1;
						valor_final = valor_final + tempoA;
					} else {
						resposta[estacao-1] = 2;
						valor_final = valor_final + tempoB;
					}
					execucao(estacao+1, entradaA, entradaB, linhaA, linhaB, transicoes, saida_A, saida_B);	
				}else {
					if(resposta[estacao-2] == 2) {
						int tempoA = transicoes[1][estacao-2] + linhaA[estacao-1]; // verifica a proxima estacao na linha A
						int tempoB = linhaB[estacao-1]; // verifica a proxima 
						if(tempoA <= tempoB) {// verifica a menor, se for menor ou igual preenche a resposta
							resposta[estacao-1] = 1;
							valor_final = valor_final + tempoA;
						} else {
							resposta[estacao-1] = 2;
							valor_final = valor_final + tempoB;
						}
						execucao(estacao+1, entradaA, entradaB, linhaA, linhaB, transicoes, saida_A, saida_B);	
				}
					
			}
				
		}
		}else if(estacao == tamanho) {
		if(resposta[estacao-2] == 1) {
			int tempoA = linhaA[estacao-1] + saida_A; // soma o tempo indo pela mesma linha A
			int tempoB = transicoes[0][estacao-2] + linhaB[estacao-1] + saida_B;// soma o tempo indo pela linha B
			if(tempoA <= tempoB) {// preenche a resposta verificando o menor
				resposta[estacao-1] = 1;
				valor_final = valor_final + tempoA;
			} else {
				resposta[estacao-1] = 2;
				valor_final = valor_final + tempoB;
			}
		}else {
			if(resposta[estacao-2] == 2) {
				int tempoA2 = transicoes[1][estacao-2] + linhaA[estacao-1] + saida_A; // verifica a proxima estacao na linha A
				int tempoB2 = linhaB[estacao-1] +  saida_B; // verifica a proxima 
				if(tempoA2 <= tempoB2) {// verifica a menor, se for menor ou igual preenche a resposta
					resposta[estacao-1] = 1;
					valor_final = valor_final + tempoA2;
				} else {
					resposta[estacao-1] = 2;
					valor_final = valor_final + tempoB2;
				}
		}
		
	}
	}
		

}	
	public void obterResposta() {
		int[] linhaA =  linhas.getLinha_A().getLinhadeMontagem();
		int[] linhaB =  linhas.getLinha_B().getLinhadeMontagem();
		
		int entradaA = linhas.getLinha_A().getEntrada();
		int entradaB = linhas.getLinha_B().getEntrada();
		
		int[][] transicoes = linhas.transicoes();
		
		int saida_A = linhas.getLinha_A().getSaida();
		int saida_B = linhas.getLinha_B().getSaida();
		
		
		execucao(1, entradaA, entradaB, linhaA, linhaB, transicoes, saida_A, saida_B);
		
		
		
		
		
		for(int j = 0; j < tamanho; j++) {
			System.out.println("Linha de montagem " + resposta[j] + ", Estacao " + (j+1) );
		}
		
		System.out.println("O caminho tem o valor de: " + valor_final);
	}
	
	
	
}

