package Implementation;

import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> ACM ICPC Team
 *	Easy
 */
public class AcmIcpcTeam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextInt();
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        in.close();
        int[] result = calculateMostFeildsAndHowMany(topic);
        System.out.println(result[0]);
        System.out.println(result[1]);
	}
	
	public static int[] calculateMostFeildsAndHowMany(String[] topic) {
		int mostFeilds = -1;
		int peopleWithMostFeilds = -1;
		//System.out.println(topic.length);
		//System.out.println(topic[0].length());
		for(int i = 0; i < topic.length - 1; i++) {
			for(int j = i + 1; j < topic.length; j++) {
				int feildTrack = 0;
				for(int k = 0; k < topic[i].length(); k++) {
					int bit1 = Character.getNumericValue(topic[i].charAt(k));
					int bit2 = Character.getNumericValue(topic[j].charAt(k));
					if(bit1 == 1 || bit2 == 1) feildTrack++;
				} // for k
				//System.out.println(feildTrack);
				if(feildTrack > mostFeilds) {
					mostFeilds = feildTrack;
					peopleWithMostFeilds = 1;
				} else if(feildTrack == mostFeilds) {
					peopleWithMostFeilds++;
				}
			} // for j
		} // for i
		int[] results = {mostFeilds, peopleWithMostFeilds};
		return results;
	}
}
