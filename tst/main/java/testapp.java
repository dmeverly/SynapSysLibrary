import api.*;
import types.SynapSysMessage;

public class testapp {
    public static void main(String[] args) {
        Generator generator = new Generator();
        // SynapSysMessage synapSysMessage = new SynapSysMessage("gemini", "gemini-3.5-flash", "who are you?");
        // SynapSysMessage geminiResponse = generator.generate(synapSysMessage);
        // System.out.println(geminiResponse);
        // SynapSysMessage synapSysMessage2 = new SynapSysMessage("openai", "gpt-5.4-mini", "Say this is a test");
        // SynapSysMessage openAIResponse = generator.generate(synapSysMessage2);
        // System.out.println(synapSysMessage);
        // System.out.println(geminiResponse);
        // System.out.println(synapSysMessage2);
        // System.out.println(openAIResponse);

        SynapSysMessage synapSysMessageOllama = new SynapSysMessage("ollama", "llama3", "Say this is a test");
        SynapSysMessage ollamaResponse = generator.generate(synapSysMessageOllama);
        System.out.println(synapSysMessageOllama);
        System.out.println(ollamaResponse);
    }
}