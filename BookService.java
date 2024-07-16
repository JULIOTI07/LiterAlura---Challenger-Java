package com.literalura;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BookService {
    private static final String API_URL = "URL_DA_API_AQUI";
    private final BookDAO bookDAO = new BookDAO();

    public void fetchAndSaveBooks() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode books = mapper.readTree(jsonResponse);

            for (JsonNode bookNode : books) {
                Book book = new Book();
                book.setTitle(bookNode.get("title").asText());
                book.setAuthor(bookNode.get("author").asText());
                book.setIsbn(bookNode.get("isbn").asText());
                bookDAO.saveBook(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
