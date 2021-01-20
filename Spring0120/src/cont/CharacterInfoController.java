package cont;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Ãâ·Â http://localhost:8089/Spring0120/game/users/dddddd/characters/10
@Controller
@RequestMapping("/game/users/{userId}")
public class CharacterInfoController {
	
	@RequestMapping("/characters/{characterId}")
	public String characterInfo(@PathVariable String userId, @PathVariable int characterId, ModelMap model) {
		model.addAttribute("userId",userId);
		model.addAttribute("characterId",characterId);
		return "game/character/info";
	}

}
