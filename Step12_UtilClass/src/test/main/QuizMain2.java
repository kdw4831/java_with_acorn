package test.main;

import java.util.ArrayList;
import java.util.List;

import test.myPac.PostDto;

/*
 * 글 목록을 ArrayList에 담아 보세요
 * 
 * 글 하나는
 * 글번호, 작성자, 제목으로 이루어져 있다고 가정합니다.
 * 
 * 글 3개의 정보를 ArrayList에 담고, 반복문을 돌면서 담긴 내용을 출력해보세요.
 * 
 * 글 하나를 담을 dto 클래스를 알아서 만들어 보세요(클래스명, 필드명)
 */

public class QuizMain2 {
	public static void main(String[] args) {
		List<PostDto> list = new ArrayList<PostDto>();
		PostDto dto1=new PostDto(1,"김구라","노량진에서");
		PostDto dto2=new PostDto(2,"해골","행신동에서");
		PostDto dto3=new PostDto(3,"원숭이","동물원에서");
		
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		for(PostDto tmp:list) {
			String result=String.format("글번호:%d, 작성자:%s, 제목:%s",
					tmp.getNum(),tmp.getWriter(),tmp.getTitle());
			System.out.println(result);
		}
		
		
	}
}
