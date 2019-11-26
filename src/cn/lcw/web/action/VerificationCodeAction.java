package cn.lcw.web.action;

import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VerificationCodeAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("visit VerificationCodeAction!!!!");
		HttpServletRequest request = ServletActionContext.getRequest();
		String phone = request.getParameter("phoneNumber");
		if(phone == null || "".equals(phone)) {
			System.out.println("ERROR");
			return "success";
		}
		System.out.println(phone);
		final String accessKeyId = "LTAIluIdnWI4vAwN";
		final String accessSecret = "5aS8Tb6AKhpeUGD6WofK0U547M7bdP";
		String code = "";
		UUID uuid = UUID.randomUUID();
		long bits = uuid.getLeastSignificantBits();
		Random rand = new Random(bits);
		for(int i = 0;i < 4;i++)
			code += rand.nextInt(10);
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest comrequest = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        comrequest.setMethod(MethodType.POST);
        comrequest.setDomain("dysmsapi.aliyuncs.com");
        comrequest.setVersion("2017-05-25");
        comrequest.setAction("SendSms");
        comrequest.putQueryParameter("RegionId", "cn-hangzhou");
        comrequest.putQueryParameter("PhoneNumbers", phone);
        comrequest.putQueryParameter("SignName", "CRM");
        comrequest.putQueryParameter("TemplateCode", "SMS_167040753");
        comrequest.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse comresponse = client.getCommonResponse(comrequest);
            System.out.println(comresponse.getData());
            ActionContext.getContext().getSession().put("verificationCode", code);
            System.out.println("验证码已发送！code:" + code);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "success";      
	}
	

}
