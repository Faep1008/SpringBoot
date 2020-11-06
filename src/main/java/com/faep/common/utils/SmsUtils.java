package com.faep.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.faep.common.enums.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 描述： 短信操作工具类
 * 作者： Faep
 * 创建时间： 2020-10-23 15:51
 * 版本： [1.0, 2020-10-23]
 * 版权： Faep
 */
public class SmsUtils
{
    private static final String TIMEOUT = "10000";
    private static final String SIGNNAME = "PJ家庭管理系统";
    private static final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
    private static final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
    private static final Logger log = LoggerFactory.getLogger(SmsUtils.class);

    /**
     * 发送短信
     * 分钟级控制流Permits:5
     * 小时级流控流Permits:5
     * 日历天级流控流Permits:10
     * 
     * @param phoneNum
     * @param code
     */
    public static String sendSms(String phoneNum, String code, String templateCode, String ACCESSKEYID, String ACCESSKEYSECRET) {
        // 设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", TIMEOUT);
        System.setProperty("sun.net.client.defaultReadTimeout", TIMEOUT);
        // 初始化ascClient需要的几个参数
        // 替换成你的AK
        final String accessKeyId = ACCESSKEYID;// 你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = ACCESSKEYSECRET;// 你的accessKeySecret，参考本文档步骤2
        // 初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        }
        catch (ClientException e) {
            log.error("短信验证码发送异常！", e);
            return "Error";
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        // 使用post提交
        request.setMethod(MethodType.POST);
        // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        request.setPhoneNumbers(phoneNum);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGNNAME);
        // 必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode(templateCode);
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        // 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        // 参考：request.setTemplateParam("{\"变量1\":\"值1\",\"变量2\":\"值2\",\"变量3\":\"值3\"}")
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        // 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");

        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        // request.setOutId("yourOutId");

        // 请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        }
        catch (ClientException e) {
            log.error("短信验证码发送异常！", e);
            return "Error";
        }
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals(ResultVO.SUCCESS.getValue())) {
            log.info(phoneNum + " 短信验证码发送成功！");
            return ResultVO.SUCCESS.getValue();
        }
        System.out.println(phoneNum + " 短信发送失败：" + sendSmsResponse.getMessage() + "," + sendSmsResponse.getCode());
        log.info(phoneNum + " 短信发送失败：" + sendSmsResponse.getMessage() + "," + sendSmsResponse.getCode());
        return ResultVO.ERROR.getValue();
    }

    /**
     * 查询短信
     * 
     * @param phoneNum
     */
    public static void querySms(String phoneNum, String ACCESSKEYID, String ACCESSKEYSECRET) {
        // 设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", TIMEOUT);
        System.setProperty("sun.net.client.defaultReadTimeout", TIMEOUT);
        // 此处需要替换成开发者自己的AK信息
        final String accessKeyId = ACCESSKEYID;
        final String accessKeySecret = ACCESSKEYSECRET;

        // 初始化ascClient
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);

        // 组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        // 必填-号码
        request.setPhoneNumber(phoneNum);
        // 可选-调用发送短信接口时返回的BizId
        // request.setBizId("1234567^8901234");
        // 必填-短信发送的日期 支持30天内记录查询（可查其中一天的发送数据），格式yyyyMMdd
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        request.setSendDate(dateStr);
        // 必填-页大小
        request.setPageSize(10L);
        // 必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        // hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = null;
        try {
            querySendDetailsResponse = acsClient.getAcsResponse(request);
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        // 获取返回结果
        if (querySendDetailsResponse.getCode() != null && querySendDetailsResponse.getCode().equals("OK")) {
            List<QuerySendDetailsResponse.SmsSendDetailDTO> smsSendDetailDTOs = querySendDetailsResponse
                    .getSmsSendDetailDTOs();
            for (QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : smsSendDetailDTOs) {
                System.out.println(smsSendDetailDTO);
            }
            System.out.println("短信查询，请求成功！");
        }
    }

}
