package org.alienattack.game;

import org.alienattack.objects.Enemy;
import org.alienattack.objects.Player;
import org.alienattack.objects.Missile;

import org.alienattack.input.*;


/* Game implements the game and runs the actual game play and GUIs for the project. 
 * This is what controls the game. */

public class Game {
	
	public static void main(String[] args) {

		
		System.out.println("Welcome to ALIEN ATTACK!\n");
		System.out.println("      .   '        .'     .              .");
		System.out.println("              _.---._   .            .     *");
		System.out.println("    *       .'       '.");
		System.out.println("        _.-~===========~-._");
		System.out.println("       (___________________)       .   *");
		System.out.println("  __         \\_______/ \n");
		
		//starts the game menu control that will mimic the future GUI to be implemented
		gameMenu();
		
	}

	
	public static void gameMenu() {
		
		
		int menuOption = -1;
		
		boolean notExit = true;
		
		//utilizes generalized input routine to get valid integer entry
		menuOption = InputRoutine.getInteger("Please select an option to start:\n1. START GAME\n2. DISPLAY GAME INFO\n3. EXIT");
		
		while(notExit) {
			
			switch(menuOption) {
			
			//executes main game code
			case 1:
				gameDriver();
				break;
				
			//prints basic game information to the user, may add high scores and or "how to play" in future deliverable 
			case 2:
				System.out.println("Play as an alien attacking incoming enemy spaceships!\n"
						+ "Players may move left/right and shoot missiles to hit enemies.\n");
				break;
				
			//exits the program entirely if the user chooses the exit option, akin to user closing a GUI window 
			case 3: 
				notExit = false;
				System.out.println("Exiting game... Goodbye!");
				System.exit(0);
				
				break;
			default:
				System.err.println("Invalid Option.");
				break;
			}
		
		menuOption = InputRoutine.getInteger("Please select an option to start:\n1. START GAME\n2. DISPLAY GAME INFO\n3. EXIT");
		
		}
		
	}
	
	
	
	public static void gameDriver() {
		
		//---------- Game Set Up ----------//
		GameBoard gb = new GameBoard();
		
		Enemy e1 = new Enemy(3, 10);
		Enemy e2 = new Enemy(5, 10);
		Enemy e3 = new Enemy(7, 10);
		Player p1 = new Player();
		
		gb.addNewEnemy(e1);
		gb.addNewEnemy(e2);
		gb.addNewEnemy(e3);
		gb.setNewPlayer(p1);
		
		
		boolean gameOver = false;
		int mainMenuSel = 0;
		int playerMoveMenuSel = 0;
		boolean exitGame = false;
		String userName = "";
		
		
		while (gameOver == false) {
			
			//utilizes generalized input routine to get valid integer entry
			mainMenuSel = InputRoutine.getInteger("Please select an option:\n1: Move player\n2: Shoot \n3: Hit enemy\n4: Hit player \n5: Show game stats \n6: Exit \n");
			
			switch(mainMenuSel) {
			
			case 1:
				System.out.println("Please select an option:");
				System.out.print("1: Move Right \n2: Move Left \n");
	
				playerMoveMenuSel =  InputRoutine.getInteger("");
				
				switch(playerMoveMenuSel) {
				
				case 1:
					gb.getPlayer().moveRight();
					System.out.println("Players new position: (" + gb.getPlayer().getXCoordinate()
							+ "," + gb.getPlayer().getYCoordinate() + ")");
					break;
				
				case 2:
					gb.getPlayer().moveLeft();
					System.out.println("Players new position: (" + gb.getPlayer().getXCoordinate()
							+ "," + gb.getPlayer().getYCoordinate() + ")");
					break;
				
				default:
					System.out.println("Please select a valid option");
					break;
				}
				
				break;
				
			case 2:
				Missile m1 = new Missile(gb.getPlayer().getXCoordinate(), 
										gb.getPlayer().getYCoordinate() + 1);
				gb.addMissile(m1);
				gb.getPlayer().shootMissle(m1);
				
				System.out.println("New Missile location: (" + 
						gb.getMissiles().get(gb.getMissiles().size() - 1).getXPosition()
						+ "," + gb.getMissiles().get(gb.getMissiles().size() - 1).getYPosition() + ")");
				break;
				
			case 3:
				if(!gb.getMissiles().isEmpty()) {
					gb.getMissiles().get(0).setXPosition(gb.getEnemyPositions().get(0).getXCoordinate());
					gb.getMissiles().get(0).setYPosition(gb.getEnemyPositions().get(0).getYCoordinate());
					
					System.out.println("New Missile location: (" + 
							gb.getMissiles().get(gb.getMissiles().size() - 1).getXPosition()
							+ "," + gb.getMissiles().get(gb.getMissiles().size() - 1).getYPosition() + ")");
					
					gb.checkEnemyHit(gb.getMissiles().get(gb.getMissiles().size() - 1));
					
					System.out.println("New number of enemies: " + (gb.getEnemyPositions().size()));
					
				}
				else {
					System.out.println("No missiles have been shot");
				}
				break;
				
			case 4:
				System.out.println("Current player health: " + gb.getPlayer().getHealth());
				gb.getEnemyPositions().get(0).setCoordinates(3, 0);
				gb.checkPlayerHit(gb.getPlayer());
				System.out.println("Player health after hit: " + gb.getPlayer().getHealth());
				break;
				
			case 5:
				System.out.println("========== Game Stats ==========");
				System.out.println("Player Health: " + gb.getPlayer().getHealth());
				System.out.println("Player Score: " + gb.getPlayer().getScore());
				System.out.println("Player location: (" + gb.getPlayer().getXCoordinate()
						+ "," + gb.getPlayer().getYCoordinate() + ")");
				System.out.println("Number of missiles on board: " + gb.getMissiles().size());
				System.out.println("Number of enemies: " + gb.getEnemyPositions().size());
				System.out.println("Enemy locations: ");
				for(Enemy enemy : gb.getEnemyPositions()) {
					System.out.println("(" + enemy.getXCoordinate() + "," + enemy.getYCoordinate() + ")");
				}
				break;
				
			case 6:
				
				exitGame = InputRoutine.getYorN("Are you sure you want to exit game? Y/N: ");
				
				if(exitGame) {
					
					System.out.println("Exiting game... Goodbye!");
					gameOver = true;
					System.exit(0);
				}
				break;
				
			default:
				System.out.println("Please select a valid option");
				break;
			}
			
			if (!gb.checkNumOfEnemies()) {
				System.out.println("No more enemies, You Won!!");
				System.out.println("Final Score: " + gb.getPlayer().getScore());
				
				gameOver = true;

				userName = InputRoutine.getString("Enter username to submit score: ");
				p1.setName(userName);
				
				exitGame = InputRoutine.getYorN("Do you want to return to main menu? Y/N: ");
			
				//exits the program if user does not want to return to main menu
				if(!exitGame) {
				
					System.out.println("Exiting game... Goodbye!");
					System.exit(0);
				}
			}
		}
		
	}
	
	
	
	
}

