package services;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import models.*;

import com.fasterxml.jackson.databind.ObjectMapper;


public class GoogleBooksService {
    private static final String API_KEY = "AIzaSyA5IHDoWCicPG6fkneZMySjPQvSNCLGRJY";

    public List<Livro> buscarLivro(String buscarTermo) throws IOException, InterruptedException {
        String encontarPesquisaTermo = URLEncoder.encode(buscarTermo, StandardCharsets.UTF_8);
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + encontarPesquisaTermo + "&key=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200){
            return ParseLivro(response.body());
        } else {
            System.err.println("Erro oa buscar livro. codigo: " + response.statusCode());
            return Collections.emptyList();
        }
    }
    
    private List<Livro> ParseLivro(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BookResponse response = mapper.readValue(json, BookResponse.class);

        List<Livro> livros = new ArrayList<>();

        if (response.items != null){
            for (Item item : response.items){
                VolumeInfo info = item.volumeInfo;

                String title = info.titulo;
                String author = info.autores != null ? String.join(", ", info.autores) : "Desconhecido";
                String isbn = info.getIsbn();
                int contadorPaginas = info.numeroPaginas;


                livros.add(new Livro(title, author,contadorPaginas,isbn));
            }
            return livros;
        }
        return null;
    }
}  