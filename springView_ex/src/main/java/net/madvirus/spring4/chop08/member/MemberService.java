package net.madvirus.spring4.chop08.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberService {
	
	private int nextMemberId = 0;
	private Map<String, MemberInfo> memberMap = new HashMap<>();

	public MemberService() {
		memberMap.put("m1", new MemberInfo("m1", "asd", "asd@asd.com", "asd", false, new Address()));
		memberMap.put("m2", new MemberInfo("m2", "asdf", "asdf@asdf.com", "asdf", false, new Address()));
		
	}
	
	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}
	
	public List<MemberInfo> getMembers(){
		return new ArrayList<MemberInfo>(memberMap.values());
	}
	
	public void registeNewMember(MemberRegistRequest memRegReq) {
		MemberInfo mi = new MemberInfo("m"+nextMemberId, memRegReq.getName(), memRegReq.getEmail(), memRegReq.getPassword(), memRegReq.isAllowNoti(), memRegReq.getAddress());
		memberMap.put(mi.getId(), mi);
		
	}
	
	public MemberInfo getMemberInfoByEmail(String email) {
		for (MemberInfo mi : memberMap.values()) {
			if(mi.getEmail().equals(email))
				return mi;
		}
		return null;
	}
	
}

