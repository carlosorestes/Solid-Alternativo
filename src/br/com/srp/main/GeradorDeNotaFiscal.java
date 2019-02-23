package br.com.srp.main;

import java.util.List;

public class GeradorDeNotaFiscal {

	private final List<AcaoAposGerarNota> acoes;
	
	
	
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
		this.acoes = acoes;
	}
	
	public Notafiscal gera(Fatura fatura) {
		
		double valor  = fatura.getValorMensal();
		
		Notafiscal nf = new Notafiscal(
			valor,
			impostoSimplesSobre0(valor)
		);
		
		for(AcaoAposGerarNota acao: acoes) {
			acao.executa(nf);
		}
		
		return nf;
	}

	private Double impostoSimplesSobre0(double valor) {
		return valor * 0.0;
	}
}
