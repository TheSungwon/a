package tiless;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;

public class MenuViewPreparer implements ViewPreparer{
	
	public void execute(TilesRequestContext tilesContext, AttributeContext attContext) {
		List<MenuItem> userMenus = new ArrayList<MenuItem>();
		userMenus.add(new MenuItem("menu1", "link1"));
		userMenus.add(new MenuItem("menu2", "link2"));
		userMenus.add(new MenuItem("menu3", "link3"));
		
		tilesContext.getRequestScope().put("userMenus", userMenus);
		
		List<MenuItem> adminMenus = new ArrayList<MenuItem>();
		adminMenus.add(new MenuItem("MENU1", "link1"));
		adminMenus.add(new MenuItem("MENU2", "link2"));
		adminMenus.add(new MenuItem("MENU3", "link3"));
		
		attContext.putAttribute("adminMenus", new Attribute(adminMenus), true);
	}
	

}
