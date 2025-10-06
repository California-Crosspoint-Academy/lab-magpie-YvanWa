//Yvan Wang

public class Magpie3 {    
    
    /**
     * Take a statement with "I want ." and transform it 
     * into "I would like , too!"
     *   Example:
     *   Input: "I want ice cream."
     *   Output: "I would like ice cream, too!"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
       // TODO: Activity 3 Part b — you will write code here later
       // This method should turn sentences like "I want pizza."
       // into "I would like pizza, too!"
       return ""; // Modify this statement to return the correct String
    }  
    
    /**
     * Take a statement with "Would you like to  with me?" 
     * and transform it into "When would you like me to  with you?"
     * @param statement the user statement, assumed to contain 
     *        "Would you like to" and "with me"
     * @return the transformed statement
     */
    private String transformWouldYouLikeStatement(String statement)
    {
       // TODO: Activity 3 Part c — you will write code here later
       // This method should take something like:
       // "Would you like to go shopping with me?"
       // and return "When would you like me to go shopping with you?"
       return ""; // Modify this statement to return the correct String
    } 	     

    /**
     * Gives a response to a user statement.
     * Decides what reply to give based on key phrases or rules.
     */
    public String getResponse(String statement)
    {
       String response = "";

       // If the user mentions math or science
       if (statement.indexOf("math") >= 0 || statement.indexOf("science") >= 0)
       {
          response = "Is that your favorite class?";
       }
       // If the user mentions this specific school
       else if (statement.indexOf("Packer High School") >= 0)
       {
          response = "Packer High School is the best school!";
       }
       // If the user talks about food
       else if (statement.indexOf("hamburger") >= 0)
       {
          response = "That sounds yummy, tell me more.";
       }
       // Responses that require transformation methods
       else if (findPhrase(statement, "I want", 0) >= 0)
       {
          response = transformIWantStatement(statement);
       }
       else if (findPhrase(statement, "Would you like", 0) >= 0)
       {
          response = transformWouldYouLikeStatement(statement);
       }
       // Otherwise, use a random generic response
       else
       {
          response = getRandomResponse();
       }

       return response;
    }

    /**
     * Search for one word in phrase. The search is not case sensitive.
     * Ensures that the goal is a separate word (not part of a longer word).
     * @param statement the string to search
     * @param goal the word or phrase to find
     * @param startPos where to start searching
     * @return index of goal, or -1 if not found
     */
    private int findPhrase(String statement, String goal, int startPos)
    {
       // Convert both strings to lowercase and trim spaces
       String phrase = statement.trim().toLowerCase();
       goal = goal.toLowerCase();

       // Start searching for the goal phrase
       int position = phrase.indexOf(goal, startPos);

       // Check if goal is found as a separate word
       while (position >= 0)
       {
          String before = " ", after = " ";

          // Get character before the found phrase
          if (position > 0)
          {
             before = phrase.substring(position - 1, position);
          }

          // Get character after the found phrase
          if (position + goal.length() < phrase.length())
          {
             after = phrase.substring(position + goal.length(), position + goal.length() + 1);
          }

          // If before and after aren't letters, it's a valid match
          if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
              && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
          {
             return position;
          }

          // Otherwise, search for the next occurrence
          position = phrase.indexOf(goal, position + 1);
       }

       return -1; // Not found
    }

    /**
     * Returns the chatbot's initial greeting.
     */
    public String getGreeting()
    {
       return "Hello, let's talk. Type in \"Bye\" to end our chat";
    }

    /**
     * Chooses a random response when no specific rule applies.
     */
    private String getRandomResponse()
    {
       final int NUMBER_OF_RESPONSES = 6; // total number of possible responses

       // Randomly pick one of the six
       int whichResponse = (int)(Math.random() * NUMBER_OF_RESPONSES);
       String response = "";

       // Assign one of the generic responses
       if (whichResponse == 0)
       {
           response = "Interesting.";
       }
       else if (whichResponse == 1)
       {
          response = "Okay.";
       }
       else if (whichResponse == 2)
       {
          response = "I haven't heard that before.";
       }
       else if (whichResponse == 3)
       {
          response = "What else could you tell me about that?";
       }
       else if (whichResponse == 4)
       {
          response = "Where did you hear that?";
       }
       else if (whichResponse == 5)
       {
          response = "Please, go on.";
       }

       return response;
    }
}
