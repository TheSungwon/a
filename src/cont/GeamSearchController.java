package cont;

import java.util.ArrayList;
import java.util.List;

import ser.SearchCommand;
import ser.SearchType;
import ser.SearchResult;
import ser.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeamSearchController {
	
	@Autowired
	private SearchService searchService;
	
	@ModelAttribute("searchList") //jsp로 보내는 이름
	public List<SearchType> searchList(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2,"아이템"));
		options.add(new SearchType(3,"캐릭터"));
		return options;
	}
	
	@ModelAttribute("queryList")
	public String[] queryList() {
		return new String[] {"겜","창천","위메이드"};
		
		
	}
	
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) {
		ModelAndView mav = new ModelAndView("search/game"); //game.jsp
		System.out.println("검색어"+command.getQuery().toUpperCase()); //대문자로
		
		SearchResult result = searchService.search(command);
		mav.addObject("searchResult",result);
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNull(NullPointerException e) {
		return "error/nullException";
	}
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	

}
