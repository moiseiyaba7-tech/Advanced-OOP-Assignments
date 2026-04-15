package com.oop.assignments;

class Player {
    String name;
    int age;

    Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void showPlayer() {
        System.out.println("Player: " + name + ", Age: " + age);
    }
}

class Team {
    String teamName;
    Player player1;
    Player player2;

    Team(String teamName) {
        this.teamName = teamName;
    }

    void addPlayer1(Player p) {
        player1 = p;
    }

    void addPlayer2(Player p) {
        player2 = p;
    }

    void showTeam() {
        System.out.println("Team: " + teamName);
        System.out.println("Team players:");
        if (player1 != null) player1.showPlayer();
        if (player2 != null) player2.showPlayer();
    }
}

public class AggregationDemo {
    public static void main(String[] args) {
        // Creating players first (They are independent of the team)
        Player p1 = new Player("Moise", 22);
        Player p2 = new Player("Charis", 23);

        // Display players before assigning them to any team
        System.out.println("Players exist before team creation:");
        p1.showPlayer();
        p2.showPlayer();

        System.out.println("\n--- Creating Team and Adding Players ---");

        // Creating a team and assigning players
        Team team = new Team("Young Stars");
        team.addPlayer1(p1);
        team.addPlayer2(p2);

        // Displaying the team and its players
        team.showTeam();
    }
}