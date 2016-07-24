package topcoder;

import org.w3c.dom.UserDataHandler;

public class MatchMaker {
	
	public String[] getBestMatches(String[] members, String currentUser, int sf){
		String [] matches = new String [50];
		String userGender = "";
		String reqGender = "";
		String [] memData ;
		String [] userAns = null;
		String [] matched = null;
		int numOfQ = 0;
		int userIndex = 0;
		
		boolean isMember = false;
		int count = 0;
		int memCount = 0;
		
		for (int i=0; i < members.length; i++) {
			memData = members[i].split(" ");
			//System.out.println(memData[0]);
			if  (memData[0].equals(currentUser)) {
				userGender = memData[1];
				reqGender = memData[2];
				numOfQ = memData.length - 3;
				userAns = new String [numOfQ];
				for (int j=0; j < numOfQ; j++) {
					
					userAns[j] = new String();
					userAns[j] = memData[j+3];
				}
				isMember = true;
				userIndex = i;
				break;
			}
		}
		
		if (sf < numOfQ && isMember) {
			for (int i=0; i < members.length; i++) {
				if  (i != userIndex ) {
					memData =  members[i].split(" ");
					if (memData[1].equals(reqGender))  {
						for (int k=0; k < userAns.length; k++) {
							if (userAns[k].equals(memData[k+3])) {
								++count;
							}
						}
						if (count >= sf)  {
							matches[memCount] = new String();
							matches[memCount] = memData[0] + " " + count;
							++memCount;
							count = 0;
						}
					}
				}
			}
			for (int i=0; i < memCount ; i++) {
				for (int j=0 ; j < memCount - 1; j++) {
					String [] d1 = matches[j].split(" ");
					String [] d2 = matches[j+1].split(" ");
					//System.out.println(d1[0]);
					
					if (Integer.parseInt(d1[1])  < Integer.parseInt(d2[1])) {
						String temp = matches[j];
						matches[j] = matches[j+1];
						matches[j+1] = temp;
					}
				}				
			}
			matched = new String [memCount];
			for (int i=0; i < memCount; i++) {
				matched[i] = matches[i];
			}
			return matched;
		} else {
			return matches;
		}
		
		
	}
	
	public static void main(String [] args) {
		String [] members = {"BETTY F M A A C C",
			 "TOM M F A D C A",
			 "SUE F M D D D D",
			 "ELLEN F M A A C A",
			 "JOE M F A A C A",
			 "ED M F A D D A",
			 "SALLY F M C D A B",
			 "MARGE F M A A C C"};
		String currentUser = "TOM";
		int sf = 2;
		
		MatchMaker obj = new MatchMaker();
		
		String [] matches = obj.getBestMatches(members, "MARGE", 4);
		
		if (matches != null ) {
			for (int i=0;i < matches.length; i++) {
				System.out.println(matches[i]);
			}
		} else {
			System.out.println("NULL");
		}
	}
}
