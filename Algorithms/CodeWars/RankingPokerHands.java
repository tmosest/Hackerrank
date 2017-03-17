package CodeWars;
/**
 * Ranking Poker Hands
 * @author tmosest
 */
import java.util.*;

public class PokerHand
{      
	
    private enum Result { TIE, WIN, LOSS }
    /*
     * Hand rankings 
     */
    private enum HandRankings {
    	// Ace high Straight Flush
    	ROYAL_FLUSH,
    	// Hand Containing five cards of sequential rank, same suit
    	STRAIGHT_FLUSH, 
    	// Four cards of same rank
    	FOUR_OF_KIND, 
    	// 3 cards of one rank, two of another
    	FULL_HOUSE, 
    	// 5 cards of same suit not sequential rank
    	FLUSH, 
    	// Sequential rank not same order
    	STRAIGHT, 
    	// Three cards of same rank
    	THREE_OF_KIND,
    	// Two pairs of same rank
    	TWO_PAIR,
    	// One pair of same rank
    	ONE_PAIR,
    	// High card
    	HIGH_CARD
    } 
    
    private HashMap<Character, Integer> rankCounts, suitCounts;
    private int highValue;
    public int ranking;
    // We are given something like "KS 2H 5C JD TD" 
    PokerHand(String hand)
    {
    	highValue = 0; 
    	ranking = 0;
    	rankCounts = new HashMap<Character, Integer> ();
    	suitCounts = new HashMap<Character, Integer> ();
    	
    	String[] cards = hand.split(" ");
    	for(String card : cards) {
    		char rank = card.charAt(0);
    		char suit = card.charAt(1);
    		int rankCount = (rankCounts.get(rank) == null) ? 0 : rankCounts.get(rank);
    		rankCounts.put(rank, ++rankCount);
    		int suitCount = (suitCounts.get(rank) == null) ? 0 : suitCounts.get(rank);
    		rankCounts.put(rank, ++rankCount);
    	}
    }

    public Result compareWith(PokerHand hand) {        
        
    	return Result.TIE;
        
    }
}
