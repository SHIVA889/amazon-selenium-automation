
package com.company.project.ai;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class GroqConnectionTest {
  
    @Test
    public void shouldConnectToGroq() {

        // Reads the key from your Windows environment variables
        // Set GROQ_API_KEY=<YOUR_GROQ_API_KEY> in your environment
        String apiKey = System.getenv("GROQ_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                "GROQ_API_KEY environment variable is missing. "
                + "Configure it before running this test."
            );
        }

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://api.groq.com/openai/v1")
                .apiKey(apiKey)
                .modelName("openai/gpt-oss-20b")  
                .build();

        String response = model.chat(
                "   tell me hello shiva "
        );

        assertNotNull(response, "Groq response should not be null");
        assertFalse(response.isBlank(), "Groq response should not be blank");

        System.out.println("Groq connection successful!");
        System.out.println("Model response: " + response);
    }
}