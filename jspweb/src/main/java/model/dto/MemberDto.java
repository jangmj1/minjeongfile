package model.dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberDto {

	private int mno ;
	private String mid ;
	private String mpwd;
	private String mimg;
	private String memail;
	
	// 1.이메일 번송 메소드 [받는 사람 이메일,받는 내용 html]
	public boolean sendEmail(String toEemail, String contentHtml) {
		//1. 보내는 사람의 정보
		String fromEmail = "sksk1277@naver.com"; //보내는 사람의 이메일
		String emailpwd = "minjeongqt1!";	//보내는 사람의 이메일에 패스워드
		
		//2.호스팅설정[네이버 기준]
		Properties properties=new Properties();
		properties.put("mail.smtp.host", "smtp.naver.com");		//만약에 구글일시   "smtp.gmail.com"
		properties.put("mail.smtp.port", 587);					//동일
		properties.put("mail.smtp.auth", true);					//동일
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");	//동일
		
		//3.인증처리
			//[Session : import javax.mail.Session; 이걸로쓰기]
			//[Authenticator : import javax.mail.Authenticator; 이걸로쓰기]
			//[PasswordAuthentication : javax.mail.PasswordAuthentication; 이걸로쓰기]
		Session session=Session.getDefaultInstance(
				properties,new Authenticator() {
					//패스워드 인증 함수를 오버라이딩 하기
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, emailpwd);
					}
					
		});
		
		//4.메일 보내기
		
		try {
			//Mime 프로토콜 : smtp 가 보낼수 있는 표준 형식[포멧]
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEemail));
			
			//내용구성
			message.setSubject("Ezen Community 회원가입 메일 인증코드");//메일제목
			message.setText(contentHtml);
			
			//전송
			Transport.send(message); //메세지 전송 포트
			 return true; // 메일 전송 성공
		} catch (Exception e) {
			return false; // 메일 전송 실패
		}
				
		
		
		
	}
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setmid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	
}
