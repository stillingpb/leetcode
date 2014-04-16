package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {
	public static void main(String[] args) {
		Word_Ladder w = new Word_Ladder();
		HashSet<String> dict = new HashSet<String>();
		String[] words = { "dose", "ends", "dine", "jars", "prow", "soap",
				"guns", "hops", "cray", "hove", "ella", "hour", "lens", "jive",
				"wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull",
				"york", "ruts", "lily", "vamp", "bask", "peer", "boat", "dens",
				"lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx",
				"mows", "toke", "soto", "dork", "nape", "mans", "loin", "jots",
				"male", "sits", "minn", "sale", "pets", "hugo", "woke", "suds",
				"rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh",
				"sulk", "vice", "clod", "iowa", "gibe", "shad", "carl", "huns",
				"coot", "sera", "mils", "rose", "orly", "ford", "void", "time",
				"eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt",
				"rung", "rich", "saga", "lust", "yews", "rode", "many", "cods",
				"rape", "last", "tile", "nosy", "take", "nope", "toni", "bank",
				"jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins",
				"cult", "hart", "wuss", "tale", "sing", "lake", "bogy", "wigs",
				"kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns",
				"will", "tart", "drug", "gale", "mold", "disk", "spay", "hows",
				"naps", "puss", "gina", "kara", "zorn", "boll", "cams", "boas",
				"rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs",
				"ohio", "nibs", "cuts", "pups", "data", "kate", "rump", "hews",
				"mary", "stow", "fang", "bolt", "rues", "mesh", "mice", "rise",
				"rant", "dune", "jell", "laws", "jove", "bode", "sung", "nils",
				"vila", "mode", "hued", "cell", "fies", "swat", "wags", "nate",
				"wist", "honk", "goth", "told", "oise", "wail", "tels", "sore",
				"hunk", "mate", "luke", "tore", "bond", "bast", "vows", "ripe",
				"fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair",
				"tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy",
				"siva", "oops", "toed", "bale", "hutu", "jolt", "rife", "darn",
				"tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems",
				"bill", "cord", "pert", "type", "kroc", "ucla", "albs", "yoko",
				"silt", "pock", "drub", "puny", "fads", "mull", "pray", "mole",
				"talc", "east", "slay", "jamb", "mill", "dung", "jack", "lynx",
				"nome", "leos", "lade", "sana", "tike", "cali", "toge", "pled",
				"mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs",
				"race", "toss", "mild", "tops", "maze", "city", "sadr", "bays",
				"poet", "volt", "laze", "gold", "zuni", "shea", "gags", "fist",
				"ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo",
				"hume", "yowl", "craw", "pied", "toga", "lobs", "love", "lode",
				"duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe",
				"pele", "suez", "nina", "ring", "okra", "warm", "lyle", "gape",
				"bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope",
				"hang", "made", "fobs", "gamy", "fort", "peak", "gill", "dino",
				"dina", "tier" };
		for (String word : words)
			dict.add(word);
		long t1 = System.currentTimeMillis();
		int len = w.ladderLength("nape", "mild", dict);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		System.out.println(len);
	}
	
    public int ladderLength2(String start, String end, HashSet<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        List<String> queue = new ArrayList<String>();
        int level = 1;
        queue.add(start);
        int begin = 0;
        char[] endCharArray = end.toCharArray();
        Set<String> used = new HashSet<String>();
        used.add(start);
        while (begin < queue.size()) {
            int tail = queue.size();
            for (int i = begin; i < tail; i++) {
                char[] word = queue.get(i).toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char currentChar = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == currentChar) {
                            continue;
                        }
                        word[j] = c;
                        if (Arrays.equals(word, endCharArray)) {
                            return level + 1;
                        }
                        String nextWord = new String(word);
                        if (dict.contains(nextWord)
                                && !used.contains(nextWord)) {
                            used.add(nextWord);
                            queue.add(nextWord);
                        }
                        word[j] = currentChar;
                    }
                }
            }
            level++;
            begin = tail;
        }
        return 0;
    }


	public int ladderLength(String start, String end, HashSet<String> dict) {

		ArrayList<String> words = getWords(start, end, dict);
		ArrayList<String>[] nearWords = createNearWords(words);
		return ladderLength(start, end, words, nearWords);
	}

	private int ladderLength(String start, String end, ArrayList<String> words,
			ArrayList<String>[] nearWords) {
		Queue<String> wordQueue = new LinkedList<String>();
		Queue<Integer> deepQueue = new LinkedList<Integer>();
		wordQueue.offer(start);
		deepQueue.offer(1);

		boolean visited[] = new boolean[words.size()];
		int index = Collections.binarySearch(words, start);
		visited[index] = true;

		while (!wordQueue.isEmpty()) {
			String word = wordQueue.poll();
			int deep = deepQueue.poll();
			if (word.equals(end))
				return deep;
			index = Collections.binarySearch(words, word);
			for (String nearWord : nearWords[index]) {
				index = Collections.binarySearch(words, nearWord);
				if (visited[index] == true)
					continue;
				visited[index] = true;
				wordQueue.offer(nearWord);
				deepQueue.offer(deep + 1);
			}
		}
		return 0;
	}

	private ArrayList<String>[] createNearWords(ArrayList<String> wordList) {
		int len = wordList.size();
		ArrayList<String>[] nearWords = new ArrayList[len];
		for (int i = 0; i < len; i++)
			nearWords[i] = new ArrayList<String>();

		for (int i = 0; i < len; i++) {
			String wi = wordList.get(i);
			for (int j = i + 1; j < len; j++) {
				String wj = wordList.get(j);
				if (isNear(wi, wj)) {
					nearWords[i].add(wj);
					nearWords[j].add(wi);
				}
			}
		}
		return nearWords;
	}

	private ArrayList<String> getWords(String start, String end,
			HashSet<String> dict) {
		ArrayList<String> words = new ArrayList<String>();
		words.add(start);
		words.add(end);
		words.addAll(dict);
		Collections.sort(words);
		return words;
	}

	private boolean isNear(String w1, String w2) {
		int diff = 0;
		int len = w1.length();
		for (int i = 0; i < len; i++) {
			if (w1.charAt(i) != w2.charAt(i)) {
				if (diff == 0)
					diff++;
				else
					return false; // more diff
			}
		}
		if (diff == 0) // no diff
			return false;
		return true;
	}
}
