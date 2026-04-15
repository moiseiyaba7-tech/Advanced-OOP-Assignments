package com.oop.assignments;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AggregationTest {

    @Test
    void testAggregationRelationship() {
        System.out.println("TEST OUTPUT: Starting Aggregation Logic Verification...");

        // 1. Setup: Create the independent objects (Aggregation)
        Player p1 = new Player("Moise", 22);
        Team team = new Team("Test Team");

        // 2. Action: Associate them
        team.addPlayer1(p1);

        // 3. Assertion: Verify the association
        // We check if player1 in the team is actually the player we created
        assertNotNull(team.player1, "Player 1 should be associated with the team.");
        assertEquals("Moise", team.player1.name, "The team player name should match the original player name.");
        
        System.out.println("TEST OUTPUT: Aggregation verified successfully!");
    }

    @Test
    void testTeamInitialization() {
        System.out.println("TEST OUTPUT: Checking Team Name Assignment...");
        Team team = new Team("Young Stars");
        assertEquals("Young Stars", team.teamName, "Team name should be correctly initialized.");
    }
}