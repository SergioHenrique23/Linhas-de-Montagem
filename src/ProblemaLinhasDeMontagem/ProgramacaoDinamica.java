package ProblemaLinhasDeMontagem;

public class ProgramacaoDinamica {
	private LinhaDuplaComTransicao linhas;
	
	private int [][] memorizacao;// matriz que memoriza
	private int [][] valores;// matriz que memoriza o caminho;
	private int valor_final;
	
	int tamanho;
	
	
	public ProgramacaoDinamica (LinhaDuplaComTransicao linhas) {
		this.linhas = linhas;
		this.tamanho = linhas.getLinha_A().getLinhadeMontagem().length;
		
		this.memorizacao = new int[2][tamanho];
		this.valores = new int[2][tamanho-1];
		this.valor_final = 0;
		
	}
	private void preencheMemoria(int estacao, int entradaA, int entradaB, int[] linhaA, int[] linhaB, int[][]transicoes) {
		if(estacao <= tamanho) {
			if(estacao == 1 ) {// faz a primeira chamada de estcao
				memorizacao[0][0] = entradaA + linhaA[0];
				memorizacao[1][0] = entradaB + linhaB[0];
				
				
				preencheMemoria(estacao+1, entradaA, entradaB, linhaA, linhaB, transicoes);
			}else {
				int tempoA1 = memorizacao[0][estacao-2] + linhaA[estacao-1]; // soma o tempo indo pela mesma linha A
				int tempoA2 = memorizacao[1][estacao-2] + transicoes[1][estacao-2] + linhaA[estacao-1];// soma o tempo indo pela linha B
				if(tempoA1 <= tempoA2) {// verifica a menor, se for menor ou igual preenche a tabela de memoria A; 
					memorizacao[0][estacao-1] = tempoA1;
					valores[0][estacao-2] = 1;
				} else {
					memorizacao[0][estacao-1] = tempoA2;
					valores[0][estacao-2] = 2;
				}
				
				int tempoB1 = memorizacao[1][estacao-2] + linhaB[estacao-1];
				int tempoB2 = memorizacao[0][estacao-2] + transicoes[0][estacao-2] + linhaB[estacao-1];
				if(tempoB1 <= tempoB2) {// verifica a menor, se for menor ou igual preenche a tabela de memoria B; 
					memorizacao[1][estacao-1] = tempoB1;
					valores[1][estacao-2] = 2;
				} else {
					memorizacao[1][estacao-1] = tempoB2;
					valores[1][estacao-2] = 1;
				}
				preencheMemoria(estacao+1, entradaA, entradaB, linhaA, linhaB, transicoes);
				
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
		
		
		preencheMemoria(1, entradaA, entradaB, linhaA, linhaB, transicoes);
		
		int [] resposta = new int[tamanho];
		int fim;
		
		if((saida_A + memorizacao[0][tamanho-1]) <= (saida_B + memorizacao[1][tamanho-1])) {// verifica qual sera o menor caminho
			resposta[tamanho-1] = 1;
			valor_final = saida_A + memorizacao[0][tamanho-1];
			fim = 1;
		}else {
			resposta[tamanho-1] = 2;
			fim = 2;
			valor_final = saida_B + memorizacao[1][tamanho-1];
		}
		for(int i = tamanho-2; i >= 0; i--) {
			resposta[i] = valores[fim-1][i];
			fim = valores[fim-1][i];
			
		}
		for(int j = 0; j < tamanho; j++) {
			System.out.println("Linha de montagem " + resposta[j] + ", Estacao " + (j+1) );
			
		}
		System.out.println("O caminho tem o valor de: " + valor_final);
		
	}
	
	
}
