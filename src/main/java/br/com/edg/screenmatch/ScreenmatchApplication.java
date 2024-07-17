package br.com.edg.screenmatch;

import br.com.edg.screenmatch.model.DadosSerie;
import br.com.edg.screenmatch.service.ConsumoApi;
import br.com.edg.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var comsumoApi = new ConsumoApi();
		var json = comsumoApi.obterDados("https://www.omdbapi.com/?t=gilmore&girls&apikey=85727700");
		//System.out.println(json);
		//json = comsumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
