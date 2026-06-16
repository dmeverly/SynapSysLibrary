import api.*;
import types.SynapSysMessage;

public class testapp {
    public static void main(String[] args) {
        Generator generator = new Generator();
        // SynapSysMessage synapSysMessage = new SynapSysMessage("gemini", "gemini-3.5-flash", "who are you?");
        // SynapSysMessage geminiResponse = generator.generate(synapSysMessage);
        // System.out.println(geminiResponse);
        SynapSysMessage synapSysMessage2 = new SynapSysMessage("openai", "gpt-5.5", "who are you?");
        SynapSysMessage openAIResponse = generator.generate(synapSysMessage2);
        System.out.println(openAIResponse);
        // System.out.println(synapSysMessage);
        // System.out.println(geminiResponse);
        System.out.println(synapSysMessage2);
        System.out.println(openAIResponse);
        System.exit(0);
    }
}