package ex.ch1.mv;

import java.util.List;

public class MavenBuildRunner implements BuildRunner {
	
	private String mavenPath;
	

	
	@Override
	public void build(List<String> srcDirs, String binDir) {
		String info = "���̺���" + mavenPath +"\n";
		
		for(String srcdir : srcDirs) {
			info += "�ҽ����" + srcdir +"\n";
			info +="Ŭ�������"+binDir+"\n";
			
			System.out.printf("MavenBuildReunner.build ����\n%s",info);
		}
		
		
		
	}
	
	
	public void setMavenPath(String mavenPath) {
		this.mavenPath = mavenPath;
	}

}
