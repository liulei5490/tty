package blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blog.bean.Respond;


public class MyTest {
	public static void main(String[] args) {
		Map<Respond,List<Respond>> map = new HashMap<>();
		Respond resp = new Respond("1","1","1","1","1","1","1","1","1");
		Respond res = new Respond("1","1","1","1","1","1","1","1","1");
		System.out.println(map.isEmpty());
		map.put(resp, new ArrayList<Respond>());
		System.out.println(map.containsKey(res));
	}
}
