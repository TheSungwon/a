/*ReplyingRequest�� �亯 ���� ��û ������ ǥ���ϴ� Ŭ�����μ� WritingRequest�� ����������
����, �ۼ���,�̸�,��ȣ,������ �����ϰ� ������ �߰��� �亯�� ����� �θ� �Խñ��� ID������
WritingRequestŬ������ ��ӹ޾� ReplyingRequestŬ���� ����*/

package DTO_javaBean;

public class ReplyingRequest extends WritingRequest{
	
	private int parentArticleId;
	
	public int getParentArticleId() {
		return parentArticleId;
	}
	
	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}
}
