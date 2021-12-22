package trabalho;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Principal {
	
	public static ProcessaTexto processaTexto = new ProcessaTexto();
	public static String pathFile = "./src/assets/texto.txt";
	public static String palavrasFile = "./src/assets/palavras.txt";
	public static String arquivoSaida = "./src/assets/saida.txt";


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(System.in);

		Path caminho = Paths.get(pathFile);

		try {	

			File arquivoSaidaFile = new File(arquivoSaida);

			String leitura = processaTexto.retornarLeituraArquivoTxt(pathFile);
			int qtdLinhas = processaTexto.retornarQuantidadeLinhas(pathFile);
			String palavrasLeitura = processaTexto.retornarLeituraArquivoTxt(palavrasFile);

			System.out.println("Arquivo de Texto enviado :");
			System.out.println(leitura);
			System.out.println("-------------");
			System.out.println("Quantidade de Linhas : " + qtdLinhas);
	
			String[] palavras = processaTexto.retornarPalavrasArquivo(palavrasFile).replace(",", "").replace("\\n", "")
					.replace("\n", "").split(" ");


			for (String palavra : palavras) {
				System.out.println("|" + palavra + "|");
			}

			processaTexto.exportarArquivoTxt(arquivoSaidaFile, palavrasLeitura);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
