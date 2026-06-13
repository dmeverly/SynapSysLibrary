import java.util.ArrayList;

import api.*;
import events.*;
import components.*;
import normalization.*;
import normalization.strategies.*;
import util.*;

public class MasterControl {
    static void main(String[] args) {
        MasterControl masterControl = new MasterControl();
        masterControl.start(args);
    }

    private void start(String[] args){
        if(args.length > 0 && "debug".equals(args[0])) {
            Logger.getInstance().setDebugEnabled(true);
        }
        else{
            Logger.getInstance().setDebugEnabled(false);
        }
        ArrayList<Component> components = new ArrayList<>();
        EventBus eventBus = new EventBus();
        Generator generator = new Generator(eventBus);
        Normalizer normalizer = new Normalizer(eventBus);
        components.add(generator);
        components.add(normalizer);
        for(Component component : components) {
            component.start();
        }
    }
}