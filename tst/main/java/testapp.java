import api.*;
import types.SynapSysMessage;

public class testapp {
    public static void main(String[] args) {
        Generator generator = new Generator();
        SynapSysMessage synapSysMessageOllama = new SynapSysMessage("ollama-local", "qwen3:4b", "Say this is a test");
        SynapSysMessage ollamaResponse = generator.generate(synapSysMessageOllama, 11434);
        System.out.println(synapSysMessageOllama);
        System.out.println(ollamaResponse);
    }
}