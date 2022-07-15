package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
import com.ironhack.battle.Battle;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Graveyard graveyard = new Graveyard();

    public void main() {
        String input;
        do {
            var mainMenu = """
                    Welcome to Battle Simulator
                    ===============
                    [0] - Warrior creator
                    [1] - Wizard creator
                    [2] - Random Warrior
                    [3] - Random Wizard
                    [4] - Show Graveyard
                    [5] - Random Party
                    [6] - Create Party
                    [99] - Battle
                    
                    [exit] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> createWarrior();
                case "1" -> createWizard();
                case "2" -> randomWarrior();
                case "3" -> randomWizard();
                case "4" -> showGraveyard();
                case "5" -> randomParty();
                case "6" -> createParty();
                case "99" -> battle();
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
    }

    private Wizard createWizard() {
        System.out.println("Indique nombre");
        var name = scanner.next();
        System.out.println("Indique id");
        var id = scanner.next();
        System.out.println("Indique hp");
        var hp = scanner.nextDouble();
        System.out.println("Indique maná");
        var mana = scanner.nextInt();
        System.out.println("Indique inteligencia");
        var intelligence = scanner.nextInt();

        return  new Wizard(name, id, hp, mana, intelligence);
    }

    private Warrior createWarrior() {
        System.out.println("Indique nombre");
        var name = scanner.next();
        System.out.println("Indique id");
        var id = scanner.next();
        System.out.println("Indique hp");
        var hp = scanner.nextDouble();
        System.out.println("Indique stamina");
        var stamina = scanner.nextInt();
        System.out.println("Indique fuerza");
        var strength = scanner.nextInt();

        return new Warrior(name, id, hp, stamina, strength);
    }

    private void randomWizard() {
        System.out.println(Wizard.generateRandom());
    }

    private void randomWarrior() {

    }

    private void randomParty() {
        //Party part = new Party();
        System.out.println("Indique cuántos miembros");
        int num = scanner.nextInt();
        System.out.println(Party.getRandomParty(num));  // --- > VERIFICAR SI DEJAMOS O NO EL MÈTODO COMO ESTÁTICO
    }

    //SOLO A MODO DE PRUEBA, EDITAR EN LA CLASE GRAVEYARD
    private void showGraveyard() {
        graveyard.showGraveyard();
    }

    private void createParty() {
        String input;
        Party party = new Party();
        do {
            var mainMenu = """
                    Welcome to Battle Simulator
                    ===============
                    [0] - Add Warrior
                    [1] - Add Wizard
                    
                    [exit] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> party.addCharacter(createWarrior());
                case "1" -> party.addCharacter(createWizard());
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));

        party.partyMembers();
    }

    private void battle() {
        Character char1 = new Warrior("First Warrior", Character.generateId(), 200, 30, 10);
        Character char2 = new Wizard("First Wizard", Character.generateId(), 100,  40, 10);
        Battle.oneVsOneBattle(char1, char2);
    }

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }


}
