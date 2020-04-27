package com.tm.s5.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tm.s5.member.MemberService;
import com.tm.s5.member.MemberVO;
import com.tm.s5.member.memberFile.MemberFileDAO;
import com.tm.s5.member.memberFile.MemberFileVO;
import com.tm.s5.util.FileSaver;
import com.tm.s5.util.Pager;

@Service
public class UserService implements MemberService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public int memberDeletes(List<String> list) throws Exception{
		return userDAO.memberDeletes(list);
	}
	
	public int memberDelete(UserVO userVO) throws Exception{
		return userDAO.memberDelete(userVO);
	}
	
	public UserVO memberIdCheck(String id) throws Exception{
		return userDAO.memberIdCheck(id);
	}
	
	
	public int memberUpdate(MemberVO memberVO) throws Exception{
		return userDAO.memberUpdate(memberVO);
	}
	
	public int fileDelete(String id,HttpSession session) throws Exception{
		
		MemberFileVO memberFileVO = memberFileDAO.fileSelect(id);
		String path = session.getServletContext().getRealPath("resources/memberUpload");
		
		int result = memberFileDAO.fileDelete(id);
		if(result > 0) {
			result = fileSaver.deleteFile(memberFileVO.getFileName(), path);
		}
		
		return result;
	}
	
//	public MemberFileVO fileSelect(String id) throws Exception{
//		return memberFileDAO.fileSelect(id);
//	}
	
	public int memberJoin(MemberVO memberVO,MultipartFile avatar,HttpSession session)throws Exception{
		//HDD에 저장 위치 설정 (시작은 무조건 /resources/images/memberUpload)0
 		//1. 실제경로
		String path = session.getServletContext().getRealPath("/resources/memberUpload");
		
		String fileName = fileSaver.saveByUtils(avatar,path);

		int result = userDAO.memberJoin(memberVO);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId(memberVO.getId());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(avatar.getOriginalFilename());
		result = memberFileDAO.fileInsert(memberFileVO);
		
		return result;
	}
	
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return userDAO.memberLogin(memberVO);
	}

	@Override
	public List<MemberVO> memberList(Pager pager) throws Exception {
		pager.makeRow();
		
		long totalCount = userDAO.memberCount(pager);
		pager.makePage(totalCount);
		
		
		return userDAO.memberList(pager);
	}


	
	
	
	
	
	
}
