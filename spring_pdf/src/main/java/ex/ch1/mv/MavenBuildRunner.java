package ex.ch1.mv;

import java.util.List;

public class MavenBuildRunner implements BuildRunner {
	
	private String mavenPath;
	

	
	@Override
	public void build(List<String> srcDirs, String binDir) {
		String info = "메이븐경로" + mavenPath +"\n";
		
		for(String srcdir : srcDirs) {
			info += "소스경로" + srcdir +"\n";
			info +="클래스경로"+binDir+"\n";
			
			System.out.printf("MavenBuildReunner.build 실행\n%s",info);
		}
		
		
		
	}
	
	
	public void setMavenPath(String mavenPath) {
		this.mavenPath = mavenPath;
	}

}
