# sportradar-assignment

## Assumptions

1. Match can't be started with null or blank strings for home and away teams.
2. When match starts scoreboard returns positive integer as id.
3. In case that updated match was not found, update match returns false.
4. When updating score none of the teams can receive negative integer.

## Documentation 

This is a repository for Sportradar assignment. 

### Task requirements

1. Start a new game, assuming initial score 0 – 0 and adding it the scoreboard.
This should capture following parameters:
   1. Home team
   2. Away team
2. Update score. This should receive a pair of absolute scores: home team score and away
   team score.
3. Finish game currently in progress. This removes a match from the scoreboard.
4. Get a summary of games in progress ordered by their total score. The games with the same
   total score will be returned ordered by the most recently started match in the scoreboard.

### Used technologies

- Java 17
- Maven
- JUnit5
- Lombok
- Logback classic

### Project notes

- During development, I used TDD approach.
- To store matches I used HashMap and keys are match IDs.
- I created unit tests to test method implementations, integration tests for scoreboard
to test scoreboard resource leaking and acceptance test to create
scenario from requirements.