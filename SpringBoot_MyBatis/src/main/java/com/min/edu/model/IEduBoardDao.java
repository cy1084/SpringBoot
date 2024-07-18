package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.min.edu.dto.EduBoardDto;

/*
 * springboot에서 mybatis 개발의 핵심은 interface에 @Mapper를 선언해주는 것!
 * @Mapper로 선언된 인터페이스는 자동으로 impl이 생기는 것과 같다
 * 인터페이스의 메소드를 호출하기만 하면 정해진 경로에 있는 쿼리가 실행되고 결과를 반환
 */
@Mapper
public interface IEduBoardDao {
	
	//1번째 방법)  Mybatis의 인터페이스 매퍼 방법
	//			 쿼리문이 복잡해지거나 인터페이스가 많아지면 가독성 떨어짐
	//			 id, 반환 타입, argument를 고민할 필요 없이 직접 사용할 수 있다는 게 장점
	@Select("SELECT SEQ,ID,TITLE,CONTENT,DELFLAG,CREATEAT FROM EDUBOARD ORDER BY CREATEAT DESC")
	public List<EduBoardDto> selectBoardInterface();
	
	
	//2번째 방법) Mybatis의 xml 매퍼 방법
	/*
	 * public vlass EduBoardDaoImpl implements IEduBoardDao{
	 * 	private SqlSessionTemplage session
	 * 	private final String NS=
	 * 	..
	 *	session.selectList(NS+"selectBoardXML");
	 * }
	 * 이게 아래 한 줄과 같음
	 */			
	public List<EduBoardDto> selectBoardXML();
}
