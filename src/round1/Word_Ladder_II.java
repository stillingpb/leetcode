package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_II {
	public static void main(String[] args) {
		Word_Ladder_II w = new Word_Ladder_II();
		HashSet<String> dict = new HashSet<String>();
		String[] words = { "a", "b", "c" };
		for (String word : words)
			dict.add(word);

		List<List<String>> list = w.findLadders("a", "c", dict);
		for (List<String> l : list)
			System.out.println(l);
	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> ans = new ArrayList<List<String>>();
		ArrayList<String> words = getWords(start, end, dict);
		ArrayList<String>[] nearWords = createNearWords(words);
		Map<String, Integer> path = new HashMap<String, Integer>();
		bfs(start, end, words, nearWords, path);
		if (path.get(end) != null)
			dfs(end, start, words, nearWords, path, ans, new ArrayList<String>(), path.get(end));
		return ans;
	}

	private void dfs(String start, String end, ArrayList<String> words, ArrayList<String>[] nearWords,
			Map<String, Integer> path, List<List<String>> ans, ArrayList<String> list, int deep) {
		if (deep == 1 && start.equals(end)) {
			ArrayList<String> tmp = new ArrayList<String>(list);
			tmp.add(end);
			Collections.reverse(tmp);
			ans.add(tmp);
			return;
		}
		list.add(start);
		int index = Collections.binarySearch(words, start);
		ArrayList<String> nears = nearWords[index];
		for (String near : nears) {
			if (deep - 1 != path.get(near))
				continue;
			dfs(near, end, words, nearWords, path, ans, list, deep - 1);
		}
		list.remove(list.size() - 1);
	}

	private void bfs(String start, String end, ArrayList<String> words, ArrayList<String>[] nearWords,
			Map<String, Integer> path) {
		boolean[] visited = new boolean[words.size()];
		Queue<String> wordQueue = new LinkedList<String>();
		Queue<Integer> deepQueue = new LinkedList<Integer>();
		wordQueue.offer(start);
		deepQueue.offer(1);
		int index = Collections.binarySearch(words, start);
		visited[index] = true;
		while (!wordQueue.isEmpty()) {
			String w = wordQueue.poll();
			int deep = deepQueue.poll();
			path.put(w, deep);
			index = Collections.binarySearch(words, w);
			for (String near : nearWords[index]) {
				int i = Collections.binarySearch(words, near);
				if (visited[i])
					continue;
				visited[i] = true;
				wordQueue.add(near);
				deepQueue.add(deep + 1);
			}
		}
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

	private ArrayList<String> getWords(String start, String end, Set<String> dict) {
		ArrayList<String> words = new ArrayList<String>();
		words.addAll(dict);
		if (-1 == words.indexOf(start))
			words.add(start);
		if (-1 == words.indexOf(end))
			words.add(end);
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
