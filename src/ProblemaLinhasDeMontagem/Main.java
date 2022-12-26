package ProblemaLinhasDeMontagem;
/**
 * 
 * @Nomes:Lucas Rafael Alves de Souza.  Sergio Henrique Mendes de Assis. Yasmim Augusta Gomes.
 *
 */
public class Main {
	public static void main ( String [] args) {
		LinhaDeMontagem linhaA1 = new LinhaDeMontagem(6, 2 ,3);
		LinhaDeMontagem linhaA2 = new LinhaDeMontagem(6, 4, 2);
		
		linhaA1.valorestacao(1,7);
		linhaA1.valorestacao(2,9);
		linhaA1.valorestacao(3,3);
		linhaA1.valorestacao(4,4);
		linhaA1.valorestacao(5,8);
		linhaA1.valorestacao(6,4);
		
		linhaA2.valorestacao(1,8);
		linhaA2.valorestacao(2,5);
		linhaA2.valorestacao(3,6);
		linhaA2.valorestacao(4,4);
		linhaA2.valorestacao(5,5);
		linhaA2.valorestacao(6,7);
		
		
		LinhaDuplaComTransicao caso1 = new LinhaDuplaComTransicao(linhaA1, linhaA2);
		
		caso1.t_AB(1,2);
		caso1.t_AB(2,3);
		caso1.t_AB(3,1);
		caso1.t_AB(4,3);
		caso1.t_AB(5,4);
		
		caso1.t_BA(1,2);
		caso1.t_BA(2,1);
		caso1.t_BA(3,2);
		caso1.t_BA(4,2);
		caso1.t_BA(5,1);
		
		ProgramacaoDinamica teste1 = new ProgramacaoDinamica(caso1);
		Guloso teste1_Guloso = new Guloso(caso1);
		
		System.out.println("Resposta Caso Exemplo Programacao Dinamica");
		teste1.obterResposta();
		
		System.out.println("Resposta Caso Exemplo Guloso");
		teste1_Guloso.obterResposta();
		
		/*
		 * Execucao para as duas instancias
		 */
		/// Primeira instancia, criar as linhas de montagem
		LinhaDeMontagem linhaA3 = new LinhaDeMontagem(9, 3 ,6);
		int vec_A3[] = {5,7,10,5,9,11,9,5,2};
		for(int i = 1; i <= 9; i++) {
			linhaA3.valorestacao(i,vec_A3[i-1]);
		}
		LinhaDeMontagem linhaA4 = new LinhaDeMontagem(9, 2 ,5);
		int vec_A4[] = {6,3,9,11,4,9,3,12,4};
		for(int i = 1; i <= 9; i++) {
			linhaA4.valorestacao(i,vec_A4[i-1]);
		}
		LinhaDuplaComTransicao caso2 = new LinhaDuplaComTransicao(linhaA3, linhaA4);
		
		int vec_TA2[] = {3,5,4,2,7,5,8,1};
		for(int i = 1; i <= 8; i++) {
			caso2.t_AB(i, vec_TA2[i-1]);
		}
		int vec_TB2[] = {5,3,7,5,6,2,5,2};
		for(int i = 1; i <= 8; i++) {
			caso2.t_BA(i, vec_TB2[i-1]);
		}
		// Segunda instancia //////
		LinhaDeMontagem linhaA5 = new LinhaDeMontagem(8, 5 ,8);
		int vec_A5[] = {10,6,3,8,5,3,7,12};
		for(int i = 1; i <= 8; i++) {
			linhaA5.valorestacao(i,vec_A5[i-1]);
		}
		LinhaDeMontagem linhaA6 = new LinhaDeMontagem(8, 7 ,9);
		int vec_A6[] = {3,5,3,7,6,4,9,10};
		for(int i = 1; i <= 8; i++) {
			linhaA6.valorestacao(i,vec_A6[i-1]);
		}
		LinhaDuplaComTransicao caso3 = new LinhaDuplaComTransicao(linhaA5, linhaA6);
		
		int vec_TA3[] = {4,2,7,2,5,8,2};
		for(int i = 1; i <= 7; i++) {
			caso3.t_AB(i, vec_TA3[i-1]);
		}
		int vec_TB3[] = {6,1,7,3,6,4,5};
		for(int i = 1; i <= 7; i++) {
			caso3.t_BA(i, vec_TB3[i-1]);
		}
		// criar as classes de solucao
		ProgramacaoDinamica teste2 = new ProgramacaoDinamica(caso2);
		ProgramacaoDinamica teste3 = new ProgramacaoDinamica(caso3);
		
		Guloso teste2_Guloso = new Guloso(caso2);
		Guloso teste3_Guloso = new Guloso(caso3);
		//
		////////////
		/// RESPOSTAS
		System.out.println("\n\n");
		System.out.println("Resposta Caso da instancia 1 Programacao Dinamica");
		teste2.obterResposta();
		System.out.println();
		System.out.println("Instancia 1 Programacao Gulosa: ");
		teste2_Guloso.obterResposta();
		System.out.println("\n\n");
		
		System.out.println("Resposta Caso da instancia 2 Programacao Dinamica");
		teste3.obterResposta();
		System.out.println();
		System.out.println("Instancia 2 Programacao Gulosa: ");
		teste3_Guloso.obterResposta();
		
	}

}
