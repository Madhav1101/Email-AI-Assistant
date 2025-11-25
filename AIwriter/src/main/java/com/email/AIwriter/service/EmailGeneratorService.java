package com.email.AIwriter.service;

import com.email.AIwriter.dto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class EmailGeneratorService {
    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String generateEmailReply(EmailRequestDto emailRequestDto) {
        String prompt = buildPrompt(emailRequestDto);
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );

        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .stringValue();
        }catch (Exception e) {
            return "Error processing request:"+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequestDto emailRequestDto) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for hte following email content. Please don't generate a subject line  ");
        if(emailRequestDto.getTone() !=null && !emailRequestDto.getTone().isEmpty()) {
            prompt.append("User a ").append(emailRequestDto.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequestDto.getEmailContent());

        return prompt.toString();
    }
}
