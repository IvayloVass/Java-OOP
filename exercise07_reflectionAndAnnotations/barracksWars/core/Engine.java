package exercise07_reflectionAndAnnotations.barracksWars.core;

import exercise07_reflectionAndAnnotations.barracksWars.core.commands.Command;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Repository;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Runnable;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.UnitFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException | ClassNotFoundException | NoSuchMethodException
                    | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, IllegalArgumentException {
        String result = "";
        commandName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        Class clazz = Class.forName("exercise07_reflectionAndAnnotations.barracksWars.core.commands." + commandName);
        Constructor<Command> constructor = clazz.getConstructor(String[].class, Repository.class, UnitFactory.class);
        Command commandInstance = constructor.newInstance(data, this.repository, this.unitFactory);
        Method execute = clazz.getDeclaredMethod("execute");
        try {
            result = (String) execute.invoke(commandInstance);

        } catch (InvocationTargetException ex) {
            System.out.print(ex.getCause().getMessage());
        }
        return result;

//        switch (commandName) {
//            case "add":
//                Add addCommand = new Add(data, this.repository, this.unitFactory);
//                result = addCommand.execute();
//                break;
//            case "report":
//                Report reportCommand = new Report(data, this.repository, this.unitFactory);
//                result = reportCommand.execute();
//                break;
//            case "fight":
//                Fight fightCommand = new Fight(data, this.repository, this.unitFactory);
//                result = fightCommand.execute();
//                break;
//            case "retire":
//                Retire retireCommand = new Retire(data, this.repository, this.unitFactory);
//                result = retireCommand.execute();
//            default:
//                throw new RuntimeException("Invalid command!");
//        }
//        return result;
    }

}
