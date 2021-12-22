package trabalho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProcessaTexto {
	
	
	
    public static String retornarPalavrasArquivo(String palavrasFile) {
        String texto = "";
        try {
            FileReader fileReader = new FileReader(palavrasFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // ler o contudo do arquivo
            while (bufferedReader.ready()) texto += bufferedReader.readLine() + "\n";
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto;
    }

	

	public String retornarLeituraArquivoTxt(String pathFile) {

		Path caminho = Paths.get(pathFile);

		try {

			byte[] texto = Files.readAllBytes(caminho);
			String leitura = new String(texto);
			return leitura;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}

	}

	public int retornarQuantidadeLinhas(String pathFile) throws IOException {

		File arquivoLeitura = new File(pathFile);
		LineNumberReader leituraLinha;

		try {
			leituraLinha = new LineNumberReader(new FileReader(arquivoLeitura));
			leituraLinha.skip(arquivoLeitura.length());
			int qtdLinhas = leituraLinha.getLineNumber();
			qtdLinhas +=1;

			return qtdLinhas;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	
	
    public static void exportarArquivoTxt(File file, String texto) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(texto);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
